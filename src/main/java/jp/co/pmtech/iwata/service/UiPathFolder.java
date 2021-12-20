package jp.co.pmtech.iwata.service;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import jp.co.pmtech.iwata.common.JsonHttpClient;
import jp.co.pmtech.iwata.dto.UiPathFolderDto;

public class UiPathFolder {
    
    private JsonHttpClient httpClient;

    private Map<String, UiPathFolderDto> folderMap;

    public UiPathFolder(JsonHttpClient httpClient, final String bearerToken) throws Exception {
        this.httpClient = httpClient;
    }

    public void init(final String bearerToken) throws Exception {

        HttpResponse response = this.httpClient.get("/odata/Folders", bearerToken);

        // 結果の取得
        HttpEntity entity = response.getEntity();
        String resultJson = IOUtils.toString(entity.getContent(), "UTF-8");

        // 200 OKであること
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new Exception("フォルダーの取得に失敗しました。" + response.getStatusLine().getReasonPhrase() + ":" + resultJson);
        }

        // フォルダー情報を取得
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(resultJson);
        UiPathFolderDto[] folderArray = mapper.readValue(node.get("value").toString(), UiPathFolderDto[].class);

        // mapに保持する
        Map<String, UiPathFolderDto> folderMap = new HashMap<>();
        for (final UiPathFolderDto folder : folderArray) {
            folderMap.put(folder.getDisplayName(), folder);
        }
        this.folderMap = folderMap;
    }

    public String getId(final String folderName) {
        UiPathFolderDto folder = this.folderMap.get(folderName);
        if (folder == null) {
            return null;
        }
        return folder.getId();
    }
    
}
