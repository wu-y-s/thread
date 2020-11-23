package com.wys;

import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());

        TimeUnit.DAYS.sleep(1);
    }
}
