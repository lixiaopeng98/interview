package com.interview.demo.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ListStudy {
    /**
     * ArrayList(数组)
     * ArrayList 是最常用的List 实现类，内部是通过数组实现的，它允许对元素进行快速随机访问。数
     * 组的缺点是每个元素之间不能有间隔，当数组大小不满足时需要增加存储能力，就要将已经有数
     * 组的数据复制到新的存储空间中。当从ArrayList 的中间位置插入或者删除元素时，需要对数组进
     * 行复制、移动、代价比较高。因此，它适合随机查找和遍历，不适合插入和删除。
     * 3.2.2. Vector(数组实现，线程同步)
     * Vector 与ArrayList 一样，也是通过数组实现的，不同的是它支持线程的同步，即某一时刻只有一
     * 个线程能够写Vector，避免多线程同时写而引起的不一致性，但实现同步需要很高的花费，因此，
     * 访问它比访问ArrayList 慢。
     * 3.2.3. LinkList(链表)
     * LinkedList 是用链表结构存储数据的，很适合数据的动态插入和删除，随机访问和遍历速度比较
     * 慢。另外，他还提供了List 接口中没有定义的方法，专门用于操作表头和表尾元素，可以当作堆
     * 栈、队列和双向队列使用。
     */
    public void test(){

    }

    /**
     * 这里说一下 arrayList 为啥线程不安全
     * 1.
     * public boolean add(E e) {
     *      ensureCapacityInternal(size + 1);  // Increments modCount!!
     *      elementData[size++] = e;
     *      return true;
     * }
     * 在 add 的时候底层的 赋值方法  elementData[size++] = e; 分两步 一个是size++ 一个是赋值
     * 这两个不是原子操作 所以会产生size加了 但是值是被覆盖了
     */
    public void testArrayList(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
    }

    /**
     * 替代 array list 的方法有两种
     * 1. vector
     * 2. 用 Collections.synchronizedList 修饰一下 ArrayList
     */
    public void testArrayListTiDai(){
        Vector<String> vector = new Vector<>();
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<String>());
    }

    public static void main(String[] args) {
        System.out.println( 1 << 30);
        System.out.println( Integer.MAX_VALUE );


        System.out.println("aaa".hashCode() & (32 -1));
        System.out.println("aa1".hashCode() & (32 -1));
        System.out.println("aa2".hashCode() & (32 -1));
        System.out.println("aa3".hashCode() & (32 -1));
        System.out.println("aa4".hashCode() & (32 -1));
        System.out.println("aa5".hashCode() & (32 -1));
        System.out.println("aa6".hashCode() & (32 -1));
    }
}
