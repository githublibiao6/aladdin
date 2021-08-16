package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.string.utils.StringUtil;
import com.aladdin.mis.system.db.entity.TableInfo;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateUtils {


    public static void main(String[] args) {
        GeneratePo po = new GeneratePo();

        po.setTablePath("import com.aladdin.mis.annotation.entity.Table;");
        po.setTablePath("import com.aladdin.mis.annotation.entity.TableField;");
        po.setBaseModelPath("import com.aladdin.mis.omnipotent.system.global.entity.GlobalModel;");
        String packagePath = "com.aladdin.mis.omnipotent.love";
        po.setPackagePath(packagePath);
        String filePath = packagePath.replaceAll("\\.", "\\/");
        po.setFilePath(filePath);
        System.err.println(LocalDateTime.now());
//        GenerateEntityUtils.writeContentToFile(po);

        String code = null;
        String[] areaCode = {"","",""};
        if(code != null){
            if(code.length() >= 12){
                areaCode[0] = "\""+code.substring(0, 6)+"\"";
                areaCode[1] = "\""+code.substring(0, 9)+"\"";
                areaCode[2] = "\""+code.substring(0, 12)+"\"";
            }else if(code.length() >= 9){
                areaCode[0] = "\""+code.substring(0, 6)+"\"";
                areaCode[1] = "\""+code.substring(0, 9)+"\"";
                areaCode[2] = "\""+code+"\"";
            }else {
                areaCode[0] = "\""+code.substring(0, 6)+"\"";
                areaCode[1] = "\""+code+"\"";
                areaCode[2] = "\""+code+"\"";
            }
        }else {
            areaCode = new String[0];
        }
        System.err.println(Arrays.toString(areaCode));
    }
}
