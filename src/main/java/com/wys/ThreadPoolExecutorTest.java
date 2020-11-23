package com.wys;

import java.util.concurrent.*;


//最大线程池怎么定义
//1.cpu密集型 根据cpu，几核就几个，cpu效率最高
//2.io密集型 判断程序中十分占用io的程序（线程） 创建线程池的个数大于程序数 一般2倍
public class ThreadPoolExecutorTest {

    public static void main(String args){
        ExecutorService threadPool=new ThreadPoolExecutor(
                //核心池
                2,
                //最大核心池
                5,
                //线程池中空闲线程等待工作的超时时间
                3,
                //超时单位
                TimeUnit.SECONDS,
                //阻塞队列
                new LinkedBlockingQueue<>(3),
                //创建线程工厂
                Executors.defaultThreadFactory(),
                //异常返回
                //new ThreadPoolExecutor.CallerRunsPolicy()
                //...
                new ThreadPoolExecutor.AbortPolicy()
        );

        for(int i=0;i<10;i++){
            threadPool.execute(()->{
            });


        }
    }
}
