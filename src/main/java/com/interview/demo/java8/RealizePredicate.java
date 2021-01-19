package com.interview.demo.java8;

import java.util.function.Predicate;

/**
 * @describe: 实现 predicate
 * @author: lxp
 * @date: 2021/1/14 14:44
 */
public abstract class RealizePredicate<T> implements Predicate<T> {


    public boolean test(T o){
        String k = (String) o;
        return k.contains("王");
    }

}
