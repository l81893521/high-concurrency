package com.will.highconcurrency.example.concurrent;

import com.will.highconcurrency.annoations.NotThreadSafe;
import com.will.highconcurrency.annoations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Will.Zhang on 2018/3/22 0022 17:09.
 */
@ThreadSafe
public class CopyOnWriteArrayListExample1 {

    //线程数
    public static int clientTotal = 5000;
    //并发数
    public static int threadTotal = 200;

    /*
    CopyOnWriteArrayList是线程安全的
    它在写的时候会加上锁, 然后拷贝一个副本再做修改
    修改完成后重新指向到新的数组上

    缺点是
    需要额外的空间, 如果数组过大可能会引发gc
    同时它满足了最终一致性, 但是不满足实时性
    读的时候, 数据可能不是最新的
     */
    private static List<Integer> list = new CopyOnWriteArrayList<>();

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
        System.out.println("arrayList size : " + list.size());
    }

    /**
     * 往arrayList添加值
     * @param i
     */
    private static void update(int i){
        list .add(i);
    }
}
