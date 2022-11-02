package com.aladdin.mis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 将进酒
 * 唐代：李白
 * 君不见，黄河之水天上来，奔流到海不复回。
 * 君不见，高堂明镜悲白发，朝如青丝暮成雪。
 * 人生得意须尽欢，莫使金樽空对月。
 * 天生我材必有用，千金散尽还复来。
 * 烹羊宰牛且为乐，会须一饮三百杯。
 * 岑夫子，丹丘生，将进酒，杯莫停。
 * 与君歌一曲，请君为我倾耳听。
 * 钟鼓馔玉不足贵，但愿长醉不愿醒。
 * 古来圣贤皆寂寞，惟有饮者留其名。
 * 陈王昔时宴平乐，斗酒十千恣欢谑。
 * 主人何为言少钱，径须沽取对君酌。
 * 五花马，千金裘，呼儿将出换美酒，与尔同销万古愁
 */

/**
 * @author 李标
 * @Description:  springboot 启动
 * @Author: cles
 * @Date: 2020/4/29 23:17
 */
/*mongodb*/
// 移除自动配置mongodb
// 需要手动配置com.apps.omnipotent.system.mongodb.config.MongoConfig
//@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@SpringBootApplication()
//  开启异步调用
//@EnableAsync
@MapperScan("com.aladdin.mis.dao")
//@EnableMongoRepositories
public class OmApplication {
    public static void main(String[] args) {
        SpringApplication.run(OmApplication.class, args);
    }

    /**
     * 过滤器
     */
//    @Bean
//    public FilterRegistrationBean setFilter(){
//        FilterRegistrationBean filterBean = new FilterRegistrationBean();
//        filterBean.setFilter(new LogCostFilter());
//        filterBean.setName("FilterController");
//        filterBean.addUrlPatterns("/*");
//        return filterBean;
//    }
}
