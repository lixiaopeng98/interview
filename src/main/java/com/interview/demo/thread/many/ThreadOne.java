package com.interview.demo.thread.many;

public class ThreadOne implements Runnable {

    private ThreadLocal threadLocal = new ThreadLocal();

    @Override
    public void run() {
        Object o = threadLocal.get();
        System.out.println(o);
    }

}
