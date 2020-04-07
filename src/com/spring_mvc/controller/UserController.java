package com.spring_mvc.controller;

import com.spring_mvc.entity.Courses;
import com.spring_mvc.entity.User;
import com.spring_mvc.tools.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理控制器类
 */
@Controller
public class UserController {

    // 创建register方法, 将用户保存到Model对象中
    @RequestMapping(value = "/input")
    public String register(Model model) throws Exception{
        System.out.println("调用控制器register()方法");
        // 初始化User对象并赋值
        // User user = new User("王磊", "男", 18, "vermouth", "仙之巅，傲世间，有我安澜便有天。");

        // reflection 获取字节码对象后赋值
        User user = new User();
        Class cls = User.class;
        // 获取公共无参构造方法
        // Object obj = cls.getConstructor().newInstance();
        Field f1 = cls.getDeclaredField("name");
        Field f2 = cls.getDeclaredField("sex");
        Field f3 = cls.getDeclaredField("age");
        Field f4 = cls.getDeclaredField("password");
        Field f5 = cls.getDeclaredField("introduce");

        // 设置私有属性可见
        f1.setAccessible(true);
        f2.setAccessible(true);
        f3.setAccessible(true);
        f4.setAccessible(true);
        f5.setAccessible(true);

        f1.set(user, "王磊");
        f2.set(user, "男");
        f3.set(user, 24);
        f4.set(user, "ruoyi");
        f5.set(user, "赤锋矛，不朽盾，斩尽仙王灭九天。");
        // 在model中添加属性command, 值为user对象
        model.addAttribute("command", user);
        return "input";
    }

    // 创建checkbox()方法
    @RequestMapping(value = "/checkbox", method = RequestMethod.GET)
    public String checkbox(Model model){
        System.out.println("调用控制器checkbox()方法");
        Courses courses = new Courses();
        // 设置是否阅读
        courses.setReader(true);
        // 实例化List对象，赋值
        List<String> list = new ArrayList<>();
        list.add("python web");
        list.add("java web");
        courses.setCources(list);
        model.addAttribute("cources", courses);
        return "checkbox";
    }

    // 创建radiobutton() 方法
    @RequestMapping(value = "/radiobutton")
    public String radiobutton(Model model){
        System.out.println("调用控制器radiobutton()方法");
        User user = new User();
        user.setSex("女");
        model.addAttribute("user", user);
        return "radiobutton";
    }

    // 创建select() 方法
    @RequestMapping(value = "/select")
    public String select(Model model){
        System.out.println("调用控制器select()方法");
        User user = new User();
        user.setDeptid(3);
        model.addAttribute("user", user);
        return "select";
    }

    // 创建selectOption()方法
    @RequestMapping(value="/selectoption")
    public String selectOption(Model model){
        System.out.println("调用控制器selectOption()方法");
        User user = new User();
        user.setDeptid(3);
        Map<Integer, String> deptParentMap = new HashMap<Integer, String>();
        deptParentMap.put(1, "软件学院");
        deptParentMap.put(2, "计算机学院");
        Map<Integer, String> deptMap = new HashMap<Integer, String>();
        deptMap.put(1, "java 学院");
        deptMap.put(2, "c++ 学院");
        deptMap.put(3, "c 学院");
        deptMap.put(4, "go 学院");
        deptMap.put(5, "php 学院");
        deptMap.put(6, "object C 学院");
        deptMap.put(7, "swift 学院");
        model.addAttribute("user", user);
        model.addAttribute("deptParentMap", deptParentMap);
        model.addAttribute("deptMap", deptMap);
        return "selectoption";
    }

    // 创建验证类方法, 验证UserValidator
    @InitBinder
    public void InitBinder(DataBinder dataBinder){
        dataBinder.setValidator(new UserValidator());
    }

    // 创建registerForm()方法
    @RequestMapping(value = "/registerForm")
    public String registerForm(Model model){
        System.out.println("调用控制器registerForm()方法");
        User user = new User();
        model.addAttribute("user", user);
        return "registerForm";
    }

    // 创建错误页跳转方法
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Validated User user, Errors errors){
        System.out.println("调用控制器register()方法");
        if (errors.hasFieldErrors()){
            return "registerForm";
        }
        return "result";
    }
}
