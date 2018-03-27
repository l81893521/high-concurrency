package com.will.highconcurrency.example.syncContainer;

import com.will.highconcurrency.annoations.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Will.Zhang on 2018/3/22 0022 17:09.
 */
@ThreadSafe
public class CollectionsExample3 {

    //线程数
    public static int clientTotal = 5000;
    //并发数
    public static int threadTotal = 200;

    /*
    使用Collections生成同步容器
     */
    private static Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());

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
        System.out.println("size : " + map.size());
    }

    /**
     * 往map添加值
     * @param i
     */
    private static void update(int i){
        map.put(i, i);
    }
}
