package com.ycw.service;

import com.ycw.entity.User;
import com.ycw.util.ResponseData;

import java.util.List;

public interface UserService {

    /**
     * 1.获取全部数据
     * @return
     */
    public abstract ResponseData getAll();
}
