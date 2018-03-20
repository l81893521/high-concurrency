package com.will.highconcurrency.example.count;

import com.will.highconcurrency.annoations.NotThreadSafe;
import com.will.highconcurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Will.Zhang on 2018/3/19 0019 16:40.
 */
@Slf4j
@ThreadSafe
public class CountExample2 {

    //线程数
    public static int clientTotal = 5000;
    //并发数
    public static int threadTotal = 200;

    //用于计数
    public static AtomicInteger count = new AtomicInteger(0);

    /**
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
        System.out.println("count:" + count.get());
    }

    /**
     * 使用atomicInteger来保证了线程竞争的情况下
     * count的一致性
     * 计数
     */
    private static void add(){
        count.incrementAndGet();
    }
}
