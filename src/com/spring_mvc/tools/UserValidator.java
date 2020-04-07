package com.spring_mvc.tools;

import com.spring_mvc.entity.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @Classname UserValidator
 * @Description TODO
 * @Author 将烬星火是否太炽热, 明日黄花会开败阡陌
 * @Date 2020-04-07 10:39
 * @Version 1.0
 **/
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        // 验证username, age, sex是否为null
        ValidationUtils.rejectIfEmpty(errors, "name", null, "用户名不能为空");
        ValidationUtils.rejectIfEmpty(errors, "age", null, "用户名不能为空");
        ValidationUtils.rejectIfEmpty(errors, "sex", null, "用户名不能为空");
    }
}
