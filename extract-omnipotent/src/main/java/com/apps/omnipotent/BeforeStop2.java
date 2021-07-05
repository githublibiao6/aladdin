package com.apps.omnipotent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BeforeStop2 implements DisposableBean, ExitCodeGenerator {

    @Override
    public void destroy() throws Exception {
        try {
            log.info("销毁事件2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getExitCode() {
        return 5;
    }
}
