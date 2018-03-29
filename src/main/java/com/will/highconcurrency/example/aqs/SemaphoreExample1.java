package com.will.highconcurrency.example.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Will.Zhang on 2018/3/29 0029 15:35.
 */
public class SemaphoreExample1 {

    private final static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        /*
         * Semaphore(信号量)是AQS(AbstractQueuedSynchronizer)其中一个工具类
         * 可以理解成一个控制并发的工具类
         * 它在初始化的时候可以指定发放许可的数量(厕所只有3个空位)
         * 每一个线程在执行前都要获取一个许可acquire()(占一个坑)
         * 当所有许可全部发放完毕(没坑了)
         * 新的线程就必须进行等待, 等到原来的线程执行完毕, 并且释放许可release()(从坑里出来)
         */
        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    //获取一个许可
                    semaphore.acquire();
                    //这里可以看到输出是一块一块的(每次20条, 因为许可只有20个而且test方法sleep了1000毫秒)
                    test(threadNum);
                    //释放一个许可
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        System.out.println(threadNum);
        Thread.sleep(1000);
    }
}
