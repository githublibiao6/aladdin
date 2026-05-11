package com.aladdin.mis.dao.manager;

import com.aladdin.mis.identity.entity.Dept;
import com.aladdin.mis.identity.qo.DeptQo;
import com.aladdin.mis.identity.vo.DeptVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 部门 dao
 * @author lb
 *
 */
@Component
public interface DeptDao {

    /**
     * 获取列表
     * @return
     */
    List<DeptVo> list();

    /**
     * 根据主键获取
     * @param id
     * @return
     */
    Dept getById(@Param("id") Integer id);

    /**
     * 获取列表
     * @param qo
     * @return
     */
    List<Dept> listData(DeptQo qo);

    /**
     * 根据appId获取机构
     * @param appId
     * @return
     */
    Dept getByAppId(@Param("appId") Integer appId);
}
