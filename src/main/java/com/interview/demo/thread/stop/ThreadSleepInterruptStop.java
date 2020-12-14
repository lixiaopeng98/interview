package com.interview.demo.thread.stop;

public class ThreadSleepInterruptStop implements Runnable {

    @Override
    public void run() {

        try {
            int cc = 1000;
            for (int i = 0; i < cc; i++) {
                System.out.println(i);
            }
            System.out.println("线程执行完循环");
            Thread.sleep(200L);
            System.out.println("线程结束");
        }catch (InterruptedException exception){
            System.out.println( exception);
        }

    }


    public static void main(String[] args) {
        ThreadSleepInterruptStop threadSleep = new ThreadSleepInterruptStop();
        Thread thread = new Thread(threadSleep);
        thread.start();
        System.out.println("线程启动");
        thread.interrupt();
        System.out.println("线程停止");

    }
}
