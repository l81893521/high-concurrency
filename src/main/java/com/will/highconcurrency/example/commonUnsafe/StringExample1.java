package com.will.highconcurrency.example.commonUnsafe;

import com.will.highconcurrency.annoations.NotThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Will.Zhang on 2018/3/22 0022 16:11.
 */
@NotThreadSafe
public class StringExample1 {

    //线程数
    public static int clientTotal = 5000;
    //并发数
    public static int threadTotal = 200;

    /*
    StringBuilder是线程不安全的
    因为它的实现并没有对并发情况下进行特殊处理

    但是如果是在方法里定义局部变量(它数据堆栈封闭, 不会出现线程安全问题) 那么用StringBuilder是完全可以的
    并且是高效的
     */
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        System.out.println("size:" + stringBuilder.length());
    }

    /**
     * 往stringBuilder里追加字符串"1"
     */
    private static void update(){
        stringBuilder.append("1");
    }
}
