package com.will.highconcurrency.example.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Will.Zhang on 2018/3/30 0030 18:07.
 */
public class ThreadPoolExample2 {

    public static void main(String[] args) {

        /*
        Executors.newFixedThreadPool : 创建定长的线程池, 可以控制并发数, 超过的线程会在队列中等待
         */
        ExecutorService executorService = Executors.newFixedThreadPool(3);

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
