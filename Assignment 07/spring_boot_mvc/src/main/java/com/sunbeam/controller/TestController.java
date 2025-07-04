package com.sunbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    public TestController() {
        System.out.println("in ctor of" +getClass());
    }

    @RequestMapping("/")
    public String renderIndexPage(){
        System.out.println("in render index page... ");
        return "index";
    }
}
