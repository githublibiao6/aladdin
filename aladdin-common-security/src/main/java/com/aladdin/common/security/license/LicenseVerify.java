package com.aladdin.common.security.license;

import de.schlichtherle.license.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.prefs.Preferences;

/**
 * License证书校验
 *
 * @author cles
 * @date 2026/04/30
 */
@Slf4j
public class LicenseVerify {

    public synchronized LicenseContent install(LicenseVerifyParam param) {
        LicenseContent result = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            LicenseManager licenseManager = LicenseManagerHolder.getInstance(initLicenseParam(param));
            licenseManager.uninstall();
            result = licenseManager.install(new File(param.getLicensePath()));
            log.info(MessageFormat.format("证书安装成功，证书有效期：{0} - {1}",
                    format.format(result.getNotBefore()), format.format(result.getNotAfter())));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("证书安装失败: {}", e.getMessage());
        }
        return result;
    }

    public boolean verify() {
        LicenseManager licenseManager = LicenseManagerHolder.getInstance(null);
        try {
            licenseManager.verify();
            return true;
        } catch (Exception e) {
            log.error("证书校验失败: {}", e.getMessage());
            return false;
        }
    }

    private LicenseParam initLicenseParam(LicenseVerifyParam param) {
        Preferences preferences = Preferences.userNodeForPackage(LicenseVerify.class);
        CipherParam cipherParam = new DefaultCipherParam(param.getStorePass());
        KeyStoreParam publicStoreParam = new CustomKeyStoreParam(LicenseVerify.class
                , param.getPublicKeysStorePath()
                , param.getPublicAlias()
                , param.getStorePass()
                , null);
        return new DefaultLicenseParam(param.getSubject()
                , preferences
                , publicStoreParam
                , cipherParam);
    }
}
