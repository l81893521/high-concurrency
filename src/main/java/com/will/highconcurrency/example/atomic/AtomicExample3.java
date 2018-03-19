package com.will.highconcurrency.example.atomic;

import com.will.highconcurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by Will.Zhang on 2018/3/19 0019 16:40.
 * 此方法是线程安全的
 */
@Slf4j
@ThreadSafe
public class AtomicExample3 {

    //线程数
    public static int clientTotal = 5000;
    //并发数
    public static int threadTotal = 200;

    /*
    用于计数
    LongAdder 是1.8新增的一个类
    它跟AtomicLong的区别是
    LongAdder在AutomicLong的基础上, 将单点的压力分分散到各个节点, 在低并发的时候通过对base的直接更新可以很好的保障和AtomicLong的性能基本保持一直
    而在高并发的时候通过分散提高了性能
    缺点是LongAddr在统计的时候如果有并发更新, 可能导致统计的数据有误差
     */
    public static LongAdder count = new LongAdder();

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
        count.increment();
    }
}
