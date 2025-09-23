package com.aladdin.mis.common.license.creator;

import de.schlichtherle.license.AbstractKeyStoreParam;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 自定义KeyStoreParam
 * @author cles
 */
public class CustomKeyStoreParam extends AbstractKeyStoreParam {
    private final String storePath;
    private final String alias;
    private final String storePwd;
    private final String keyPwd;

    public CustomKeyStoreParam(Class clazz, String resource, String alias, String storePwd, String keyPwd) {
        super(clazz, resource);
        this.storePath = resource;
        this.alias = alias;
        this.storePwd = storePwd;
        this.keyPwd = keyPwd;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public String getStorePwd() {
        return storePwd;
    }

    @Override
    public String getKeyPwd() {
        return keyPwd;
    }

    @Override
    public InputStream getStream() throws IOException {
        return Files.newInputStream(Paths.get(storePath));
    }
}

