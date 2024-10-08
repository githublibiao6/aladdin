package com.aladdin.mis.dao.manager;

import com.aladdin.mis.manager.bean.Dept;
import com.aladdin.mis.manager.qo.DeptQo;
import com.aladdin.mis.manager.vo.DeptVo;
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
