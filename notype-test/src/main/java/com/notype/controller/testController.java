package com.notype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cuiqingqing on 17/3/7.
 */
@Controller
public class testController {
    @RequestMapping("test")
    public String toIndex(){
        return "test/index";
    }
}
