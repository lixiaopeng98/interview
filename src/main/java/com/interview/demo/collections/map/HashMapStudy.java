package com.interview.demo.collections.map;

import java.util.HashMap;

public class HashMapStudy {

    /**
     * HashMap (数组+链表+红黑树)
     * HashMap 根据键的hashCode 值存储数据，大多数情况下可以直接定位到它的值，因而具有很快
     * 的访问速度，但遍历顺序却是不确定的。 HashMap 最多只允许一条记录的键为null，允许多条记
     * 录的值为null。HashMap 非线程安全，即任一时刻可以有多个线程同时写HashMap，可能会导
     * 致数据的不一致。如果需要满足线程安全，可以用 Collections 的synchronizedMap 方法使
     * HashMap 具有线程安全的能力，或者使用ConcurrentHashMap。我们用下面这张图来介绍
     * HashMap 的结构。
     *
     * HashMap 在链表长度 大于 8 的时候会转成红黑树
     */
    /**
     * HashMap 的 扩容机制
     * 1. 在首次 put 数据的时候扩容
     *    初始容量 = newCap = DEFAULT_INITIAL_CAPACITY = 1 << 4 = 16
     *    初始阈值 = threshold = newThr = DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY  =  0.75f * (1 << 4 = 16)
     *    并创建一个新的长度为16的Node数组
     * 2. 当该数组中存入的元素长度达到阈值时，也即12位时，又会发生扩容，先判断原数组长度是否大于等于能够分配的长度上限-2的30次方，
     *    如果达到，则不再扩容，并将阈值设置为Integer.MAX_VALUE，2的31次方-1，否则将原数组扩容至新容量为原数组额两倍，
     *    阈值也扩大至原来阈值的两倍，设置好要扩容的容量后，接下来就开始根据新的容量创建新的Node数组，遍历原数组，
     *    将原数组里的数据转移到新数组中，如果原数组元素的next指针为空，说明不存在链表结构，
     *
     *    则元素转移到新数组的下标计算方式为上图所示，通过元素的hash值与新数组容量-1做与运算,这么做的目的也是为了使数据更加的散列，
     *    与运算的逻辑是必须同时为1才等于1，这样就减少了hash碰撞的概率，举个例子，如果新容量为32，则其二进制为100000，
     *    如果用该二进制去进行与运算时，基本上都为0，hash碰撞的概率很大，但是一旦减1后变为31，其二进制变为11111，
     *    进行与运算时变为0或1的概率都比较均匀，发生hash碰撞的概率就会小很多，这也同时解释了为什么扩容的容量要是2的倍数，
     *    就是为了这一步减1做准备的，否则就没有必要减1了。如果原数组元素的next指针不为空，则会判断是否为红黑树结构或者为链表结构
     */
    /**
     * HashMap 的 扩容机制
     * 1. 在第一次 put的时候扩容 调用 resize
     *      默认容量为 16
     *      默认阈值为 = 负载因子 * 默认容量 = 0.75*16 = 12
     * 2. 在put数据的时候 检查长度 是否超过阈值 如果超过了阈值就会进行扩容
     *      调用 resize
     *      容量 = old容量 的两倍 = 16 * 2
     *      阈值 = 32 * 0.75 = 24
     */

    /**
     * HashMap 的线程不安全
     *
     * 在put方法的时候 会造成 覆盖
     * if ((p = tab[i = (n - 1) & hash]) == null)
     *    tab[i] = newNode(hash, key, value, null);
     *
     */
    public void testHashMap(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("aaa","");
    }

    public static void main(String[] args) {
        System.out.println(1 << 30);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("aaa","aaa");
        hashMap.put("aa1","aaa");
        hashMap.put("aa2","aaa");
        hashMap.put("aa3","aaa");
        hashMap.put("aa4","aaa");
        hashMap.put("aa5","aaa");
        hashMap.put("aa6","aaa");
        hashMap.put("aa7","aaa");
        hashMap.put("aa8","aaa");
        hashMap.put("aa9","aaa");
        hashMap.put("aa10","aaa");
        hashMap.put("aa11","aaa");

        hashMap.keySet().stream().forEach(item ->{
            System.out.println(item);
        });

    }
}
