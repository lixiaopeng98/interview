package com.interview.demo.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序
 * （1）比较前后相邻的二个数据，如果前面数据大于后面的数据，就将这二个数据交换。
 * （2）这样对数组的第0 个数据到N-1 个数据进行一次遍历后，最大的一个数据就“沉”到数组第 N-1 个位置。
 * （3）N=N-1，如果N 不为0 就重复前面二步，否则排序完成。
 * 参考文献
 * https://www.jianshu.com/p/1458abf81adf
 */
public class Bubbling {

    /**
     * 冒泡排序
     *
     * @param a
     * @param n
     */
    public static void bubbleSort(int [] a, int n){
        int i, j;
        //表示n 次排序过程。
        for(i=0; i<n; i++){
            for(j=1; j<n-i; j++){
                //前面的数字大于后面的数字就交换
                if(a[j-1] > a[j]){
                    //交换a[j-1]和a[j]
                    int temp;
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 9, 10, 22, 44, 7, 8, 17, 28};
        bubbleSort(ints, ints.length);
        System.out.println(Arrays.toString(ints));
    }

}
