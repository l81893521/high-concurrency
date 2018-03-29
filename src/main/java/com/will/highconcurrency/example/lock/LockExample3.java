package com.will.highconcurrency.example.lock;

import com.will.highconcurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Will.Zhang on 2018/3/19 0019 16:40.
 */
@Slf4j
public class LockExample3 {

    private final Map<String, Data> map = new TreeMap<>();

    /*
    ReentrantReadWriteLock是一个读写锁
    作用是在写的时候, 不允许任何的读操作
    只有当所有的读操作都被释放掉之后, 才会进行写操作
    注意: 如果在读多写少的情况, 可能会导致写锁获取不到资源的情况出现
     */
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    /*
    分别从ReentrantReadWriteLock的实例中获取读锁和写锁
     */
    private final Lock readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();

    /**
     * 获取数据
     * @param key
     * @return
     */
    public Data get(String key){
        //在读的请求中加上读锁
        readLock.lock();
        try {
            return map.get(key);
        } finally{
            readLock.unlock();
        }
    }

    /**
     * 获取所有key
     * @return
     */
    public Set<String> getAllKeys(){
        //在读的请求中加上读锁
        readLock.lock();
        try {
            return map.keySet();
        } finally{
            readLock.unlock();
        }
    }

    /**
     * 获取数据
     * @param key
     * @param value
     * @return
     */
    public Data put(String key, Data value){
        //在写的请求上加上写锁
        writeLock.lock();
        try {
            return map.put(key, value);
        } finally{
            writeLock.unlock();
        }
    }

    class Data {

    }


}
