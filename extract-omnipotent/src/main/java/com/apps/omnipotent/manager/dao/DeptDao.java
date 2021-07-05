package com.apps.omnipotent.manager.dao;

import com.apps.omnipotent.manager.bean.Dept;
import com.apps.omnipotent.manager.bean.Role;
import com.apps.omnipotent.system.pagehelper.entity.QueryCondition;
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

    List<Dept> list();

    Dept findById(String id);

}
