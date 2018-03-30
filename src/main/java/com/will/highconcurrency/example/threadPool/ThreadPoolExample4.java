package com.will.highconcurrency.example.threadPool;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Will.Zhang on 2018/3/30 0030 18:07.
 */
public class ThreadPoolExample4 {

    public static void main(String[] args) {

        /*
         Executors.newScheduledThreadPool : 创建定长的线程池, 支持周期或定时的线程执行
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        /*
        它可以指定延时多久后才执行
         */
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("schedule run");
            }
        }, 3, TimeUnit.SECONDS);

        /*
        也可以指定频率(延迟1秒后, 每隔3秒执行一次)
        不过如果把线程池关闭了就不会执行了
         */
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("at fixed rate run");
            }
        }, 1 , 3 , TimeUnit.SECONDS);

        /*
        timer也可以实现相似功能(每隔5秒执行一次)
         */
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("time task run");
            }
        }, new Date(), 5 * 1000);

        //scheduledExecutorService.shutdown();
    }
}
