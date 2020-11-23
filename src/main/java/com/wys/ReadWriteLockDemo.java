package com.wys;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args){

    }
}
class MyCache{

    private volatile Map<String,Object> map = new HashMap<>();
    //读写锁

    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    //写入时只希望一个线程
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
    }

    //读时都可以
    public void get(String key){
        readWriteLock.readLock().lock();
    }

}
