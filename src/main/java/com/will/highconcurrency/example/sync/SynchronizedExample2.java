package com.will.highconcurrency.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Will.Zhang on 2018/3/20 0020 11:22.
 */
public class SynchronizedExample2 {

    /**
     * 使用synchronized修饰类
     * 作用范围:被修饰的代码块
     * 作用对象:调用这个方法的所有对象
     */
    public static void test1(int j){
        //synchronized括起来的代码都会被同步
        synchronized (SynchronizedExample2.class){
            for (int i = 0; i < 10; i++) {
                System.out.println("test 1 by "+ j + "- " + i);
            }
        }
    }


    /**
     * 使用synchronized修复静态方法
     * 作用范围:整个方法
     * 作用对象:调用这个方法的所有对象
     */
    public static synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            System.out.println("test 2 by "+ j + "- " + i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1(1);
            //example1.test2(1);

        });
        executorService.execute(() -> {
            example1.test1(2);
            //example2.test2(2);

        });
    }
}
