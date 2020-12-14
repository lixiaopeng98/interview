package com.interview.demo.thread.stop;

public class ThreadInterruptStop implements Runnable {

    @Override
    public void run() {
        try {
            Thread thread = Thread.currentThread();
            int cc = 10000;
            for (int i = 0; i < cc; i++) {
                if (thread.isInterrupted()){
                    System.out.println(thread.getName() + ":true,退!");
                    throw new InterruptedException();
                }
                System.out.println(thread.getName() + ";false,不"+i);
            }
            System.out.println("又执行了 这句话");
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
