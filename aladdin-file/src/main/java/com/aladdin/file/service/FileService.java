package com.aladdin.file.service;

import com.aladdin.file.util.FileUploadUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务接口
 *
 * @author cles
 * @date 2026/06/12
 */
public interface FileService {

    /**
     * 上传文件
     *
     * @param file 文件
     * @return 文件上传结果
     */
    FileUploadUtil.FileUploadResult upload(MultipartFile file);

    /**
     * 删除文件
     *
     * @param relativePath 文件相对路径
     */
    void delete(String relativePath);
}
