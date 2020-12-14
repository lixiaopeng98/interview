package com.interview.demo.algorithm;

/**
 * 二叉查找算法
 * 又叫折半查找，要求待查找的序列有序。每次取中间位置的值与待查关键字比较，如果中间位置
 * 的值比待查关键字大，则在前半部分循环这个查找的过程，如果中间位置的值比待查关键字小，
 * 则在后半部分循环这个查找的过程。直到查找到了为止，否则序列中没有待查的关键字。
 */
public class BinarySearch{

    static int cc = 1000000;

    public static void main(String[] args) {
        int[] num = new int[cc];
        for (int i = 0; i < cc; i++) {
            num[i] = i;
        }
        findNum(782346, num, 0, --cc);
    }

    /**
     * 开始算法
     * 先找出 开始查找的下标 到  传入的最大下标 的 中间下标
     *
     * 预计会出现的 三种情况 处理一下
     * (目标值 == 中间下标的值) 找到目标值了
     * (目标值 > 中间下标的值) 开始查找 中间下标+1 到 传入的最大下标
     * (目标值 < 中间下标的值) 开始查找 开始查找的下标 到 中间下标-1
     *
     * @param findNum 要查找的目标值
     * @param num   int数组
     * @param low   开始查找的下标
     * @param height  高度
     */
    public static void findNum(int findNum, int[] num, int low, int height) {
        int length = (low + height) / 2;
        System.err.println(low + "==" + height + "==" + num[length] + ";length==" + length);
        if (findNum == num[length]) {
            System.err.println("完成;下标为"+length+";下标取值为"+num[length]);
        } else if (findNum > num[length]) {
            findNum(findNum, num, length + 1, height);
        } else if (findNum < num[length]) {
            findNum(findNum, num, low, length - 1);
        }
    }

}
