package com.company.system.interceptor.dao;

import java.util.List;

import com.company.system.interceptor.bean.VisitLog;

/**
 * @Description 访问日志 数据访问层
 * @author lb
 *
 */

public interface VisitLogDao {
    /**
     * 插入日志记录
     * @param log
     * @return
     */
    public int insertLog(VisitLog log);
    /**
     * 查询日志记录
     * @return
     */
    public List<VisitLog> queryLogs();
    /**
     * 查询当前最大id
     * @return
     */
    public int selectMaxId();

}
