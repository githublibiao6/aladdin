package com.company.system.system.bean.copy;


/**
 * test类
 * SG_SCH_DEV_OUTAGEDATA_BEFOREDAY
 * @author lb
 */
public class Test {

    private String planId; 
    private String devId; 
    private String devName;
    private String isMainDev;
    private String devType;
    private String state;
    public String getPlanId() {
        return planId;
    }
    public void setPlanId(String planId) {
        this.planId = planId;
    }
    public String getDevId() {
        return devId;
    }
    public void setDevId(String devId) {
        this.devId = devId;
    }
    public String getDevName() {
        return devName;
    }
    public void setDevName(String devName) {
        this.devName = devName;
    }
    public String getIsMainDev() {
        return isMainDev;
    }
    public void setIsMainDev(String isMainDev) {
        this.isMainDev = isMainDev;
    }
    public String getDevType() {
        return devType;
    }
    public void setDevType(String devType) {
        this.devType = devType;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    @Override
    public String toString() {
        return "Test [planId=" + planId + ", devId=" + devId + ", devName=" + devName + ", isMainDev=" + isMainDev
                + ", devType=" + devType + ", state=" + state + "]";
    }
    
}
