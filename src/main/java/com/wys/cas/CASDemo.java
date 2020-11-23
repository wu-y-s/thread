package com.wys.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

//java无法操作内存，但可调用c++进行 native修饰符
//Unsafe操作内存
//CAS一次只能操作一个共享变量的原子性，ABA问题，自旋锁耗时
public class CASDemo {


    public static void main(String[] args){
        AtomicInteger atomicInteger = new AtomicInteger(20);
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(20,1);
        //比较并交换,是期望值就交换
        atomicInteger.compareAndSet(20,21);

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(20,21,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);

            atomicStampedReference.compareAndSet(21,20,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
        });

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(20,666,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);

        });
    }
}
