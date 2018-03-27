package com.will.highconcurrency.example.syncContainer;

import com.will.highconcurrency.annoations.NotThreadSafe;

import java.util.Vector;

/**
 * Created by Will.Zhang on 2018/3/22 0022 18:22.
 */
@NotThreadSafe
public class VectorExample2 {

    /*
    虽然vector是线程同步的, 而且它里面的方法也是经过synchronized修饰
    但是并不代表它一定是安全的
     */
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        //使用无限循环让效果更明显一点
        while (true) {
            //不断往vector中添加值
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            //线程1
            Thread thread1 = new Thread() {
                public void run() {
                    //不断往vector中移除值
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };

            //线程2
            Thread thread2 = new Thread() {
                public void run() {
                    //不断往vector中获取值
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            };
            //分别启动两个线程
            thread1.start();
            thread2.start();

            /*
            如果运行, 可以看到不断有异常抛出来
            可以看到大部分异常都是在get(i)出来的, 那么get会出现异常肯定是remove引起的
            虽然synchronized能够保证同时只有一个线程能够访问remove或者get
            但是当线程同时分别进入到remove(i)和get(i)中, 问题就来了
            如果当i=9的时候
            remove(i)先执行了
            那么再执行
            get(i)这个时候下标为9的元素已经不存在了, 从而引发数组越界的情况出先
             */
        }
    }

}
