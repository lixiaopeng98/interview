package com.interview.demo.collections.map;

import com.interview.demo.enumclass.UserEnum;

import java.util.EnumMap;

/**
 * 存的是个枚举对象
 */
public class EnumMapStudy {

    public static void testEnumMap(){
        EnumMap<UserEnum, Object> enumMap = new EnumMap<>(UserEnum.class);
        enumMap.put(UserEnum.admin, "aaa");
        enumMap.put(UserEnum.ordinary, "bbb");

        enumMap.keySet().stream().forEach(item -> {
            System.out.println(item.type + ":" + enumMap.get(item));
        });
    }

    public static void main(String[] args) {
        testEnumMap();
    }
}
