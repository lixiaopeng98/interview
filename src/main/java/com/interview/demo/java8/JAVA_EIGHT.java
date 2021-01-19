package com.interview.demo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @describe: stream 和 predicate 一起使用
 * @author: lxp
 * @date: 2021/1/14 14:34
 */
public class JAVA_EIGHT {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("张三丰", "张翠山", "张无忌", "金毛狮王", "赵敏", "李张", "姓张");

        Predicate<String> predicateStarts = (n) -> n.startsWith("张");
        Predicate<String> predicate = (n) -> n.contains("张");

        list.stream().filter(predicate).forEach( item -> {
            System.out.println(item);
        });

        RealizePredicate realizePredicate = new ExRealizePredicate();
        list.stream().filter(realizePredicate).forEach(item -> System.out.println(item));
    }

}
