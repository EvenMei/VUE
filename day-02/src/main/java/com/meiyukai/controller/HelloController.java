package com.meiyukai.controller;

import com.alibaba.fastjson.JSON;
import com.meiyukai.domain.User;
import com.meiyukai.service.IuserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
@ResponseBody
public class HelloController {

    @Resource(name = "userService")
    private IuserService userService;



    @RequestMapping(value = "/findAll.do")
    public List<User>  hello(){
        List<User> users  = userService.findAll();
        System.out.println("list :  "+ users );
        return users;
    }

    /**
     * 查找一个 User
     * @param userId
     * @return
     */
    @RequestMapping(value = "/findUserById.do")
    public User findUserById( @RequestParam(value = "id",required = true) Integer userId){
        System.out.println("userId  : "  +userId);
        User user = userService.findUserById(userId);
        System.out.println("find the user :  " + user);
        return user;
    }


    @RequestMapping(value = "/updateUser.do" , produces = {"text/html;charset=utf-8"})
    public String updateUser(@RequestBody User user){   //用 @RequestBody 绑定User 对象
        String message = "操作失败！";
        try{
            userService.updateUser(user);
            System.out.println("从前端获取的user ： "+user );
            message = "操作成功 ! ";

        }catch(Exception e){
            e.printStackTrace();

        }
            return message;
    }









}
