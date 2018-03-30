package com.will.highconcurrency.example.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Will.Zhang on 2018/3/30 0030 18:07.
 */
public class ThreadPoolExample3 {

    public static void main(String[] args) {

        /*
         Executors.newSingleThreadExecutor : 创建单线程化的线程池, 只会用唯一的线程执行任务
         所以看见输出结果都是按顺序的了
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();

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
