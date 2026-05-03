package com.aladdin.mis.api;

import com.aladdin.common.core.utils.FileUtil;
import com.aladdin.mis.dao.generate.FileWriteFunction;

public class ApiFileWriteFunction implements FileWriteFunction {

    @Override
    public boolean write(String content, String filePath, String fileName, boolean overWrite) {
        return FileUtil.writeContentToFile(content, filePath, fileName, overWrite);
    }

    @Override
    public String readContent(String filePath, String fileName) {
        return FileUtil.readContentFromFile(filePath, fileName);
    }
}
