package jp.co.pmtech.iwata.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import jp.co.pmtech.iwata.common.JsonHttpClient;

public class UiPathAuthenticator {

    private JsonHttpClient httpClient;

    public UiPathAuthenticator(JsonHttpClient httpClient) throws Exception {
        this.httpClient = httpClient;
    }

    public String auth(String tenant, String username, String password) throws Exception {

        String sendJson = "{" +
                "\"tenancyName\" : \"" + tenant + "\"," +
                "\"usernameOrEmailAddress\" : \"" + username + "\"," +
                "\"password\" : \"" + password + "\"" +
        "}";

        // 認証APIの実行
        HttpResponse response = httpClient.post("/api/account/authenticate", sendJson);

        // 結果の取得
        HttpEntity entity = response.getEntity();
        String resultJson = IOUtils.toString(entity.getContent(), "UTF-8");

        // 200 OKであること
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new Exception("認証に失敗しました。" + response.getStatusLine().getReasonPhrase() + ":" + resultJson);
        }

        // 認証テキストを取得
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(resultJson);

        return node.get("result").asText();
    }
}
