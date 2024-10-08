package com.aladdin.mis.base.service.impl;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.common.base.qo.Condition;
import com.aladdin.mis.common.base.qo.FieldCondition;
import com.aladdin.mis.common.base.qo.OrderCondition;
import com.aladdin.mis.common.db.bean.TableFieldInfo;
import com.aladdin.mis.common.db.bean.TableInfo;
import com.aladdin.mis.common.utils.JSONObjectUtil;
import com.aladdin.mis.dao.db.config.MainDb;
import com.aladdin.mis.common.db.config.Db;
import com.aladdin.mis.exception.MyException;
import com.aladdin.mis.system.base.GlobalModel;
import com.aladdin.mis.system.user.vo.OmUser;
import com.aladdin.mis.util.BaseModelUtil;
import com.aladdin.mis.utils.UserUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 功能描述：
 *  < 全局service方法 >
 * @Author: cles
 * @Date: 2020/6/23 23:23
 * @version: 1.0.0
 */
@Service
@Primary
public class  GlobalServiceImpl<T extends GlobalModel>  implements GlobalService<T> {

    private static final String CREATE_TIME_FIELD = "sys001";
    private static final String UPDATE_TIME_FIELD = "sys002";
    private static final String CREATE_USER_FIELD = "sys003";
    private static final String UPDATE_USER_FIELD = "sys004";
    private static final String FLAG = "sys005";

    @Override
    public <T> PageInfo<T> pageByCondition(Condition condition) {
        Integer page = condition.getPage();
        Integer limit = condition.getLimit();
        if (page == null) {
            page = 1;
        }
        if(limit == null) {
            limit = 10;
        }
        PageHelper.offsetPage(page, limit);
        Class<T> m = (Class<T>) getT();
        String tableName = getTableName(m);
        TableInfo table = MainDb.getTableInfo(tableName);

        String sql = "select * from " + tableName + " where sys005=1 " +
                getOrCondition(condition, table) +
                getCondition(condition, table) +
                getOrder(condition, table);

        List<JSONObject> list = Db.use().findList(sql);
        PageInfo<JSONObject> pageInfo = new PageInfo<>(list);
        List<JSONObject> pageList = pageInfo.getList();
        if(pageList != null && !pageList.isEmpty()){
            pageList.forEach(JSONObjectUtil::getCamelCaseJSONObject);
        }
        return (PageInfo<T>) pageInfo;
    }

    private String getCondition(Condition condition, TableInfo table){
        if(condition == null){
            return "";
        }
        Map<String, String> columnCol = table.getColumnCol();

        StringBuffer sql = new StringBuffer();
        List<FieldCondition> list = condition.getFieldConditions();
        list.forEach(t->{
            String field = t.getField();
            if(!columnCol.containsKey(field)){
                throw new MyException("类"+table.getClassName() + "不包含字段" + field);
            }

            sql.append(" and ");
            sql.append(getFieldSql(t, columnCol));
        });
        return sql.toString();
    }

    private String getOrCondition(Condition condition, TableInfo table){
        if(condition == null){
            return "";
        }
        Map<String, String> columnCol = table.getColumnCol();

        StringBuffer sql = new StringBuffer();
        Map<String, List<FieldCondition>> map = condition.getOrConditions();
        if(map == null || map.isEmpty()){
            return "";
        }
        map.forEach((k, list)->{
            sql.append(" and (");
            if(list == null || list.isEmpty()){
                return;
            }
            list.forEach(t->{
                String field = t.getField();
                if(!columnCol.containsKey(field)){
                    throw new MyException("类"+table.getClassName() + "不包含字段" + field);
                }
                sql.append(getFieldSql(t, columnCol));
                sql.append(" or ");
            });
            sql.delete(sql.length() -3 ,sql.length()-1);
            sql.append(")");
        });
        return sql.toString();
    }

    private String getFieldSql(FieldCondition t, Map<String, String> columnCol){
        String field = t.getField();
        StringBuilder sql = new StringBuilder();
        String op = t.getOp();
        if(op == null || op.isEmpty()){
            op = "eq";
        }
        switch (op){
            case "eq":
                sql.append(columnCol.get(field))
                        .append("=")
                        .append("'").append(t.getValue()).append("'");
                break;
            case "ne":
                sql.append(columnCol.get(field))
                        .append("!=")
                        .append("'").append(t.getValue()).append("'");
                break;
            case "gt":
                sql.append(columnCol.get(field))
                        .append(">")
                        .append("'").append(t.getValue()).append("'");
                break;
            case "ge":
                sql.append(columnCol.get(field))
                        .append(">=")
                        .append("'").append(t.getValue()).append("'");
            case "lt":
                sql.append(columnCol.get(field))
                        .append("<")
                        .append("'").append(t.getValue()).append("'");
                break;
            case "le":
                sql.append(columnCol.get(field))
                        .append("<=")
                        .append("'").append(t.getValue()).append("'");
                break;
            case "lk":
                sql.append(columnCol.get(field))
                        .append("like")
                        .append("'%").append(t.getValue()).append("%'");
                break;
            case "llk":
                sql.append(columnCol.get(field))
                        .append("like")
                        .append("'%").append(t.getValue()).append("'");
                break;
            case "rlk":
                sql.append(columnCol.get(field))
                        .append("like")
                        .append("'").append(t.getValue()).append("'");
                break;
            case "nk":
                sql.append(columnCol.get(field))
                        .append("not like")
                        .append("'").append(t.getValue()).append("'");
                break;
            case "null":
                sql.append(columnCol.get(field))
                        .append("is null");
                break;
            case "not null":
                sql.append(columnCol.get(field))
                        .append("is not null");
                break;
            default:
                break;
        }
        return sql.toString();
    }

    private String getOrder(Condition condition, TableInfo table){
        if(condition == null){
            return "";
        }
        Map<String, String> columnCol = table.getColumnCol();

        StringBuffer sql = new StringBuffer(" order by ");
        List<OrderCondition> list = condition.getOrderConditions();
        if(list == null || list.isEmpty()){
            return " order by sys001 desc";
        }
        list.forEach(t->{
            String field = t.getOrderField();
            if(!columnCol.containsKey(field)){
                throw new MyException("类"+table.getClassName() + "不包含字段" + field);
            }
            sql.append(field).append(" ").append(t.getOrderType()).append(" ").append(",");

        });
        sql.deleteCharAt(sql.length()-1);
        return sql.toString();
    }

    @Override
    public <T> List<T> queryByCondition(Condition condition) {

        Class<T> m = (Class<T>) getT();
        String tableName = getTableName(m);
        TableInfo table = MainDb.getTableInfo(tableName);

        StringBuilder sql = new StringBuilder("select * from "+tableName);
        sql.append(" where sys005=1 ");
        sql.append(getOrCondition(condition, table));
        sql.append(getCondition(condition, table));
        sql.append(getOrder(condition, table));
        Integer limit = condition.getLimit();
        if(limit != null && limit > 0){
            sql.append(" limit ").append(limit);
        }
        List<JSONObject> list = Db.use().findList(sql.toString());
        List<T> data = new ArrayList<>();
        if(list == null){
            return new ArrayList<>();
        }
        list.forEach(t->{
            T o = JSONObject.parseObject(t.toJSONString(), (Type) getT());
            data.add(o);
        });
        return data;
    }

    @Override
    public <T> T detailQuery(Integer id) {
        Class<T> clazz = (Class<T>) getT();
        return detailQuery(id, clazz);
    }

    @Override
    public Object detailQueryVo(Integer id, Class sonClazz) {
        Class<T> clazz = getT();
        JSONObject json = detailVo(id, clazz);
        return JSONObject.parseObject(json.toJSONString(), sonClazz);
    }

    @Override
    public <T> T getByCondition(Condition condition) {
        Class<T> clazz = (Class<T>) getT();
        String tableName = getTableName(clazz);
        TableInfo table = MainDb.getTableInfo(tableName);

        StringBuilder sql = new StringBuilder("select * from "+tableName);
        sql.append(" where sys005=1 ");
        sql.append(getOrCondition(condition, table));
        sql.append(getCondition(condition, table));
        sql.append(getOrder(condition, table));
        sql.append(" limit ").append("1");
        List<JSONObject> list = Db.use().findList(sql.toString());
        if(list == null || list.isEmpty()){
            return null;
        }
        list.forEach(JSONObjectUtil::getCamelCaseJSONObject);

        return JSONObject.parseObject(list.get(0).toJSONString(),clazz);
    }

    private <T> T detailQuery(Integer id, Class<T> clazz) {
        JSONObject json = detailVo( id, clazz);
        return JSONObject.parseObject(json.toJSONString(),clazz);
    }

    private JSONObject detailVo(Integer id, Class clazz) {
        String tableName = BaseModelUtil.getTableName(clazz);
        String moduleName = BaseModelUtil.getModuleName(clazz);
        String primaryKey = BaseModelUtil.getPrimaryKey(tableName);
        TableInfo table = MainDb.getTableInfo(tableName);

        Map map = Db.use().findByPrimaryKey(tableName, primaryKey, id );
        JSONObject json = new JSONObject();
        if(map == null){
            return json;
        }
        List<TableFieldInfo> list = table.getFields();

        list.forEach(t->{
            if("List<String>".equals(t.getColumnType()) && map.get(t.getColName()) != null){
                String value = map.get(t.getColName()).toString();
                value = value.substring(1, value.length()-1);
                json.put(t.getColumnName(), Arrays.asList(value.split(",")));
            }if("LocalDateTime".equals(t.getColumnType()) && map.get(t.getColName()) != null){
                String value = map.get(t.getColName()).toString();
                value = value.substring(0, 19);
                json.put(t.getColumnName(), value);
            }else {
                json.put(t.getColumnName(), map.get(t.getColName()));
            }
        });
        return json;
    }

    @Override
    public <T> T insertSelective(GlobalModel baseModel) {
        return  (T)detailQuery(insert(baseModel), getClazz(baseModel));
    }

    @Override
    public Integer insert(GlobalModel baseModel) {
        TableInfo table = MainDb.getTableInfo(getTableName(getClazz(baseModel)));
        table.setFields(setTableField(table.getFields(), baseModel));
        String tableName = table.getTableName();
        List<TableFieldInfo> list = table.getFields();
        OmUser finalUser = UserUtil.getCurrentUser();
        list.forEach(t->{
            if(CREATE_USER_FIELD.equals(t.getColumnName())){
                t.setFieldValue(finalUser.getUserId());
            }
            if(CREATE_TIME_FIELD.equals(t.getColumnName())){
                t.setFieldValue(LocalDateTime.now());
            }
            if(FLAG.equals(t.getColumnName())){
                t.setFieldValue(1);
            }
        });
        try{
            Integer id = Db.use().save(tableName, "id", list);
            return id;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public  boolean updateSelective(GlobalModel baseModel) {
        TableInfo table = MainDb.getTableInfo(getTableName(getClazz(baseModel)));
        table.setFields(setTableField(table.getFields(), baseModel));
        String tableName = table.getTableName();
        List<TableFieldInfo> list = table.getFields();
        OmUser finalUser = UserUtil.getCurrentUser();
        list.forEach(t->{
            if(UPDATE_USER_FIELD.equals(t.getColumnName())){
                t.setFieldValue(finalUser.getUserId());
            }
            if(UPDATE_TIME_FIELD.equals(t.getColumnName())){
                t.setFieldValue(LocalDateTime.now());
            }
        });
        int count = Db.use().update(tableName, "id", list);
        return count > 0;
    }

    @Override
    public  <T> T  saveOrUpdate(GlobalModel model) {
        if(model.getPrimaryKey() == null){
            return insertSelective(model);
        }else {
            updateSelective(model);
            return detailQuery(model.getPrimaryKey());
        }
    }

    private Class getClazz (GlobalModel baseModel){
        Class clazz = baseModel.getClass();
        boolean tableAnnExits = clazz.isAnnotationPresent(Table.class);
        if(tableAnnExits){
            return clazz;
        }else {
            Class parent = clazz.getSuperclass();
            boolean parentAnnExits = parent.isAnnotationPresent(Table.class);
            if(parentAnnExits){
                return parent;
            }
        }
        return clazz;
    }

    private List<TableFieldInfo> setTableField(List<TableFieldInfo> list , GlobalModel baseModel)  {
        Class clazz = getClazz(baseModel);
        Field[] fields = clazz.getDeclaredFields();
        Map<String, Object> map = new HashMap<>(16);
        for (Field field : fields){
            try {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                Method getMethod = pd.getReadMethod();
                Object value = getMethod.invoke(baseModel);
                String column = field.getName();
                map.put(column,value);
            } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        // 单独获取主键
        try {
            PropertyDescriptor pd = new PropertyDescriptor("id", clazz);
            Method getMethod = pd.getReadMethod();
            Object value = getMethod.invoke(baseModel);
            map.put("id",value);
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        list.forEach(t->{
            t.setFieldValue(map.get(t.getColumnName()));
        });
        return list;
    }

    private String getTableName(Class clazz){
        return BaseModelUtil.getTableName(clazz);
    }

    @Override
    public boolean deleteById(Integer primaryKey) {
        Class<T> m = getT();
        return Db.use().deleteById(BaseModelUtil.getTableName(m) , "id",  primaryKey) > 0;
    }

    @Override
    public boolean delete(GlobalModel baseModel) {
        try{
            TableInfo table = baseModel.deleteInfo();
            return Db.use().deleteById(table.getTableName(), "id",  table.getIdValue()) > 0;
        }catch (Exception e){
            return false;
        }
    }

    private Class<T> getT() {
        Type type = getClass().getGenericSuperclass();
        Type[] parameter = ((ParameterizedType) type).getActualTypeArguments();
        return (Class<T>)parameter[0];
    }
}
