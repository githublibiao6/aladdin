package com.aladdin.mis.common.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class CommonFileUtil {

    /**
     * 写入文本到指定文件
     * @param content 写入内容
     * @param filePath 文件路径
     * @param fileName 文件名
     * @param cover 是否覆盖
     * @return
     */
    public static boolean writeContentToFile(String content, String filePath, String fileName, boolean cover){

        File parentFile = new File(filePath);
        if(!parentFile.exists()){
            try {
                parentFile.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        String path = filePath+"/"+fileName;
        path = path.replace("/", File.separator);
        File file = new File(path);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }else if(!cover){
            return true;
        }else  {
            try {
                file.delete();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
     * 写入文本到指定文件
     * @param filePath 文件路径
     * @param fileName 文件名
     * @return
     */
    public static String readContentToFile(String filePath, String fileName){
        File parentFile = new File(filePath);
        if(!parentFile.exists()){
            return null;
        }
        String path = filePath+"/"+fileName;
        path = path.replace("/", File.separator);
        File file = new File(path);
        if(!file.exists()){
            return null;
        }
        StringBuilder content = new StringBuilder();
        try {
            String line = null;
            FileInputStream in = new FileInputStream(file);
            InputStreamReader inReader = new InputStreamReader(in, StandardCharsets.UTF_8);
            BufferedReader bufReader = new BufferedReader(inReader);
            while((line = bufReader.readLine()) != null){
                content.append(line).append("\n");
            }
            bufReader.close();
            inReader.close();
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return content.toString();
    }
}
