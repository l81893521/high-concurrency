package com.will.highconcurrency.example.atomic;

import com.will.highconcurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by Will.Zhang on 2018/3/19 0019 16:40.
 * 此方法是线程安全的
 */
@Slf4j
@ThreadSafe
public class AtomicExample4 {

    /**
     * 也是采用了cas实现方式
     * 核心方法compareAndSwapObject
     */
    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        //如果是0, 更新成2
        count.compareAndSet(0, 2);
        //如果是0, 更新成1, 目前值是2, 不执行
        count.compareAndSet(0, 1);
        //如果是0, 更新成2, 目前值是2, 不执行
        count.compareAndSet(1, 3);
        //如果是2, 更新成4
        count.compareAndSet(2, 4);
        //如果是3, 更新成5, 目前值是4, 不执行
        count.compareAndSet(3, 5);
        //最后结果为4
        System.out.println("count:" + count.get());
    }
}
