package com.aladdin.mis.omnipotent.system.controller;

import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.dao.db.config.DbConfig;
import com.aladdin.mis.common.db.config.Db;
import com.aladdin.mis.manager.bean.Admin;
import com.aladdin.mis.system.service.AdminService;
import com.aladdin.mis.omnipotent.system.threadpool.service.impl.AsyncServiceImpl;
import com.aladdin.mis.system.user.vo.OmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
* @Description:  刚开始测试用的，没啥用
* @Author: cles
* @Date: 2020/4/17 23:46
*/
@Controller
@RequestMapping("/testing")
public class TestingController  extends GlobalController {

    @Autowired
    private AsyncServiceImpl asyncService;

//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Autowired
//    private MongoClient mongoClient;

    @Autowired
    private AdminService adminService;

    /** 测试异步执行
     * @Author cles
     * @Description
     * @Date 23:14 2019/7/10
     * @return java.lang.String
     **/
    @RequestMapping("/index")
    @ResponseBody
    public Result say() {
        asyncService.executeAsync();
        return result;
    }

    /**
     * 获取菜单
     *
     * @return List<Role>
     * @Description
     * @MethodName index
     * @author lb
     * @date 2018年8月21日 下午9:56:33
     */
//    @RequiresRoles({"admin"})
//    @RequiresPermissions("list")
    @RequestMapping("/list")
    @ResponseBody
    @WebLog
    public Result list() {
        OmUser user = getCurrentUser();
        System.err.println(user);
        List<Admin> list = adminService.list();
        result.setData(list);
        return result;
    }

    /**
    * @Description:  测试动态数据源
    * @Param: []
    * @return: com.apps.omnipotent.system.global.entity.Result
    * @Author: cles
    * @Date: 2020/5/11 23:44
    */
    @RequestMapping("/db")
    @ResponseBody
    public Result db() {
        DbConfig db = new DbConfig();
        try{
            boolean flag = db.createDataSource("test",
                    "jdbc:mysql://127.0.0.1:3306/company?serverTimezone=UTC&characterEncoding=utf-8","root",
                    "mysql","mysql");
            System.err.println(flag);
            List<Map<String, Object>> list = Db.use("test").find("select * from be_admin");
            System.err.println(list.size());
            System.err.println(list.get(0));
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
    * @Description: 测试mongo
    * @Param: []
    * @return: com.apps.omnipotent.system.global.entity.Result
    * @Author: cles
    * @Date: 2020/5/11 23:45
    */
//    @RequestMapping("/mongo")
//    @ResponseBody
//    public Result mongo() {
//        Query query = new Query();
////        //数据库表名称
//        Set<String> set = mongoTemplate.getCollectionNames();
//        set.forEach(t->{
//            System.out.println(t);
//        });
//        MongoCollection<Document> dbCollection = mongoTemplate.getCollection("table1");
//        FindIterable<Document> sm = dbCollection.find();
//        sm.forEach((Block<? super Document>) t->{
//            System.err.println(t);
//            System.err.println(t.get("title"));
//        });
////
////        //创建文档
////        Document document = new Document("name","张三")
////                .append("sex", "男")
////                .append("age", 18);
////        dbCollection.insertOne(document);
////        FindIterable<Document> list = dbCollection.find();
//        MongoDatabase db = mongoTemplate.getDb();
//        System.err.println(db.getName());
//        MongoIterable<String> cols = db.listCollectionNames();
//        System.out.println(cols);
//        System.out.println(cols.first());
//        cols.forEach((Block<? super String>) s->{
//            System.out.println(s);
//        });
//        MongoCollection<Document> collection = db.getCollection("table");
//        FindIterable<Document> list = collection.find();
//        System.out.println(list);
//        list.forEach((Block<? super Document>) t->{
//            System.err.println(t);
//            System.err.println(t.get("title"));
//        });
////        MongoTemplate mongoTemplate1 = new MongoTemplate(mongoClient,"table");
////        MongoCollection<Document> collection1 = mongoTemplate1.getDb().getCollection("startup_log");
////        FindIterable<Document> list1 = collection1.find();
////        list1.forEach((Block<? super Document>) t->{
////            System.err.println(t);
////            System.err.println(t.get("name"));
////        });
////        DictionaryUtils.init();
//        return result;
//    }
}
