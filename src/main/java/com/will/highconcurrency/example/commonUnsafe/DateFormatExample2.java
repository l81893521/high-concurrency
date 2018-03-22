package com.will.highconcurrency.example.commonUnsafe;

import com.will.highconcurrency.annoations.NotThreadSafe;
import com.will.highconcurrency.annoations.ThreadSafe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Will.Zhang on 2018/3/22 0022 16:21.
 */
@ThreadSafe
public class DateFormatExample2 {

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
    }

    /**
     * 使用SimpleDateFormat进行格式转换
     * 由于SimpleDateFormat不是线程安全的
     * 所以这里使用堆栈封闭的形式(局部变量)来实现
     * 那么DateFormatExample1的错误就不会出现了
     */
    private static void update(){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            simpleDateFormat.parse("20180322");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
