package com.aladdin.common.core.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * HTTP请求工具类
 *
 * @author cles
 * @date 2026/04/30
 */
public class HttpUtil {

    private static final int CONNECT_TIMEOUT = 15000;
    private static final int READ_TIMEOUT = 60000;

    private HttpUtil() {
    }

    public static String doGet(String httpUrl) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(httpUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(CONNECT_TIMEOUT);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.connect();
            if (connection.getResponseCode() == 200) {
                return readResponse(connection.getInputStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("GET请求失败: " + httpUrl, e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    public static String doPost(String httpUrl, String param) {
        HttpURLConnection connection = null;
        OutputStream os = null;
        try {
            URL url = new URL(httpUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(CONNECT_TIMEOUT);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            os = connection.getOutputStream();
            os.write(param.getBytes(StandardCharsets.UTF_8));
            if (connection.getResponseCode() == 200) {
                return readResponse(connection.getInputStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("POST请求失败: " + httpUrl, e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ignored) {
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    private static String readResponse(InputStream is) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            StringBuilder sb = new StringBuilder();
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp).append("\r\n");
            }
            return sb.toString();
        }
    }
}
