package com.apps.omnipotent.system.db.config;
/**
 * Created by cles on 2020/5/6 23:24
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.stat.DruidDataSourceStatManager;
import com.apps.omnipotent.system.db.bean.DataSource;
import com.apps.omnipotent.system.db.utils.Db;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import java.util.Set;

/**
 * @description: 动态数据源
 * https://blog.csdn.net/z357904947/article/details/89157281
 * @author cles
 * @Date 2020/5/6 23:24
 */
@Slf4j
public class DbConfig {

    private boolean debug = true;
    private final String ORACLE_DERIVE_CLASS = "oracle.jdbc.driver.OracleDriver";
    private final String MYSQL_DERIVE_CLASS = "com.mysql.cj.jdbc.Driver";

    /**
     * 创建数据源
     * @param key
     * @param url
     * @param username
     * @param password
     * @return
     */
    public boolean createDataSource(String key,  String url, String username, String password, String dbType) {
        DruidDataSource druidDataSource;
        try{
            druidDataSource = buildDataSource(url,  username,  password,  dbType);
            // log.info(key+"数据源的概况："+druidDataSource.dump());
            if(druidDataSource == null){
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        log.info(key+"数据源初始化成功");
        druidDataSource.setName(key);
        Db.setDbSource(key,druidDataSource);
        return true;
    }
    public DruidDataSource buildDataSource(String url, String username, String password, String dbType){
        @SuppressWarnings("resource")
        DruidDataSource druidDataSource = new DruidDataSource();
        String  driveClass = "";
        if(dbType == null){
            if(url.startsWith("jdbc:mysql")){
                dbType = "mysql";
            }else if(url.startsWith("jdbc:oracle")){
                dbType = "oracle";
            }
        }
        if("mysql".equalsIgnoreCase(dbType)) {
            driveClass = MYSQL_DERIVE_CLASS;
        } else if("oracle".equalsIgnoreCase(dbType)){
            driveClass = ORACLE_DERIVE_CLASS;
            //是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。
            druidDataSource.setPoolPreparedStatements(true);
            druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(50);
//                int sqlQueryTimeout = ADIPropUtil.sqlQueryTimeOut();
            //对于耗时长的查询sql，会受限于ReadTimeout的控制，单位毫秒
//                druidDataSource.setConnectionProperties("oracle.net.CONNECT_TIMEOUT=6000;oracle.jdbc.ReadTimeout="+sqlQueryTimeout);
        }
        try {
            try { // 排除连接不上的错误
                Class.forName(driveClass);
                // 相当于连接数据库
                DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            druidDataSource.setDriverClassName(driveClass);
            druidDataSource.setUrl(url);
            druidDataSource.setUsername(username);
            druidDataSource.setPassword(password);
            //初始化时建立物理连接的个数。初始化发生在显示调用init方法，或者第一次getConnection时
            druidDataSource.setInitialSize(50);
            //最大连接池数量
            druidDataSource.setMaxActive(100);
            //获取连接时最大等待时间，单位毫秒。当链接数已经达到了最大链接数的时候，应用如果还要获取链接就会出现等待的现象，等待链接释放并回到链接池，如果等待的时间过长就应该踢掉这个等待，不然应用很可能出现雪崩现象
            druidDataSource.setMaxWait(60000);
            //最小连接池数量
            druidDataSource.setMinIdle(40);
            String validationQuery = "select 1 from dual";

            // 申请连接时执行validationQuery检测连接是否有效，这里建议配置为TRUE，防止取到的连接不可用
            druidDataSource.setTestOnBorrow(true);
            // 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
            druidDataSource.setTestWhileIdle(true);
            // 用来检测连接是否有效的sql，要求是一个查询语句。如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会起作用。
            druidDataSource.setValidationQuery(validationQuery);
            // 属性类型是字符串，通过别名的方式配置扩展插件，常用的插件有：监控统计用的filter:stat日志用的filter:log4j防御sql注入的filter:wall
            druidDataSource.setFilters("stat");
            // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
            druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
            // 配置一个连接在池中最小生存的时间，单位是毫秒，这里配置为3分钟180000
            druidDataSource.setMinEvictableIdleTimeMillis(180000);
            // 打开druid.keepAlive之后，当连接池空闲时，池中的minIdle数量以内的连接，空闲时间超过minEvictableIdleTimeMillis，则会执行keepAlive操作，即执行druid.validationQuery指定的查询SQL，一般为select * from dual，只要minEvictableIdleTimeMillis设置的小于防火墙切断连接时间，就可以保证当连接空闲时自动做保活检测，不会被防火墙切断
            druidDataSource.setKeepAlive(true);
            // 是否移除泄露的连接/超过时间限制是否回收。
            druidDataSource.setRemoveAbandoned(true);
            // 泄露连接的定义时间(要超过最大事务的处理时间)；单位为秒。这里配置为1小时
            druidDataSource.setRemoveAbandonedTimeout(3600);
            // 移除泄露连接发生是是否记录日志
            druidDataSource.setLogAbandoned(true);

//            DataSource createDataSource = druidDataSource;
            druidDataSource.init();
//            Map<Object, Object> dynamicTargetDataSources2 = this.dynamicTargetDataSources;
//            dynamicTargetDataSources2.put(key, createDataSource);// 加入map
            // 将map赋值给父类的TargetDataSources
//            setTargetDataSources(dynamicTargetDataSources2);// 将map赋值给父类的TargetDataSources
            // 将TargetDataSources中的连接信息放入resolvedDataSources管理

            // log.info(key+"数据源的概况："+druidDataSource.dump());
            return druidDataSource;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /** 
    * @Description: 删除数据源 
    * @Param: [datasourceid] 
    * @return: boolean 
    * @Author: cles
    * @Date: 2020/5/9 23:42
    */ 
    public boolean delDataSources(String key) {
            return false;
    }

    /**
    * @Description: 测试数据源连接是否有效
    * @Param: [key, driveClass, url, username, password]
    * @return: boolean
    * @Author: cles
    * @Date: 2020/5/11 23:42
    */
    public boolean testDatasource(String driveClass, String url, String username, String password) {
        try {
            Class.forName(driveClass);
            DriverManager.getConnection(url, username, password);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param debug
     *            the debug to set
     */
    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    /**
     * @return the debug
     */
    public boolean isDebug() {
        return debug;
    }

    public void createDataSourceWithCheck(String key,DataSource dataSource) throws Exception {
        String datasourceId = dataSource.getId();
        log.info("准备创建数据源"+datasourceId);
        log.info("数据源"+datasourceId+"之前已经创建，准备测试数据源是否正常...");
        // DataSource druidDataSource = (DataSource) dynamicTargetDataSources2.get(datasourceId);
        DruidDataSource druidDataSource = Db.getDbSource(key);
        boolean rightFlag = true;
        Connection connection = null;
        try {
            log.info(datasourceId+"数据源的概况->当前闲置连接数："+druidDataSource.getPoolingCount());
            long activeCount = druidDataSource.getActiveCount();
            log.info(datasourceId+"数据源的概况->当前活动连接数："+activeCount);
            if(activeCount > 0) {
                log.info(datasourceId+"数据源的概况->活跃连接堆栈信息："+druidDataSource.getActiveConnectionStackTrace());
            }
            log.info("准备获取数据库连接...");
            connection = druidDataSource.getConnection();
            log.info("数据源"+datasourceId+"正常");
        } catch (Exception e) {
            //把异常信息打印到日志文件
            log.error(e.getMessage(),e);
            rightFlag = false;
            log.info("缓存数据源"+datasourceId+"已失效，准备删除...");
            if(delDataSources(datasourceId)) {
                log.info("缓存数据源删除成功");
            } else {
                log.info("缓存数据源删除失败");
            }
        } finally {
            if(null != connection) {
                connection.close();
            }
        }
        if(rightFlag) {
            log.info("不需要重新创建数据源");
            return;
        } else {
            log.info("准备重新创建数据源...");
            createDataSource(key,dataSource);
            log.info("重新创建数据源完成");
        }

    }

    private  void createDataSource(String key,DataSource dataSource) {
        String datasourceId = dataSource.getId();
        log.info("准备创建数据源"+datasourceId);
        String dbType = dataSource.getDbType();
        String username = dataSource.getUsername();
        String password = dataSource.getPassword();
//        password = new String(SecurityTools.decrypt(Base64.decode(password)));
        String url = dataSource.getUrl();
        if(dbType == null){
            if(url.startsWith("jdbc:mysql")){
                dbType = "mysql";
            }else if(url.startsWith("jdbc:oracle")){
                dbType = "oracle";
            }
        }
        String driveClass = "com.mysql.cj.jdbc.Driver";
//        if("mysql".equalsIgnoreCase(databasetype)) {
//            driveClass = DBUtil.mysqldriver;
//        } else if("oracle".equalsIgnoreCase(databasetype)){
//            driveClass = DBUtil.oracledriver;
//        }  else if("sqlserver2000".equalsIgnoreCase(databasetype)){
//            driveClass = DBUtil.sql2000driver;
//        } else if("sqlserver".equalsIgnoreCase(databasetype)){
//            driveClass = DBUtil.sql2005driver;
//        }
        if(testDatasource(driveClass,url,username,password)) {
            boolean result = this.createDataSource(key, url, username, password, dbType);
            if(!result) {
                log.error("数据源"+datasourceId+"配置正确，但是创建失败");
//                throw new ADIException("数据源"+datasourceId+"配置正确，但是创建失败",500);
            }
        } else {
            log.error("数据源配置有错误");
//            throw new ADIException("数据源配置有错误",500);
        }
    }
}
