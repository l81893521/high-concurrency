package com.will.highconcurrency.example.atomic;

import com.will.highconcurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by Will.Zhang on 2018/3/19 0019 16:40.
 * 此方法是线程安全的
 * 对test()方法执行5000次
 * 但是保证只会成功执行1次
 */
@Slf4j
@ThreadSafe
public class AtomicExample6 {

    private static AtomicBoolean isHappened = new AtomicBoolean(false);

    //线程数
    public static int clientTotal = 5000;
    //并发数
    public static int threadTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        System.out.println("isHappened :" + isHappened.get());
    }

    /**
     * 由于使用了AtomicBoolean
     * 虽然此方法会被调用5000次
     * 但是只有1次能够把AtomicBoolean从false改为true
     * 可以通过控制台输出看到
     */
    private static void test(){
        //如果是false, 则改变为true
        if(isHappened.compareAndSet(false, true)){
            System.out.println("execute success");
        }
    }

}
