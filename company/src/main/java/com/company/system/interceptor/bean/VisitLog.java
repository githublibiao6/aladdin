package com.company.system.interceptor.bean;

import java.util.Date;

/**
 * @Description 访问记录
 * @author lb
 * @date 2018年5月10日 上午10:18:15 
 *
 */

public class VisitLog {
    private int id;// ID
    private Date date;// 记录日期
    private String url;// 访问的url
    private String ip;// 访问的ip
    private long time;// 访问耗时s
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return "VisitLog [id=" + id + ", date=" + date + ", url=" + url + ", ip=" + ip + ", time=" + time + "]";
    }
    
}
