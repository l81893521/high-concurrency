package com.will.highconcurrency.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Will.Zhang on 2018/3/20 0020 11:22.
 */
public class SynchronizedExample1 {

    /**
     * 使用synchronized修饰代码块
     * 作用范围:被修饰的代码块
     * 作用对象:调用这个方法的对象
     */
    public void test1(){
        //synchronized括起来的代码都会被同步
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.println("test 1 - " + i);
            }
        }
    }
    /**
     * 使用synchronized修饰代码块
     * 作用范围:被修饰的代码块
     * 作用对象:调用这个方法的对象
     */
    public void test1(int j){
        //synchronized括起来的代码都会被同步
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.println("test 1 by "+ j + "- " + i);
            }
        }
    }

    /**
     * 使用synchronized修复方法
     * 作用范围:整个方法
     * 作用对象:调用这个方法的对象
     */
    public synchronized void test2(){
        for (int i = 0; i < 10; i++) {
            System.out.println("test 2 - " + i);
        }
    }

    /**
     * 使用synchronized修复方法
     * 作用范围:整个方法
     * 作用对象:调用这个方法的对象
     */
    public synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            System.out.println("test 2 by "+ j + "- " + i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            /*
            直接执行的话只是单进程, 那么肯定会先输出0-9, 然后再输出0-9
            但是这里使用了线程池, 并且执行了两次
            那么就很好的体现出synchronized的作用
             */
            //example1.test1();
            //example1.test2();

            /*
            因为synchronized修饰代码块和方法的作用对象只是当前调用的对象, 所以
            example1.test(1)
            example2.test(2)
            和
            example1.test2(1)
            example2.test2(2)
            并不会同步, 因为他们不是同一个对象
            可以看到效果是交替输出
            所
             */
            //example1.test1(1);
            example1.test2(1);
        });
        executorService.execute(() -> {
            //example1.test1();
            //example1.test2();

            //example2.test1(2);
            example2.test2(2);
        });
    }
}
