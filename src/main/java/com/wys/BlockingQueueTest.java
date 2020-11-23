package com.wys;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        //阻塞队列
        ArrayBlockingQueue blokingQueue=new ArrayBlockingQueue(3);
        //同步队列，放一取一
        BlockingQueue<String> blokingQueue1=new SynchronousQueue<>();
        //阻塞抛出异常
        blokingQueue.add("a");
        blokingQueue.remove();

        //阻塞返回true或false
        blokingQueue.offer("a");
        //返回null
        blokingQueue.poll();


        //一直等待
        blokingQueue.put("a");
        blokingQueue.take();

        //等待一定时间
        blokingQueue.offer("a",1, TimeUnit.SECONDS);
    }
}
