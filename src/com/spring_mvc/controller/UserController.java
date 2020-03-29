package com.spring_mvc.controller;

import com.spring_mvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理控制器类
 */
@Controller
public class UserController {
    @RequestMapping(value = "/register")
    public String register(Model model){
        System.out.println("调用控制器register()方法");
        // 初始化User对象并赋值
        User user = new User("王磊", "男", 18);
        // 在model中添加属性command, 值为user对象
        model.addAttribute("command", user);
        return "register";
    }
}
