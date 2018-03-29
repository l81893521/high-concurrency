/**
 * Created by Will.Zhang on 2018/3/29 0029 17:39.
 *
 * ReentrantLock和Synchronized的区别
 * 1. 可重入性(两者关于这个的区别不大)
 * 2. 锁的实现
 *      Synchronized是依赖于jvm实现的
 *      ReentrantLock是jdk实现的
 * 3. 性能的区别(Synchronized优化后, 两者性能差别不大)
 * 4. 功能区别
 *      Synchronized: 便利, 适合初级程序员使用
 *      ReentrantLock: 要手工需释放锁, 但是拥有许多独有功能(指定公平或非公平锁, 分组唤醒线程,中断等待锁的线程)
 */
package com.will.highconcurrency.example.lock;