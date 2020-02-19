package com.meiyukai.dao;

import com.meiyukai.domain.User;
import com.meiyukai.provider.UserUpdateProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userDao")
public interface UserDao {

    @Select(value = "select * from user ")
    List<User> findAll();

    @Select (value="select * from user where id= #{userId}")
    User findUserById(Integer userId);

    /*@Update(value = "update user set " +
            "age=#{u.age} , " +
            "username=#{u.username} , " +
            "password=#{u.password} , " +
            "email=#{u.email}, " +
            "sex = #{u.sex}" +
            " where id = #{u.id}")*/   //不用 @param 的写法是：username = #{username} , password = #{password}
    @UpdateProvider(type = UserUpdateProvider.class, method = "getUpdateProvider")
    void updateUser(@Param(value ="u") User user);



}
