package jarvis.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtils {

    public static final String CHARSET = "UTF-8";

    public static String get(String url) throws Exception {
        return get(url, null, CHARSET);
    }

    public static String get(String url,
                             Map<String, String> params) throws Exception {
        return get(url, params, CHARSET);
    }

    public static String post(String url,
                              Map<String, String> params) throws Exception {
        return post(url, params, CHARSET);
    }

    public static String post(String url,
                              String body) throws Exception {
        return post(url, body, CHARSET);
    }

    public static String post(String url,
                              JSONObject body) throws Exception {
        return post(url, body, CHARSET);
    }

    /**
     * Map转NameValuePair
     *
     * @author yehao
     * @since 2018/5/2
     */
    private static List<NameValuePair> map2NameValuePair(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        List<NameValuePair> pairs = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return pairs;
    }

    /**
     * 执行http请求
     *
     * @author yehao
     * @since 2018/5/2
     */
    private static String request(HttpRequestBase requestBase,
                                  String charset) throws Exception {
        String payload = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse response = httpClient.execute(requestBase)) {

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                requestBase.abort();
                throw new RuntimeException("status code :" + statusCode);
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                payload = EntityUtils.toString(entity, charset);
            }
            EntityUtils.consume(entity);
        }
        return payload;
    }

    /**
     * get请求
     * 参数形式为键值对
     *
     * @author yehao
     * @since 2018/5/2
     */
    public static String get(String url,
                             Map<String, String> params,
                             String charset) throws Exception {
        if (url == null || url.isEmpty()) {
            return null;
        }

        List<NameValuePair> pairs = map2NameValuePair(params);
        if (pairs != null) {
            url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(map2NameValuePair(params), charset));
        }
        HttpGet httpGet = new HttpGet(url);

        return request(httpGet, charset);
    }

    /**
     * post请求
     * 参数形式为键值对
     *
     * @author yehao
     * @since 2018/5/2
     */
    public static String post(String url,
                              Map<String, String> params,
                              String charset) throws Exception {
        if (url.isEmpty()) {
            return null;
        }

        HttpPost            httpPost = new HttpPost(url);
        List<NameValuePair> pairs    = map2NameValuePair(params);
        if (pairs != null) {
            httpPost.setEntity(new UrlEncodedFormEntity(pairs, CHARSET));
        }

        return request(httpPost, charset);
    }

    /**
     * post请求
     * 参数形式为字符串
     *
     * @author yehao
     * @since 2018/5/2
     */
    public static String post(String url,
                              String body,
                              String charset) throws Exception {
        if (url == null || url.isEmpty()) {
            return null;
        }

        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(body, charset));

        return request(httpPost, charset);
    }

    /**
     * post请求
     * 参数形式为json
     *
     * @author yehao
     * @since 2018/5/2
     */
    public static String post(String url,
                              JSONObject jsonParam,
                              String charset) throws Exception {
        if (url == null || url.isEmpty()) {
            return null;
        }

        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(jsonParam.toString(), ContentType.create("application/json", charset)));

        return request(httpPost, charset);
    }
}

