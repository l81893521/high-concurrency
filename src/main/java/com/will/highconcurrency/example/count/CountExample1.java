package com.will.highconcurrency.example.count;

import com.will.highconcurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Will.Zhang on 2018/3/19 0019 16:40.
 * 此方法是线程不安全的
 */
@Slf4j
@NotThreadSafe
public class CountExample1 {

    //线程数
    public static int clientTotal = 5000;
    //并发数
    public static int threadTotal = 200;

    //用于计数
    public static int count = 0;

    /**
     * 此案例, 在多核cpu的环境下执行, 结果是错误的
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count:" + count);
    }

    /**
     * 计数
     */
    private static void add(){
        count++;
    }
}
