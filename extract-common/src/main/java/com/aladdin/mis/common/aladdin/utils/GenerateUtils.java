package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.file.utils.CommonFileUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateUtils {

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

    public static void main(String[] args) {

        String filePath = "E:\\lb\\aladdin\\extract-omnipotent\\src\\main\\java\\com\\aladdin\\mis\\omnipotent\\love";
        StringBuffer content = new StringBuffer("package com.aladdin.mis.omnipotent.love;\n\n");
        content.append("import com.aladdin.mis.omnipotent.system.core.Table; \n");
        content.append("import com.aladdin.mis.omnipotent.system.global.entity.GlobalModel; \n");
        content.append("import lombok.Data; \n\n");
        content.append("/**\n");
        content.append(" * 随笔 \n");
        content.append(" * @author lb \n");
        content.append(" * @date 2018年5月14日 下午10:33:42 \n");
        content.append("*/ \n");
        content.append("@Table(\"date_log\") \n");
        content.append("@Data \n");
        content.append("public class DateLog extends GlobalModel { \n");
        content.append("} \n");
        boolean result = CommonFileUtil.writeContentToFile(content.toString(),  filePath, "Data.java");
        System.err.println(result);
    }
}
