package com.interview.demo.redis;

public class TestRedisLock {
    /**
     * 这里详细 说一下 redis 分布式锁
     * 1. 了解 setnx  setex 这两个操作是原子操作
     * 2. 释放的时候 需要 判断自己是否还持有锁
     * 3. 在业务 块加 try{}catch{}finally{} 在try 之前去获取锁 在finally里释放锁
     */
    public void lockDoc(){
        try {

        }catch (Exception ex){

        }finally {

        }
    }
}
