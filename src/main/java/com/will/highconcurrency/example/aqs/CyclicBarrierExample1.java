package com.will.highconcurrency.example.aqs;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Will.Zhang on 2018/3/29 0029 17:02.
 */
public class CyclicBarrierExample1 {

    /*
    CyclicBarrier是AQS(AbstractQueuedSynchronizer)其中一个工具类
    它跟CountDownLatch有些相似
    它在初始化的时候可以指定一个数(目前是5)
    每一个线程调用await()方法之后, 这个值都会+1
    直到这个值等于初始化的值后(初始化值是5)
    那么等待中的线程都会开始执行(起跑的枪声)
     */
    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNumber = i;
            Thread.sleep(1000);
            //10个线程
            executor.execute(() -> {
                try {
                    race(threadNumber);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }

    private static void race(int threadNumber) throws Exception{
        Thread.sleep(1000);
        System.out.println(threadNumber + " is ready");
        //每一个线程调用await方法, 都会使计数器+1
        barrier.await();
        //计数器到达指定数字后(这里是5), 那么线程都会输出下面语句
        System.out.println(threadNumber + " continue");
    }
}
