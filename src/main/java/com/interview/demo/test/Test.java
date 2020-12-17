package com.interview.demo.test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {


    public static void main(String[] args) {
        String aaa = new String("aaa");

        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        String s = new String();

        // synchronized 有此修饰 线程安全
        stringBuffer.append("");
        // 没有 锁修饰  所以线程不安全
        stringBuilder.append("kk");

//        arraySort();
        sort();


        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.addAndGet(1);
        int i = atomicInteger.get();
    }

    public static void mapUnderstand() {
        HashMap<String, Object> hashMap = new HashMap<>(8);
        Hashtable<String, Object> hashtable = new Hashtable<>(8);

        hashMap.put("aa", "aa");
        hashtable.put("aa", "aa");

        hashMap.put(null, "kk");
//        hashtable.put(null, "kk");

    }


    public static void listUnderstand() {

        ArrayList<String> arrayList = new ArrayList<>();

        LinkedList<String> linkedList = new LinkedList<>();

        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("3");
        arrayList.add("4");

        linkedList.add("1");
        linkedList.add("1");
        linkedList.add("3");
        linkedList.add("4");

        arrayList.stream().forEach(item -> {
            System.out.println(item);
        });
        linkedList.stream().forEach(item -> {
            System.out.println(item);
        });

        Vector vector = new Vector();
        vector.add("1");
        vector.add("1");
        vector.add("3");
        vector.add("4");

        vector.stream().forEach(item -> {
            System.out.println(item);
        });


        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("1");
        set.add("3");
        set.add("4");
        set.stream().forEach( item -> {
            System.out.println(item);
        });
    }

    public static void dataLength(){

        // int 4
        // float 4
        // double 8
        // long 8
        // byte 1
        // char 2
        // short 2
        // boolean 1
    }
    public static void sort() {
        Scanner input = new Scanner(System.in);
        int sort[] = new int[10];
        int temp;
        System.out.println("请输入10 个排序的数据：");
        for (int i = 0; i < sort.length; i++) {
            sort[i] = input.nextInt();
        }
        for (int i = 0; i < sort.length - 1; i++) {
            for (int j = 0; j < sort.length - i - 1; j++) {
                if (sort[ j] < sort[ j + 1]) {
                    temp = sort[ j];
                    sort[ j] = sort[ j + 1];
                    sort[ j + 1] = temp;
                }
            }
        }
        System.out.println("排列后的顺序为：");
        for(int i=0;i<sort.length;i++){
            System.out.print(sort[i]+" ");
        }
    }

    public static void arraySort(){
        int[] ints = {9, 2, 4, 6, 3, 1, 8, 3, 9, 10, 6};
        Arrays.sort( ints);
        Arrays.stream(ints).forEach( item -> {
            System.out.println(item);
        });
        int i = Arrays.binarySearch(ints, 6);
        System.out.println(i);
    }
}
