package com.ycw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestController {

    //@Todo 页面跳转index.html
    @RequestMapping(path="/Index",method= RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

    @RequestMapping(path="/Login",method=RequestMethod.GET)
    public String getLogin() {
        return "login";
    }

    @RequestMapping(path="/Tables",method=RequestMethod.GET)
    public String getTables() {
        return "tables";
    }
}
