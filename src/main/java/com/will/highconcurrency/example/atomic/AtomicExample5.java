package com.will.highconcurrency.example.atomic;

import com.will.highconcurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Will.Zhang on 2018/3/19 0019 16:40.
 * 此方法是线程安全的
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    /*
    更新指定的类中的某一个值
    初始化
    参数1, 需要处理的类
    参数2, 需要处理该类中的值(必须是volatile, static)
     */
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    public volatile int count = 100;

    private static AtomicExample5 example5 = new AtomicExample5();

    public static void main(String[] args) {
        //当count==100的时候, 更新成120
        if(updater.compareAndSet(example5, 100, 120)){
            System.out.println("update success 1, count=" + example5.getCount());
        }
        //当count==100的时候, 更新成120, 不过目前已经是120, if中的条件不会成立
        if(updater.compareAndSet(example5, 100, 120)){
            System.out.println("update success 2, count=" + example5.getCount());
        }else{
            System.out.println("update failed, count=" + example5.getCount());
        }
    }

    public int getCount() {
        return count;
    }
}
