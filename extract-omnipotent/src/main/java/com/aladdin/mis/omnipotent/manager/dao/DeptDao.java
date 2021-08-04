package com.aladdin.mis.omnipotent.manager.dao;

import com.aladdin.mis.omnipotent.manager.bean.Dept;
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

    Dept findById(Integer id);

}
