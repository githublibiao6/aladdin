package com.aladdin.mis.dao.generate;

public interface FileWriteFunction {

    boolean write(String content, String filePath, String fileName, boolean overWrite);

    String readContent(String filePath, String fileName);
}
