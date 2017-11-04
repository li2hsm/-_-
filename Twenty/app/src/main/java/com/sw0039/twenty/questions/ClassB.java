package com.sw0039.twenty.questions;

/**
 * 数据bean的父类
 * Created by Administrator on 2017/10/20.
 */
public class ClassB extends ClassA{

    public String id = "ClassB";
    private String name;
    private String age;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
