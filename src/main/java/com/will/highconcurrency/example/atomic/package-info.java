/**
 * Created by Will.Zhang on 2018/3/19 0019 17:51.
 * 主要对Atomic包进行演示
 * 入AtomicInteger, AtomicLong, LongAdder, AtomicXXX等
 *
 * 原子性
 * AtomicXXX它们都是通过CAS来完成原子性的
 * CAS是compareAndSwapXXX的缩写(Unsafe类里面的compareAndSwapInt, compareAndSwapLong等方法, 这都是核心的方法)
 * XXXAdder和AtomicXXX有所不同, 如LongAdder和AtomicLong
 * LongAdder在AutomicLong的基础上, 将单点的压力分分散到各个节点, 在低并发的时候通过对base的直接更新可以很好的保障和AtomicLong的性能基本保持一直
 * 而在高并发的时候通过分散提高了性能
 * 缺点是LongAddr在统计的时候如果有并发更新, 可能导致统计的数据有误差
 */
package com.will.highconcurrency.example.atomic;