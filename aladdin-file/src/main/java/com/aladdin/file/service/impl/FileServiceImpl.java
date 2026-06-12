package com.aladdin.file.service.impl;

import com.aladdin.common.core.exception.BusinessException;
import com.aladdin.common.core.exception.GlobalErrorCode;
import com.aladdin.file.config.FileProperties;
import com.aladdin.file.service.FileService;
import com.aladdin.file.util.FileUploadUtil;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * 文件服务实现，支持本地存储和MinIO切换
 *
 * @author cles
 * @date 2026/06/12
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    private final FileProperties fileProperties;
    private MinioClient minioClient;

    public FileServiceImpl(FileProperties fileProperties) {
        this.fileProperties = fileProperties;
        if ("minio".equalsIgnoreCase(fileProperties.getStorageType())) {
            FileProperties.Minio minioConfig = fileProperties.getMinio();
            this.minioClient = MinioClient.builder()
                    .endpoint(minioConfig.getEndpoint())
                    .credentials(minioConfig.getAccessKey(), minioConfig.getSecretKey())
                    .build();
        }
    }

    @Override
    public FileUploadUtil.FileUploadResult upload(MultipartFile file) {
        if ("minio".equalsIgnoreCase(fileProperties.getStorageType())) {
            return uploadToMinio(file);
        }
        return uploadToLocal(file);
    }

    @Override
    public void delete(String relativePath) {
        if ("minio".equalsIgnoreCase(fileProperties.getStorageType())) {
            deleteFromMinio(relativePath);
        } else {
            deleteFromLocal(relativePath);
        }
    }

    private FileUploadUtil.FileUploadResult uploadToLocal(MultipartFile file) {
        FileUploadUtil.FileUploadResult result = FileUploadUtil.upload(file, fileProperties.getLocal().getPath(),
                fileProperties.getMaxSize(), fileProperties.getAllowedExtensions());
        result.setAbsolutePath(fileProperties.getLocal().getUrlPrefix() + "/" + result.getRelativePath());
        return result;
    }

    private FileUploadUtil.FileUploadResult uploadToMinio(MultipartFile file) {
        try {
            FileUploadUtil.FileUploadResult result = FileUploadUtil.upload(file,
                    System.getProperty("java.io.tmpdir"),
                    fileProperties.getMaxSize(), fileProperties.getAllowedExtensions());

            try (InputStream inputStream = file.getInputStream()) {
                minioClient.putObject(PutObjectArgs.builder()
                        .bucket(fileProperties.getMinio().getBucketName())
                        .object(result.getRelativePath())
                        .stream(inputStream, file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build());
            }

            String url = fileProperties.getMinio().getEndpoint() + "/"
                    + fileProperties.getMinio().getBucketName() + "/"
                    + result.getRelativePath();
            result.setAbsolutePath(url);
            return result;
        } catch (Exception e) {
            log.error("MinIO上传失败: {}", e.getMessage(), e);
            throw new BusinessException(GlobalErrorCode.INTERNAL_ERROR, "文件上传失败");
        }
    }

    private void deleteFromLocal(String relativePath) {
        try {
            java.nio.file.Path filePath = java.nio.file.Paths.get(fileProperties.getLocal().getPath(), relativePath);
            java.nio.file.Files.deleteIfExists(filePath);
        } catch (Exception e) {
            log.warn("本地文件删除失败: {}", e.getMessage());
        }
    }

    private void deleteFromMinio(String relativePath) {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(fileProperties.getMinio().getBucketName())
                    .object(relativePath)
                    .build());
        } catch (Exception e) {
            log.warn("MinIO文件删除失败: {}", e.getMessage());
        }
    }
}
