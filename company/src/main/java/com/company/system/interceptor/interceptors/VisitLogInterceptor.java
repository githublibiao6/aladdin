package com.company.system.interceptor.interceptors;

import com.company.system.interceptor.bean.VisitLog;
import com.company.system.interceptor.dao.VisitLogDao;
import com.company.system.rabbitmq.service.MessageProducer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 日志拦截
 * @author lb
 * @date 2018年6月5日 下午9:05:09
 */
public class VisitLogInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	private VisitLogDao visitLogDao;

	@Autowired
	private MessageProducer messageProducer;

	//用于记录请求耗时 便于监察耗时的请求
	public static final ThreadLocal<Long> startTimeThreadLocal 
		=  new NamedThreadLocal("stop-startTime");
	/**
	 * 请求开始前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,   
			Object handler) throws Exception{
		//若果是ajax请求
		 if (request.getHeader("x-requested-with") != null 
				 && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
			 return true;
		 }
		//请求开始时间
		long start = System.currentTimeMillis();
		startTimeThreadLocal.set(start);
		return true;
	}
	/**
	 * 请求结束 渲染完成后
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {
		//若果是ajax请求
		 if (request.getHeader("x-requested-with") != null 
				 && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
			 return;
		 }
		 int id = 0;
		 synchronized (this) {
			id =  visitLogDao.selectMaxId()+1;
		 }
		//获取访问的ip
		String ip = request.getRemoteAddr();
		//获取访问的url
		String url = request.getRequestURI();
		long startTime = startTimeThreadLocal.get();
		long endTime = System.currentTimeMillis();
		long time = endTime-startTime;
		Date date = new Date();
		
		VisitLog log = new VisitLog();

		log.setId(id);
		log.setIp(ip);
		log.setUrl(url);
		log.setTime(time);
		log.setDate(date);
//		messageProducer.sendMessage(id+","+ip+url+time);
		Session session = SecurityUtils.getSubject().getSession();
//		visitLogDao.insertLog(log);
		if(null == session.getAttribute("user")){

		}else {
			System.err.print("Access Path:");
			System.out.println(url);
		}
	}
}
