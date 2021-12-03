package com.aladdin.mis.mapper.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * test controller
 * @author lb
 * @date 2018年6月5日 下午8:56:11
 */
@RequestMapping("chart")
@RestController
public class ChartController {

    /**
     * 菜单跳转
     *
     * @return
     */
    @RequestMapping("/index.do")
    public String index() {
        return "test/index";
    }

}
