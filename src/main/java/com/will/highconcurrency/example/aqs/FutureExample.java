package com.will.highconcurrency.example.aqs;

import java.util.concurrent.*;

/**
 * Created by Will.Zhang on 2018/3/30 0030 16:08.
 */
public class FutureExample {

    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("do something...");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //通过future接收另外一个线程计算的结果
        Future<String> future = executor.submit(new MyCallable());
        System.out.println("do something in main...");

        Thread.sleep(1000);
        //直接调用get便能获取myCallable这个线程执行的结果
        //如果该线程还没执行完毕, 则一直阻塞
        String result = future.get();

        System.out.println("result : " + result);

    }
}
