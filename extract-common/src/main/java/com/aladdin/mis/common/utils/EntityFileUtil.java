package com.aladdin.mis.common.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 常用的文件工具类
 * @author cles
 */
public class EntityFileUtil {

    public static boolean writeContentToFile(String content, String filePath, String fileName){
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
}
