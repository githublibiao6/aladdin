package com.apps.omnipotent.love.dao;

import com.apps.omnipotent.love.entity.DateLog;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 字典 Dao
 * @author lb
 *
 */
@Repository
public interface DateLogMapper {

    /**
     * 获取全部dictionary
     * @return
     */
    @SelectProvider(type = DateLogMapper.DateLogProvider.class,method = "listDateLog")
    List<DateLog> listDateLog();

    class DateLogProvider{
        public String listDateLog() {
            return "select * from date_log m where m.sys005='1'";
        }
    }

}
