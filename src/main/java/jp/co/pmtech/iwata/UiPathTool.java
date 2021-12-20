package jp.co.pmtech.iwata;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.kohsuke.args4j.Option;

import jp.co.pmtech.iwata.common.JsonHttpClient;
import jp.co.pmtech.iwata.dto.UiPathTriggerDto;
import jp.co.pmtech.iwata.service.TriggerCsvReport;
import jp.co.pmtech.iwata.service.TriggerReport;
import jp.co.pmtech.iwata.service.UiPathAuthenticator;
import jp.co.pmtech.iwata.service.UiPathFolder;
import jp.co.pmtech.iwata.service.UiPathTrigger;

public class UiPathTool {
  
    @Option(name="-h", aliases={"--host"}, metaVar="[Orchestrator Host Name]", required=true)
    private static String hostName;

    @Option(name="-t", aliases={"--tenant"}, metaVar="[Tenant Name]", required=true)
    private static String tenantName;

    @Option(name="-u", aliases={"--user"}, metaVar="[Login User Name]", required=true)
    private static String userName;

    @Option(name="-p", aliases={"--password"}, metaVar="[Login Password]", required=true)
    private static String password;

    @Option(name="-f", aliases={"--folder"}, metaVar="[Folder Name]", required=true)
    private static String folderName;

    @Option(name="-o", aliases={"--output"}, metaVar="[Output Path]", required = true)
    private static String outputPath;

    public void execute() {

        try {
            JsonHttpClient httpClient = new JsonHttpClient(hostName, true);

            // テナントの認証
            UiPathAuthenticator auther = new UiPathAuthenticator(httpClient);
            String bearerString = auther.auth(tenantName, userName, password);

            // フォルダーの取得
            UiPathFolder folder = new UiPathFolder(httpClient, bearerString);
            folder.init(bearerString);
            String folderId = folder.getId(folderName);

            // トリガーの取得
            UiPathTrigger trigger = new UiPathTrigger(httpClient, bearerString, folderId);
            trigger.init(bearerString, folderId);

            // トリガーを時系列に取得
            List<UiPathTriggerDto> triggerList = trigger.getDateTimeOrdered();

            // CSVに出力
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String filename = "Report" + sdf.format(new Date()) + ".csv";
            outputPath = (outputPath.endsWith("\\") ? outputPath : outputPath + "\\") + filename;
            TriggerReport report = new TriggerCsvReport();
            report.write(outputPath, triggerList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
