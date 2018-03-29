package com.will.highconcurrency.example.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Will.Zhang on 2018/3/29 0029 18:28.
 */
public class LockExample6 {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        new Thread(() -> {
           try {
               reentrantLock.lock();;
               System.out.println("wait signal"); //1
               condition.await();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
            System.out.println("get signal"); // 4
            reentrantLock.unlock();
        }).start();

        new Thread(() -> {
            reentrantLock.lock();
            System.out.println("get lock"); // 2
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();
            System.out.println("send signal"); // 3
            reentrantLock.unlock();
        }).start();
    }
}
