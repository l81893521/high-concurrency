package com.will.highconcurrency.example.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Will.Zhang on 2018/3/30 0030 16:22.
 */
public class FutureTaskExample1 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /*
        futureTask使用起来还是比较方便
        如果以后需要用到线程而且关注它的返回结果
        那么推荐使用futureTask
        初始化的时候可以传入Callable或者Runnable
        调用get()就能得到该线程的返回值

         */
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("do something...");
                Thread.sleep(5000);
                return "Done";
            }
        });

        new Thread(futureTask).start();
        System.out.println("do something in main...");
        Thread.sleep(1000);
        //如果该线程还没执行完毕, 则会一直阻塞
        String result = futureTask.get();
        System.out.println("result : " + result);


    }
}
