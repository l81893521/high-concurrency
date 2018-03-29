package com.will.highconcurrency.example.lock;

import com.will.highconcurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Will.Zhang on 2018/3/19 0019 16:40.
 */
@Slf4j
@ThreadSafe
public class LockExample2 {

    //线程数
    public static int clientTotal = 5000;
    //并发数
    public static int threadTotal = 200;

    //用于计数
    public static int count = 0;

    /*
    创建ReentrantLock
    默认是非公平锁, 可以通过传入参数指定公平锁或者非公平锁
     */
    private final static Lock lock = new ReentrantLock();

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
        System.out.println("count:" + count);
    }

    /**
     * 计数
     */
    private static void add(){
        //加锁
        lock.lock();
        try {
            count++;
        } finally{
            lock.unlock();
        }


    }
}
