package com.wys;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest2 {
    public static void main(String[] args) {
        Data2 data = new Data2();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printA();

            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printD();
            }
        }, "D").start();
    }


}

class Data2 {
    private int sum=1;
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    Condition condition4 = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            while (sum != 1) {
                condition1.await();
            }
            sum=2;
            System.out.println(Thread.currentThread().getName() + "->" + sum);
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (sum != 2) {
                condition2.await();
            }
            sum=3;
            System.out.println(Thread.currentThread().getName() + "->" + sum);
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printC() {
        lock.lock();
        try {
            while (sum != 3) {
                condition3.await();
            }
            sum=4;
            System.out.println(Thread.currentThread().getName() + "->" + sum);
            condition4.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printD() {
        lock.lock();
        try {
            while (sum != 4) {
                condition4.await();
            }
            sum=1;
            System.out.println(Thread.currentThread().getName() + "->" + sum);
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}




