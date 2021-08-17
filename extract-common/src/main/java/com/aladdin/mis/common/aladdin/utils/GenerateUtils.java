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

    }
}
