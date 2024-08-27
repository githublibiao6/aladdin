package com.aladdin.mis.dao.manager;

import com.aladdin.mis.identity.entity.Dept;
import com.aladdin.mis.identity.qo.DeptQo;
import com.aladdin.mis.identity.vo.DeptVo;
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
    Dept getById(Integer id);

    /**
     * 获取列表
     * @param qo
     * @return
     */
    List<Dept> listData(DeptQo qo);

}
