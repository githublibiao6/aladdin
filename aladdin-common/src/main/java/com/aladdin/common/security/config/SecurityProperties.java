package com.aladdin.common.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "aladdin.security")
public class SecurityProperties {

    private boolean enabled = true;

    private boolean filterEnabled = false;

    private boolean verifyEnable = false;

    private boolean verifyCode = false;

    private boolean verifySms = false;

    private boolean loginLogEnabled = true;

    private boolean operationLogEnabled = true;

    private List<String> whitelist = new ArrayList<>();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isFilterEnabled() {
        return filterEnabled;
    }

    public void setFilterEnabled(boolean filterEnabled) {
        this.filterEnabled = filterEnabled;
    }

    public boolean isVerifyEnable() {
        return verifyEnable;
    }

    public void setVerifyEnable(boolean verifyEnable) {
        this.verifyEnable = verifyEnable;
    }

    public boolean isVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(boolean verifyCode) {
        this.verifyCode = verifyCode;
    }

    public boolean isVerifySms() {
        return verifySms;
    }

    public void setVerifySms(boolean verifySms) {
        this.verifySms = verifySms;
    }

    public boolean isLoginLogEnabled() {
        return loginLogEnabled;
    }

    public void setLoginLogEnabled(boolean loginLogEnabled) {
        this.loginLogEnabled = loginLogEnabled;
    }

    public boolean isOperationLogEnabled() {
        return operationLogEnabled;
    }

    public void setOperationLogEnabled(boolean operationLogEnabled) {
        this.operationLogEnabled = operationLogEnabled;
    }

    public List<String> getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(List<String> whitelist) {
        this.whitelist = whitelist;
    }
}
