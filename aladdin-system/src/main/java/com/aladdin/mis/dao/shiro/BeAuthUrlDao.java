package com.aladdin.mis.dao.shiro;

import com.aladdin.mis.shiro.qo.BeAuthUrlQo;
import com.aladdin.mis.shiro.vo.BeAuthUrlVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BeAuthUrlDao
 * @author cles
 * @date 2023-02-03T23:50:29.476
*/
@Repository
public interface BeAuthUrlDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BeAuthUrlVo> list(BeAuthUrlQo qo);

}
