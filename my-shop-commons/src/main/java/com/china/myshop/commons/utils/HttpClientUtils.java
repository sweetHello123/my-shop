package com.china.myshop.commons.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName: HttpClientUtils
 * @Description: 模块通信工具类
 * @author: china wu
 * @date: 2019\10\12 0012 15:53
 */
public class HttpClientUtils {

    private static final String GET = "get";

    private static final String POST = "post";

    private static final String REQUEST_HEADER_CONNECTION = "keep-alive";

    private static final String REQUEST_HEADER_USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36";

    /**
     * GET请求
     *
     * @param url    请求地址
     * @param cookie
     * @return
     */
    public static String doGet(String url, String cookie) {
        return createRequest(url, GET, cookie, null);
    }

    /**
     * POST请求
     *
     * @param url    请求地址
     * @param cookie
     * @param params 请求参数
     * @return
     */
    public static String doPost(String url, String cookie, List<BasicNameValuePair> params) {
        return createRequest(url, POST, cookie, params);
    }

    public static String createRequest(String url, String requestMethod, String cookie, List<BasicNameValuePair> params) {
        //创建httpClient客户端(打开浏览器)
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //Get请求方式
        HttpGet httpGet = null;

        //Post请求方式
        HttpPost httpPost = null;

        //响应
        CloseableHttpResponse httpResponse = null;

        String result = null;

        try {
            if (GET.equals(requestMethod)) {
                //创建Get请求,输入url
                httpGet = new HttpGet(url);

                httpGet.setHeader("Connection", REQUEST_HEADER_CONNECTION);

                //给请求头设置登录时Cookie值
                httpGet.setHeader("Cookie", cookie);

                httpGet.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);

                //发送请求(回车)
                httpResponse = httpClient.execute(httpGet);

                HttpEntity httpEntity = httpResponse.getEntity();

                result = EntityUtils.toString(httpEntity);

            } else if (POST.equals(requestMethod)) {
                //创建Post请求,输入url
                httpPost = new HttpPost(url);

                httpPost.setHeader("Connection", "keep-alive");

                //给请求头设置登录时Cookie值
                httpPost.setHeader("Cookie", cookie);

                httpPost.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);

                httpPost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));

                //发送请求(回车)
                httpResponse = httpClient.execute(httpPost);

                HttpEntity httpEntity = httpResponse.getEntity();

                result = EntityUtils.toString(httpEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}