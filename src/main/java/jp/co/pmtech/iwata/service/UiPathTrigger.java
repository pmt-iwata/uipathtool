package jp.co.pmtech.iwata.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;

import jp.co.pmtech.iwata.common.JsonHttpClient;
import jp.co.pmtech.iwata.dto.UiPathTriggerDto;

public class UiPathTrigger {

    private JsonHttpClient httpClient;

    private List<UiPathTriggerDto> triggerArray;

    public UiPathTrigger(JsonHttpClient httpClient, final String bearerToken, final String folderId) throws Exception {
        this.httpClient = httpClient;
    }

    public void init(final String bearerToken, final String folderId) throws Exception {

        BasicHeader header = new BasicHeader("X-UIPATH-OrganizationUnitId", folderId);
        Header[] headers = new Header[] {header};
        HttpResponse response = this.httpClient.get("/odata/ProcessSchedules", bearerToken, headers);

        // 結果の取得
        HttpEntity entity = response.getEntity();
        String resultJson = IOUtils.toString(entity.getContent(), "UTF-8");
        // 200 OKであること
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new Exception("トリガーの取得に失敗しました。" + response.getStatusLine().getReasonPhrase() + ":" + resultJson);
        }
        
        // 変換されたフォルダー情報を取得
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(resultJson);
        UiPathTriggerDto[] triggerArray = mapper.readValue(node.get("value").toString(), UiPathTriggerDto[].class);

        // インスタンスに保持
        this.triggerArray = Arrays.asList(triggerArray);
    }
    
    /**
     * 次回実行時刻でソートされた結果を返す。
     * @return
     */
    public List<UiPathTriggerDto> getDateTimeOrdered() {
        return this.triggerArray.stream()
            .sorted(Comparator.comparing(UiPathTriggerDto::getStartProcessNextOccurrence)
            .thenComparing(UiPathTriggerDto::getName))
            .collect(Collectors.toList());
    }
}
