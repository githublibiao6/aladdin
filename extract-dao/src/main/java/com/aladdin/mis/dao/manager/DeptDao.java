package com.aladdin.mis.dao.manager;

import com.aladdin.mis.manager.bean.Dept;
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

    List<DeptVo> list();

    Dept findById(Integer id);

}
