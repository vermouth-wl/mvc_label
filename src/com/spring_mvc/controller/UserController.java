package com.spring_mvc.controller;

import com.spring_mvc.entity.Courses;
import com.spring_mvc.entity.User;
import com.spring_mvc.tools.UserValidator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;

/**
 * 用户管理控制器类
 */
@Controller
public class UserController {

    // 创建register方法, 将用户保存到Model对象中
    // MVC标签库 <fm:input>标签, 渲染输入框
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
    // 渲染checkbox标签
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
        // 默认属性为command, 如果修改之后，需要在<fm:form>中申明modelAttribute=新属性名
        model.addAttribute("cources", courses);
        return "checkbox";
    }

    // 创建radiobutton() 方法
    // 渲染Jsp中rediobutton标签
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

    // 创建请求类型输入方法
    @RequestMapping(value = "/dataFormatIndex")
    public String dataFormatIndex(){
        return "dataFormat";
    }

    // 创建类型转换方法, 验证类型转换
    @RequestMapping(value = "/dataFormat", method = RequestMethod.POST)
    public String dataFormat(@ModelAttribute User user, Model model){
        System.out.println("调用控制器dataFormat()方法");
        model.addAttribute("user", user);
        return "dataFormatSuccess";
    }

    // 创建请求单文件上传页面方法
    @RequestMapping(value = "/oneFileUploadIndex")
    public String oneFileUploadIndex(){
        System.out.println("调用控制器oneFileUploadIndex()方法");
        return "oneFileUpload";
    }

    // 创建单文件上传控制器方法
    @RequestMapping(value = "/oneFileUpload", method = RequestMethod.POST)
    // @RequestParam()注解用于在该控制器中绑定请求参数到方法参数, 将表单中name=file传给MultipartFile类型的file属性
    public String oneFileUpload(@RequestParam(value = "file", required = false) MultipartFile file,
                                HttpServletRequest request, ModelMap modelMap){
        System.out.println("调用控制器oneFileUpload()方法");

        // 服务端upload文件夹路径
        String path = request.getSession().getServletContext().getRealPath("upload");
        // 获取文件名
        String fileName = file.getOriginalFilename();

        // 实例化一个对象，表示目标文件（包含物理路径）
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()){
            targetFile.mkdirs();
        }

        // 将上传文件写到服务器上的指定文件
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelMap.put("fileUrl", request.getContextPath() + "/upload/" + fileName);
        modelMap.put("fileName", fileName);
        return "fileUploadResult";
    }

    // 创建上传多文件页面方法
    @RequestMapping(value = "/manyFileUploadIndex")
    public String manyFileUploadIndex(){
        System.out.println("调用控制器manyFileUploadIndex()方法");
        return "manyFileUploadIndex";
    }

    // 创建上传多文件方法
    @RequestMapping(value = "/manyFileUpload")
    public String manyFileUpload(@RequestParam(value = "desc") String desc,
                                 @RequestParam(value = "files") List<MultipartFile> files,
                                 HttpServletRequest request){
        System.out.println("调用控制器manyFileUpload()方法");

        // 判断上传文件是否存在
        if (!files.isEmpty() && files.size()>0){

            // 循环输出上传的文件
            for (MultipartFile file:files){

                // 获取上传文件的名称
                String originalFilename = file.getOriginalFilename();

                // 设置上传文件的保存地址目录
                String dirpath = request.getServletContext().getRealPath("/upload/");

                File filepath = new File(dirpath);

                // 如果要保存的地址不存在，则创建该地址
                if (!filepath.exists()){
                    filepath.mkdirs();
                }

                // 使用uuid重新命名上传的文件名称(文件描述_uuid_原始文件名称)
                String newFilename = desc + "_" + UUID.randomUUID() + "_" + originalFilename;

                // 使用MultipartFile接口的方法将文件上传到指定位置
                try {
                    file.transferTo(new File(dirpath + newFilename));
                } catch (Exception e){
                    e.printStackTrace();
                    return "uploadError";
                }

            }
            return "uploadSuccess";
        } else {
            return "uploadError";
        }

    }
}
