package com.aladdin.mis.base.db.core;

import com.aladdin.mis.base.db.bean.DataSourceDb;
import com.aladdin.mis.base.db.bean.TableFieldInfo;
import com.aladdin.mis.base.db.factory.BaseSqlMaker;
import com.aladdin.mis.base.db.factory.DbFactory;
import com.aladdin.mis.base.db.factory.DbTableFactory;
import com.aladdin.mis.base.db.factory.impl.MysqlFactory;
import com.aladdin.mis.base.db.factory.impl.OracleFactory;
import com.aladdin.mis.base.mapper.DbMapper;
import com.aladdin.mis.base.model.BaseModel;
import com.alibaba.fastjson2.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 数据库操作实体
 * @author cles
 * @Date 2025/5/10 22:53
 */
@Slf4j
@Data
@Component
public class DbPro {

    @Autowired
    private DbMapper dbMapper;

    private DataSourceDb dataSourceDb;

    private DbFactory dbFactory;

    private DbTableFactory dbTableFactory;

    private BaseSqlMaker sqlMaker;

    private final String primaryKey = "id";

    private Map<String, List<TableFieldInfo>> tableMap = new HashMap<>();

    public DbPro(@Lazy DataSourceDb dataSource){
        this.dataSourceDb = dataSource;
        if(this.dataSourceDb.getUrl().startsWith("jdbc:mysql")){
            dataSourceDb.setDbType("mysql");
        }else if(this.dataSourceDb.getUrl().startsWith("jdbc:oracle")){
            dataSourceDb.setDbType("oracle");
        }
        if("oracle".equals(getDbType())){
            dbFactory = new OracleFactory();
        }else if("mysql".equals(getDbType())){
            dbFactory = new MysqlFactory();
        }
        dbTableFactory = dbFactory.getDbTableFactory();
        sqlMaker = dbFactory.getSqlMaker();
    }

    public void init(){

    }

    public String getSaveSql(BaseModel model){

        return "save sql";
    }

    public String getDeleteSql(BaseModel model){

        return "delete sql";
    }

    public String getUpdateSql(BaseModel model){

        return "update sql";
    }

    public String getSelectSql(String tableName, Integer id) {
        return  "select * from "+tableName+" m where id="+id ;
    }

    public String deleteSql(String tableName, Long id) {
        return sqlMaker.deleteSql(tableName, primaryKey, id);
    }

    public String saveSql(String tableName, List<TableFieldInfo> list) {
        return sqlMaker.saveSql(tableName, primaryKey, list);
    }

    public String updateSql(String tableName , List<TableFieldInfo> list) {
        return sqlMaker.updateSql(tableName, primaryKey, list);
    }

    @Deprecated
    public List<Map<String, Object>> find(String sql){
        return dbMapper.find(sql);
    }

    @Deprecated
    public Map<String, Object> findFirst(String sql){
        List<Map<String, Object>> list = find(sql);
        if (!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Deprecated
    public List<JSONObject> findList(String sql){
        List<JSONObject> list = new  ArrayList<>();
        List<Map<String, Object>> data = find(sql);
        for (Map<String, Object> map : data) {
            JSONObject json = new JSONObject();
            json.putAll(map);
            list.add(json);
        }
        return list;
    }


    /**
     * 获取数据库表列表
     * @return
     */
    public List<Map<String, Object>> listTable(){
        return dbTableFactory.listTable(this.getTableSchema());
    }

    /**
     * 获取表字段详细信息
     * @param tableName
     * @return
     */
    public List<Map<String, Object>> listTableColumns(String tableName){
        return dbTableFactory.listTableColumns(this.getTableSchema(), tableName);
    }

    /**
     * 获取表详细信息
     * @param tableName
     * @return
     */
    public Map<String, Object> listTableInfo(String tableName){
        return dbTableFactory.listTableInfo(this.getTableSchema(), tableName);
    }


    public String getUserName(){
        return dataSourceDb.getUsername();
    }

    public String getPassword(){
        return dataSourceDb.getPassword();
    }

    public String getDbType(){
        return dataSourceDb.getDbType();
    }

    public String getTableSchema(){
        if("oracle".equals(getDbType())){
            return getUserName();
        }else if("mysql".equals(getDbType())){
            Map<String, Object>  m =  findFirst("select database() table_schema");
            if(m != null && m.get("table_schema") != null && !StringUtils.isEmpty(m.get("table_schema"))){
                return m.get("table_schema").toString();
            }else {
                return null;
            }
        }
        return null;
    }
}
