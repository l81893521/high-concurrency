package com.will.highconcurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Will.Zhang on 2018/3/19 0019 15:43.
 */
@Controller
@Slf4j
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }
}
