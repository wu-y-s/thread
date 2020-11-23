package com.wys;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.add();

            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.add();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.del();
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.del();
            }
        }, "D").start();
    }


}

class Data {
    private int sum;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void add() {
        lock.lock();
        try {
            while (sum != 0) {
                condition.await();
            }
            sum++;
            System.out.println(Thread.currentThread().getName() + "->" + sum);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void del() {
        lock.lock();
        try {
            while (sum == 0) {
                condition.await();
            }
            sum--;
            System.out.println(Thread.currentThread().getName() + "->" + sum);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
