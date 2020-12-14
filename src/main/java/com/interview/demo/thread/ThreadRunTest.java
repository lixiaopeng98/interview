package com.interview.demo.thread;

import com.interview.demo.thread.stop.ThreadInterruptStop;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
public class ThreadRunTest {

    public static void main(String[] args) throws InterruptedException {
        testStop();
    }
    @Scheduled(cron = " 1 1 1 * * * ?")
    public static void testIAdd(){
        ThreadRunnableTest threadRunnableTest = new ThreadRunnableTest(20);
        Thread thread = new Thread(threadRunnableTest);
        thread.start();
        System.out.println("完成");

        thread.isInterrupted();
        thread.interrupt();
    }

    public static void  testStop() throws InterruptedException {
        ThreadInterruptStop threadStop = new ThreadInterruptStop();
        Thread thread = new Thread(threadStop);
        thread.start();
        System.out.println("线程启动！");
        Thread.sleep(100L);
        thread.interrupt();
        System.out.println("调用完毕！");
    }

}
