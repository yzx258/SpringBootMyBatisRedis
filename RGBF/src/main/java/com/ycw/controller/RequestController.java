package com.ycw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(path="/Test",method=RequestMethod.GET)
    public ModelAndView getTabless() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/ycw/index111");
        return mav;
    }

    @RequestMapping(path="/Test1",method=RequestMethod.GET)
    public ModelAndView getTablesss() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

}
