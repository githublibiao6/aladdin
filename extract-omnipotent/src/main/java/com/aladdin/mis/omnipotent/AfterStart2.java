package com.aladdin.mis.omnipotent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 启动后执行
 * @author cles
 */
@Slf4j
@Component
@Order(value = 2)
public class AfterStart2 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("启动后执行2");
    }
}
