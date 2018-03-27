package com.will.highconcurrency.example.syncContainer;

import com.will.highconcurrency.annoations.NotThreadSafe;
import com.will.highconcurrency.annoations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Will.Zhang on 2018/3/22 0022 17:09.
 */
@ThreadSafe
public class VectorExample1 {

    //线程数
    public static int clientTotal = 5000;
    //并发数
    public static int threadTotal = 200;

    /*
    vector是线程同步的
    虽然说是同步的, 但并不代表是安全的
    下一个例子会说明
     */
    private static Vector<Integer> vector = new Vector<>();
    //private static List<Integer> list = new Vector<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        System.out.println("size : " + vector.size());
    }

    /**
     * 往vector添加值
     * @param i
     */
    private static void update(int i){
        vector.add(i);
    }
}
