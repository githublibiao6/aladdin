package com.apps.omnipotent.system.pagehelper.entity;

import java.util.Date;

/**
 *  通用查询条件   bean
 * @author lb
 * @date 2018年6月5日 下午9:03:15
 */
public class QueryCondition {
    private String id; //
    private String keyWord; //关键字
    private String sex; //性别
    private Date startTime; //开始时间
    private Date endTime; //结束时间
    private String flag; //标志
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getKeyWord() {
        return keyWord;
    }
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
    @Override
    public String toString() {
        return "QueryCondition [id=" + id + ", keyWord=" + keyWord + ", sex=" + sex + ", startTime=" + startTime
                + ", endTime=" + endTime + ", flag=" + flag + "]";
    }
}
