package com.aladdin.mis.omnipotent.system.threadpool.service.impl;
/**
 * Created by cles on 2020/4/28 23:38
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author cles
 * @Date 2020/4/28 23:38
 */

@Service
@Slf4j
public class AsyncServiceImpl{

//    @Async
    @Async("mainExecutor")
//    taskExecutor即配置线程池的方法名，此处如果不写自定义线程池的方法名，会使用默认的线程池
    public void executeAsync() {
        log.info("start executeAsync");
        try{
            Thread.sleep(10000);
        }catch(Exception e){
            e.printStackTrace();
        }
        log.info("end executeAsync");
    }
}
