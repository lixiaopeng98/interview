package com.interview.demo.thread.twotheardprint;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @describe: 实现 两个线程相互打印 结果是 实现不了
 * @author: lxp
 * @date: 2020/12/31 10:21
 */
public class CyclicBarrierPrint {

    private static CyclicBarrier cyclicBarrierOne = new CyclicBarrier(1);
    private static CyclicBarrier cyclicBarrierTwo = new CyclicBarrier(0);


    private static void threadOne(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrierOne.await();


                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
