package com.spring_mvc.entity;

import java.util.List;

/**
 * @Classname Coursex
 * @Description TODO
 * @Author 将烬星火是否太炽热, 明日黄花会开败阡陌
 * @Date 2020-04-03 10:20
 * @Version 1.0
 **/
public class Courses {

    private boolean reader;
    private List<String> cources;

    // getter() setter()

    public boolean isReader() {
        return reader;
    }

    public void setReader(boolean reader) {
        this.reader = reader;
    }

    public List<String> getCources() {
        return cources;
    }

    public void setCources(List<String> cources) {
        this.cources = cources;
    }
}
