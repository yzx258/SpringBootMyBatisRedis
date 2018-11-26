package com.ycw.controller;

import com.ycw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService user;

    @ResponseBody
    @RequestMapping(path = "/getAll",method = RequestMethod.GET)
    public String getAll(){
        return user.getAll().toString();
    }

}
