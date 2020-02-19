package com.meiyukai.service.impl;

import com.meiyukai.dao.UserDao;
import com.meiyukai.domain.User;
import com.meiyukai.service.IuserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements IuserService {
    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findUserById(Integer userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }


}
