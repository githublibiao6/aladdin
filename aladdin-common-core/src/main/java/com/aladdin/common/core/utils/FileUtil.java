package com.aladdin.common.core.utils;

import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件工具类
 *
 * @author cles
 * @date 2026/04/30
 */
public class FileUtil {

    private FileUtil() {
    }

    public static boolean writeContentToFile(String content, String filePath, String fileName, boolean cover) {
        File parentFile = new File(filePath);
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            return false;
        }
        String path = filePath + "/" + fileName;
        path = path.replace("/", File.separator);
        File file = new File(path);
        if (file.exists()) {
            if (!cover) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
        }
        try {
            if (!file.createNewFile()) {
                return false;
            }
        } catch (IOException e) {
            return false;
        }
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(content);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static boolean writeContentToFile(String content, String filePath, String fileName) {
        return writeContentToFile(content, filePath, fileName, true);
    }

    public static String readContentFromFile(String filePath, String fileName) {
        File parentFile = new File(filePath);
        if (!parentFile.exists()) {
            return null;
        }
        String path = filePath + "/" + fileName;
        path = path.replace("/", File.separator);
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        StringBuilder content = new StringBuilder();
        try (FileInputStream in = new FileInputStream(file);
             InputStreamReader inReader = new InputStreamReader(in, StandardCharsets.UTF_8);
             BufferedReader bufReader = new BufferedReader(inReader)) {
            String line;
            while ((line = bufReader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            return null;
        }
        return content.toString();
    }

    public static void downLoadFile(HttpServletResponse response, File file) {
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + file.getName());
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
