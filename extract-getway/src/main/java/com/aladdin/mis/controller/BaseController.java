package com.aladdin.mis.controller;
/*
 *  Created by cles on 2021/7/13 14:08
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cles
 * @description:
 * @Date 2021/7/13 14:08
 * @version: 1.0.0
 */
@RestController
@RequestMapping("getWay")
public class BaseController {

    @RequestMapping("index")
    public void index(){
        System.err.println("index-getway");
    }
}
