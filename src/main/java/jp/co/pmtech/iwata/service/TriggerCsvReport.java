package jp.co.pmtech.iwata.service;

import java.io.FileWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.time.ExecutionTime;
import com.cronutils.parser.CronParser;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;

import jp.co.pmtech.iwata.dto.UiPathTriggerDto;

public class TriggerCsvReport implements TriggerReport {

    public TriggerCsvReport() {

    }
    
    public void write(String dest, List<UiPathTriggerDto> triggerList) throws Exception {

        Writer writer = new FileWriter(dest);
        CSVWriterBuilder builder = new CSVWriterBuilder(writer);

        try (ICSVWriter csvWriter = builder.build()) {

            csvWriter.writeNext(new String[] { "トリガー名", "プロセス名", "次回実行日", "次回実行時刻", "次々回" }, false);
            
            for (UiPathTriggerDto trigger : triggerList) {

                // 無効なトリガーはスキップ
                if (!"true".equals(trigger.getEnabled())) {
                    continue;
                }

                // 日付フォーマット変換
                SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
                SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

                // 次回時刻を取得
                Date nextOccurrense = dateParser.parse(trigger.getStartProcessNextOccurrence());
                String date = dateFormatter.format(nextOccurrense);
                String time = timeFormatter.format(nextOccurrense);;

                // さらに次回を計算してみる
                String afterNext = dateParser.format(getNextRunningDate(trigger.getStartProcessCron(), nextOccurrense));

                // 出力
                csvWriter.writeNext(new String[] {
                    trigger.getName(),
                    trigger.getPackageName(),
                    date,
                    time,
                    afterNext
                }, false);

            }
        }

        writer.close();
    }

    
    private Date getNextRunningDate(String cronexp, Date nextOccurense) {

        // APIの戻り値にある次回実行時刻を基準時刻
        ZonedDateTime baseDateTime = ZonedDateTime.ofInstant(nextOccurense.toInstant(), ZoneId.systemDefault());

        // 基準時刻の次回を計算
        CronParser cronParser = new CronParser(CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ));
        ExecutionTime executionTime = ExecutionTime.forCron(cronParser.parse(cronexp));
        Optional<ZonedDateTime> nextExecution = executionTime.nextExecution(baseDateTime);

        return Date.from(nextExecution.get().toInstant());
    }

}
 