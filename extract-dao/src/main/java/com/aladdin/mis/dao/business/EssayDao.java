package com.aladdin.mis.dao.business;

import com.aladdin.mis.blog.entity.Essay;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 字典 Dao
 * @author lb
 *
 */
@Repository
public interface EssayDao {

    /**
     * 获取全部dictionary
     * @return
     */
    @Select( "select * from Essay m where m.sys005='1'")
    List<Essay> listEssay();

    /**
     * 功能描述：根据id查询文章
     *  < >
     * @Description: findById
     * @Author: cles
     * @Date: 2020/8/26 23:32
     * @param id 主键
     * @return: com.apps.omnipotent.business.entity.Essay
     * @version: 1.0.0
     */
    Essay findById(Integer id);

    /**
     * 根据code查询记录
     * @param code
     * @return
     */
//    public Dict queryDictInfoByCode(@Param("code")String code,@Param("tableName")String tableName);

    /**
     * 修改dict
     * @param dict
     * @param tableName
     * @return
     */
//    public int modifyDictInfo(@Param("dict")Dict dict,@Param("tableName")String tableName);

    /**
     * 添加dict
     * @param dict
     * @param tableName
     * @return
     */
//    public int addDictInfo(@Param("dict")Dict dict,@Param("tableName")String tableName);

    /**
     * 删除dict
     * @param dict
     * @param tableName
     * @return
     */
//    public int deleteDictInfo(@Param("code")String code,@Param("tableName")String tableName);
}
