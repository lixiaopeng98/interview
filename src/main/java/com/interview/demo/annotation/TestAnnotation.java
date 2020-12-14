package com.interview.demo.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@AnnotationGet(name = "aaa", remarks = "aaa")
public class TestAnnotation {

    public String name;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = Class.forName("com.interview.demo.annotation.TestAnnotation");

        AnnotationGet annotation = (AnnotationGet) clazz.getAnnotation(AnnotationGet.class);
        System.out.println(annotation.name() + ";" + annotation.remarks());


        // 获取 在方法上 注解的信息
        Method[] allMethods = clazz.getDeclaredMethods();
        // 获取 在元素上 注解的信息
        Field[] declaredFields = clazz.getDeclaredFields();
        // 获取 在指定方法上  注解信息
        Method methodTest = clazz.getDeclaredMethod("test");

    }
}
