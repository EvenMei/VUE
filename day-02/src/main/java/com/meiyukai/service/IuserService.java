package com.meiyukai.service;

import com.meiyukai.domain.User;

import java.util.List;

public interface IuserService {
    /**
     *查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 根据ID 查询某个user
     */
    User findUserById(Integer userId);


    /**
     *
     * @param user : 传入的user
     */
    void updateUser(User user);

}
