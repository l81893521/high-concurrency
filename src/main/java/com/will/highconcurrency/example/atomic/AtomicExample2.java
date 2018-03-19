package com.will.highconcurrency.example.atomic;

import com.will.highconcurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Will.Zhang on 2018/3/19 0019 16:40.
 * 实现一个计数功能, 多个线程同时对count进行累加
 * 保证最后结果是正确的
 * 此方法是线程安全的
 */
@Slf4j
@ThreadSafe
public class AtomicExample2 {

    //线程数
    public static int clientTotal = 5000;
    //并发数
    public static int threadTotal = 200;

    /*
    用于计数
    使用了AtomicLong来保证了原子性
     */
    public static AtomicLong count = new AtomicLong(0);

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
     * 计数
     */
    private static void add(){
        //先增加, 后获取
        count.incrementAndGet();
        //先获取, 后增加
        //count.getAndIncrement();
    }
}
