package com.interview.demo.collections.map;

import com.interview.demo.enumclass.UserEnum;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * TreeMap
 *
 * 这玩意 是有序的
 */
public class TreeMapStudy {

    /**
     * A
     * /  \
     * B    E
     * / \    \
     * C  D     F
     * 这里介绍一下  树的三种遍历方式
     * 1. 前序遍历
     * 根节点+左子树+右子树。
     * 在遍历左子树和右子树时，仍然先访问根节点，然后遍历左子树，最后遍历右子树。
     * ABCDEF
     * 2. 中序遍历
     * 左子树+根节点+右子树。
     * 在遍历左右子树时，仍然先遍历左子树，再遍历根节点，后遍历右子树。
     * CBDAFE
     * 3. 后序遍历
     * 左子树+右子树+根节点。
     * 在遍历左右子树时，仍然先遍历左子树，在遍历右子树，后访问根节点
     * CDBFEA
     */

    // 前序 根左右
    // 中序 左根右
    // 后序 左右根
    public void allMap() {


        Hashtable<String, Object> hashtable = new Hashtable<>();
        HashMap<String, Object> hashMap = new HashMap<>();
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        TreeMap<String, Object> treeMap = new TreeMap<>();
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<String, Object>();
        ConcurrentSkipListMap<String, Object> concurrentSkipListMap = new ConcurrentSkipListMap<String, Object>();
        EnumMap<UserEnum, String> enumMap = new EnumMap<UserEnum, String>(UserEnum.class);
        WeakHashMap<String, Object> weakHashMap = new WeakHashMap<String, Object>();
        IdentityHashMap<String, Object> identityHashMap = new IdentityHashMap<String, Object>();
    

    }

    /**
     * 有序的map
     */
    public static void testLinkedHashMap() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
        linkedHashMap.put("1", "11");
        linkedHashMap.put("kkk", "kkk");
        linkedHashMap.put("aaa", "aaa");
        linkedHashMap.put("cc", "ccc");
        linkedHashMap.keySet().stream().forEach(item -> {
            System.out.println(item);
        });
        System.out.println("testLinkedHashMap 打印完毕");
    }

    /**
     * 根据字母排序
     */
    public static void testTreeMap() {
        TreeMap<String, Object> treeMap = new TreeMap<>();
        treeMap.put("ll", "ll");
        treeMap.put("hh", "hh");
        treeMap.put("mm", "mm");
        treeMap.put("aa", "aa");
        treeMap.put("11", "11");
        treeMap.put("a1", "a1");
        treeMap.keySet().stream().forEach(item -> {
            System.out.println(item);
        });
        System.out.println("testTreeMap 打印完毕");
    }

    public static void testConcurrentHashMap() {
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<String, Object>();
        concurrentHashMap.put("aaa", "aa");

        System.out.println("testTreeMap 打印完毕");

        ConcurrentSkipListMap<String, Object> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        concurrentSkipListMap.put("aaa", "aa");


    }


    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
//        testLinkedHashMap();
//        testTreeMap();
//        System.out.println(2 << 3);


        String s = "aa";
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(s.getBytes());
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        System.out.println("");
    }
}
