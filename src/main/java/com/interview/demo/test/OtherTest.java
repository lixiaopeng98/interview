package com.interview.demo.test;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.*;

public class OtherTest {

    public static void test(){
        String aaa = DigestUtils.sha256Hex("aaa");
        System.out.println(aaa);
    }

    public static void main(String[] args) {

        System.out.println(1 << 30);

        test();

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aa");
        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        list.add("aabb");


        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("bb");

        Vector<String> vector = new Vector<>();
        vector.add("aa");


        System.out.println( 12 >> 1);
        System.out.println( -12 >> 1);
        System.out.println( 12 >>> 1);
        System.out.println( -12 >>> 1);

        hashSet();

    }

    public void setTest(){
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("kkk");
        treeSet.add("aaa");
        treeSet.add("aaa");
        treeSet.add("bbb");
        treeSet.add("bbb");
        treeSet.add("111");
        treeSet.stream().forEach(item -> {
            System.out.println(item);
        });
    }

    public static void hashSet(){
        String a1 = "111";
        String a = "aaa";
        String b = "bbb";
        String k = "kkk";

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("111");
        hashSet.add("kkk");
        hashSet.add("aaa");
        hashSet.add("bbb");
        hashSet.stream().forEach(item -> {
            System.out.println(item);
        });
        System.out.println("a=" + a.hashCode() + ";b=" + b.hashCode() + ";k=" + k.hashCode() + ";a1=" + a1.hashCode());
    }
}
