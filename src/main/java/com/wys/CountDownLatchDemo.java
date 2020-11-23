package com.wys;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class CountDownLatchDemo {
    public static void main(String[] args) {
//        Semaphore semaphore=new Semaphore(3);
//        semaphore.acquire();获得
//        semaphore.release();释放
        CountDownLatch countDownLatch = new CountDownLatch(6);
        //减法计数器，每次线程被调用CountDownLatch-1,当为0时调用countDownLatch.await();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("v");
        });
        //加法计数器
        for (int i = 1; i <= 7; i++) {
            final int temp=i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"->"+temp);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
