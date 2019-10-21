package com.company.system.system.testCode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.system.system.bean.Test;
import com.company.system.system.dao.TestDao;

/**
 * 测试模块的测试spring和mybatis结合 
 * @author lb
 *
 */
public class SpringMybatis {
	private static TestDao dao;  
    
    
    
    public static void main(String[] args) {  
        //加载容器  
        System.out.println("ddd1");
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");  
        System.out.println("ddd");
        //bean的名字与接口名相同但首字母小写  
        dao = (TestDao) context.getBean("testDao");  
        Test testBean = dao.test("1001");  
        System.out.println(testBean.getDevId());  
        System.out.println(testBean.toString());  
    }  

}
