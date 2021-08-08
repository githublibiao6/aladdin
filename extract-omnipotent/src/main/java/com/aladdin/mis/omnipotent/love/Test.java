package com.aladdin.mis.omnipotent.love;


import com.aladdin.mis.common.file.utils.EntityFileUtil;

public class Test {
    public static void main(String[] args) {

        String filePath = "E:\\lb\\aladdin\\extract-omnipotent\\src\\main\\java\\com\\aladdin\\mis\\omnipotent\\love";
        StringBuffer content = new StringBuffer("package com.aladdin.mis.omnipotent.love;\n\n");
        content.append("import com.aladdin.mis.dao.core.Table; \n");
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
        boolean result = EntityFileUtil.writeContentToFile(content.toString(),  filePath, "Data.java");
        System.err.println(result);
    }
}
