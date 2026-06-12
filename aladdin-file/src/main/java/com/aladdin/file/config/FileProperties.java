package com.aladdin.file.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 文件上传配置属性
 * <p>
 * storage-type: local-本地存储, minio-MinIO对象存储
 * 开启local时：文件保存到本地路径 local.path
 * 关闭local开启minio时：文件上传到MinIO服务器
 * 两者切换不影响接口调用方式，仅后端存储位置不同
 *
 * @author cles
 * @date 2026/06/12
 */
@Data
@ConfigurationProperties(prefix = "aladdin.file")
public class FileProperties {

    /** 存储类型: local / minio */
    private String storageType = "local";

    private Local local = new Local();
    private Minio minio = new Minio();

    /** 最大文件大小（字节），默认50MB */
    private long maxSize = 50 * 1024 * 1024;

    /** 允许的文件扩展名 */
    private String[] allowedExtensions = {
            "jpg", "jpeg", "png", "gif", "bmp", "webp",
            "pdf", "doc", "docx", "xls", "xlsx", "ppt", "pptx",
            "txt", "zip", "rar", "7z", "csv"
    };

    @Data
    public static class Local {
        /** 本地存储路径 */
        private String path = "/data/upload";
        /** 访问URL前缀 */
        private String urlPrefix = "http://localhost:9202/file";
    }

    @Data
    public static class Minio {
        /** MinIO服务地址 */
        private String endpoint = "http://127.0.0.1:9000";
        /** 访问Key */
        private String accessKey = "minioadmin";
        /** 密钥 */
        private String secretKey = "minioadmin";
        /** 存储桶名称 */
        private String bucketName = "aladdin";
    }
}
