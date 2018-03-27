package com.will.highconcurrency.example.concurrent;

import com.will.highconcurrency.annoations.NotThreadSafe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Will.Zhang on 2018/3/22 0022 17:09.
 */
@NotThreadSafe
public class ConcurrentHashMapExample1 {

    //线程数
    public static int clientTotal = 5000;
    //并发数
    public static int threadTotal = 200;

    /*
    concurrentHashMap它对读做了大量的优化
     */
    private static Map<Integer, Integer> map = new ConcurrentHashMap<>();

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
        System.out.println("map size : " + map.size());
    }

    /**
     * 往map添加值
     * @param i
     */
    private static void update(int i){
        map.put(i, i);
    }
}
