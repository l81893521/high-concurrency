
package com.will.highconcurrency.example.concurrent;

import com.will.highconcurrency.annoations.ThreadSafe;

import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by Will.Zhang on 2018/3/22 0022 17:09.
 */
@ThreadSafe
public class ConcurrentSkipListSetExample1 {

    //线程数
    public static int clientTotal = 5000;
    //并发数
    public static int threadTotal = 200;

    /*
    ConcurrentSkipListSet
    调用add, contain, remove等操作能够保证原子性
    但是要注意
    调用addAll, containAll, removeAll等操作它并不能够保证原子性
    因为以上批量操作最终都是多次调用add, contain, remove
    它只能够保证每一次的单一操作是原子性
    如果要进行批量操作, 还是要自己加上锁
     */
    private static Set<Integer> set = new ConcurrentSkipListSet<>();

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
        System.out.println("arrayList size : " + set.size());
    }

    /**
     * set
     * @param i
     */
    private static void update(int i){
        set .add(i);
    }
}
