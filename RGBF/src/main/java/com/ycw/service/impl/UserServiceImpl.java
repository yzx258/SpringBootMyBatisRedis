package com.ycw.service.impl;

import com.ycw.dao.UserMapper;
import com.ycw.entity.User;
import com.ycw.entity.UserExample;
import com.ycw.service.UserService;
import com.ycw.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper user;

    @Override
    public ResponseData getAll() {
        UserExample example = new UserExample();
        List<User> list = user.selectByExample(null);
        System.out.println("我是数据大小："+list.size());
        if (list.size() > 0) {
            return ResponseData.markSuccess(list.toString());
        } else {
            return ResponseData.markSuccessButNoData();
        }
    }
}
