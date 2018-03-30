/**
 * Created by Will.Zhang on 2018/3/30 0030 17:01.
 *
 * ThreadPoolExample1 : cachedThreadPool
 *
 * ThreadPoolExample2 : fixedThreadPool
 *
 * ThreadPoolExample3 : singleThreadExecutor
 *
 * ThreadPoolExample4 : scheduledThreadPool
 *
 * new Thread 弊端
 * 1. 每次new Thread 新建对象, 性能差
 * 2. 线程缺乏统一管理, 可能无限制的新建线程, 相互竞争, 有可能占用过多的系统资源导致死机或者OOM
 * 3. 缺少更多功能(更多执行, 定期执行, 线程中断等)
 *
 * 线程池的好处
 * 1. 重用存在的线程, 减少对象创建, 消亡的开销, 性能佳
 * 2. 可有效控制最大并发线程数, 提高系统资源利用率, 同时可以避免过多的资源竞争, 避免阻塞
 * 3. 提供定时执行, 定期执行, 单线程, 并发数控制等功能
 *
 * 线程池中的状态
 * 1. Running : 能接收新提交的任务, 也能处理阻塞队列中的任务
 * 2. ShutDown : 不能接收新的任务, 但是可以处理阻塞队列中已经保存的任务
 * 3. Stop : 不能接收新的任务, 也不会处理阻塞对列中的任务
 * 4. Tidying : 如果所有的任务都已经中止了, 有效线程数为0, 会进入到改状态
 * 5. Terminated : Tidying会自动进入该状态
 *
 * 线程池核心方法
 * 1. execute() : 提交任务, 交给线程池执行
 * 2. submit() : 提交任务, 能够返回执行结果(execute + future)
 * 3. shutdown() : 关闭线程池, 等待任务都执行完
 * 4. shutdownNow() : 关闭线程池, 不等待任务执行完
 * 5. getTaskCount() : 线程池已执行和未执行的任务总数
 * 6. getCompletedTaskCount() : 已完成的任务总数
 * 7. getPoolSize() : 线程池当前的线程数量
 * 8. getActiveCount() : 当前线程池中正在执行任务的线程数量
 *
 * Executors.newCachedThreadPol : 创建可缓存线程池, 如果线程池长度超过了处理的需要, 可以灵活回收空闲线程, 或新建线程
 * Executors.newFixedThreadPool : 创建定长的线程池, 可以控制并发数, 超过的线程会在队列中等待
 * Executors.newScheduledThreadPool : 创建定长的线程池, 支持周期或定时的线程执行
 * Executors.newSingleThreadExecutor : 创建单线程化的线程池, 只会用唯一的线程执行任务
 */
package com.will.highconcurrency.example.threadPool;