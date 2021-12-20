package jp.co.pmtech.iwata.common;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;

public class JsonHttpClient {

    private HttpClient httpClient;

    private String hostname;

    public JsonHttpClient(String hostname, boolean isSelfSigned) throws Exception {
        this.httpClient = HttpClients.createDefault();

        // オレオレ証明書の場合
        if (isSelfSigned) {
            this.httpClient = HttpClients.custom().setSSLSocketFactory(
                                    new SSLConnectionSocketFactory(SSLContexts.custom()
                                        .loadTrustMaterial(null, new TrustSelfSignedStrategy()).build()
                              )).build();
        }

        // Orchestratorのホスト名を保持
        this.hostname = hostname;
    }

    public HttpResponse post(String url, String json) throws Exception {

        String uri = this.hostname + url;

        HttpPost request = new HttpPost(uri);

        StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
        request.setEntity(entity);
        request.setHeader("content-type", "application/json");

        return this.httpClient.execute(request);
    }
    
    public HttpResponse get(String url, String bearerToken) throws ClientProtocolException, IOException {
        return this.get(url, bearerToken, null);
    }

    public HttpResponse get(String url, String bearerToken, Header[] headers) throws ClientProtocolException, IOException {

        String uri = this.hostname + url;

        HttpGet request = new HttpGet(uri);

        request.setHeader("Authorization", "Bearer " + bearerToken);
        if (headers != null) {
            for (final Header h : headers) {
                request.setHeader(h);
            }
        }

        return this.httpClient.execute(request);
    }
}
