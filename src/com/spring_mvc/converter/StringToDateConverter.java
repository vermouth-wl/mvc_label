package com.spring_mvc.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname StringToDateConverter
 * @Description TODO
 * @Author 将烬星火是否太炽热, 明日黄花会开败阡陌
 * @Date 2020-04-13 10:39
 * @Version 1.0
 **/
public class StringToDateConverter implements Converter<String, Date> {

    // 日期转换格式
    private String partten;

    // 构造函数

    @Override
    public Date convert(String s) {
        // yyyy-MM-dd
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(partten);
        try {
            return simpleDateFormat.parse(s);
        } catch (Exception e) {
            throw new IllegalAccessError("时间转换出错");
        }
    }

    public String getPartten() {
        return partten;
    }

    public void setPartten(String partten) {
        this.partten = partten;
    }
}
