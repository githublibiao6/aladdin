package com.apps.omnipotent.system.mongodb.service.impl;
/*
 *  Created by cles on 2020/12/1 23:10
 */

import com.apps.omnipotent.system.mongodb.service.MongoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * @author cles
 * @description:
 * @Date 2020/12/1 23:10
 * @version: 1.0.0
 */
@Slf4j
public  class MongoServiceImpl<T>  implements MongoService<T> {

    @Autowired
    public MongoTemplate mongoTemplate;

    @Override
    public void save(T o) {
        log.info("[Mongo]save:" + o.toString());
        mongoTemplate.save(o);
    }

    @Override
    public void saveList(List<T> list) {
        log.info("[Mongo]save:" + list.toString());
        list.forEach(this::save);
    }

    @Override
    public T queryById(Class<T> cls, String id) {
        Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(id);
        query.addCriteria(criteria);
        log.info(cls+"[Mongo]queryById:" + query);
        return mongoTemplate.findOne(query, cls);
    }

    @Override
    public List queryList(Class<T> cls, Query query) {
        log.info(cls+"[Mongo]queryList:" + query);
        return mongoTemplate.find(query, cls);

    }

    @Override
    public T queryOne(Class<T> cls, Query query) {
        log.info(cls+"[Mongo] queryOne:" + query);
        return mongoTemplate.findOne(query, cls);
    }

    @Override
    public List getPage(Class<T> cls, Query query, int start, int size) {
        query.skip(start);
        query.limit(size);
        List<T> lists = mongoTemplate.find(query, cls);
        log.info(cls+"[Mongo] queryPage:" + query + "(" + start +"," + size +")");
        return lists;
    }

    @Override
    public Long getPageCount(Class<T> cls, Query query) {
        log.info(cls+"[Mongo]queryPageCount:" + query);
        return mongoTemplate.count(query, cls);
    }

    @Override
    public void deleteById(Class<T> cls, String id) {
        Criteria criteria = Criteria.where("_id").in(id);
        if(null!=criteria){
            Query query = new Query(criteria);
            if(null!=query && this.queryOne(cls,query)!=null){
                mongoTemplate.remove(this.queryOne(cls,query));
                log.info(cls+"[Mongo]deleteById:" + query);
            }
        }
    }

    @Override
    public void delete(T t) {
        mongoTemplate.remove(t);
        log.info("[Mongo]delete:" + t);
    }

    @Override
    public void updateFirst(Class<T> cls, String id, String objName, String objValue) {
        Criteria criteria = Criteria.where("_id").in(id);
        if(null!=criteria){
            Query query = new Query(criteria);
            if(null!= query && this.queryOne(cls,query)!=null){
                Update update=new Update();
                update.set(objName,objValue);
                mongoTemplate.updateFirst(query,update,cls);
                log.info(cls+"[Mongo]updateFirst:query(" + query + "),update(" + update + ")");
            }
        }
    }

    @Override
    public void updateInser(Class<T> cls, Query query, Update update) {
        log.info(cls+"[Mongo]updateInser:query(" + query + "),update(" + update + ")");
        mongoTemplate.upsert(query, update, cls);
    }
}
