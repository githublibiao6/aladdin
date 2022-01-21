package com.aladdin.mis.omnipotent.system.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 定时任务
 * @author cles
 *
 */
@Component
@EnableAsync
public class OmTaskScheduled {

    private static final Logger LOGGER = LoggerFactory.getLogger(OmTaskScheduled.class);

    /**
     * 定时任务
     * cron表达式
     */
    @Async
    @Scheduled(cron = "1 1 4 1 1 ?")
    public void visitTaskMonthSchedule() {
        try {
            LOGGER.error("定时任务开始...：" + LocalDateTime.now());
            LOGGER.error("定时任务结束...：" + LocalDateTime.now());
        } catch (Exception ex) {
            LOGGER.error("任务执行失败", ex);
        }
    }


}
