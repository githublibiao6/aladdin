package com.company.system.system.junit4;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.company.system.interceptor.bean.VisitLog;
import com.company.system.interceptor.dao.VisitLogDao;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:springContext.xml"})
public class VisitLogDaoTest {
	@Resource
	private VisitLogDao visitLogDao;
	@Test
	public void test(){
		VisitLog log =  new VisitLog();
		log.setId(0);
		log.setDate(new Date());
		log.setIp("192.168.10.122");
		log.setTime(300);
		log.setUrl("http://localhost:8080/cloudapp");
		visitLogDao.insertLog(log);
	}
}
