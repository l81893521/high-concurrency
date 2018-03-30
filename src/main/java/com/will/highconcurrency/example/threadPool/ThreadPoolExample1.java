package com.will.highconcurrency.example.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Will.Zhang on 2018/3/30 0030 18:07.
 */
public class ThreadPoolExample1 {

    public static void main(String[] args) {

        /*
        Executors.newCachedThreadPol : 创建可缓存线程池, 如果线程池长度超过了处理的需要, 可以灵活回收空闲线程, 或新建线程
         */
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("task : " + index);
                }
            });
        }
        //记得关闭线程池
        executorService.shutdown();
    }
}
