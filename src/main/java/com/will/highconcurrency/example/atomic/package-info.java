/**
 * Created by Will.Zhang on 2018/3/19 0019 17:51.
 * 主要对Atomic包进行演示
 * 入AtomicInteger, AtomicLong, LongAdder, AtomicXXX等
 *
 * AtomicBoolean:对boolean类型数据进行操作
 * AtomicInteger:对int类型数据进行操作
 * AtomicIntegerArray:对int类型数组数组进行操作
 * AtomicIntegerFieldUpdater:对指定类中的一个int属性进行更新操作
 * AtomicLong:对long类型数据进行操作
 * AtomicLongArray:对long类型数组数组进行操作
 * AtomicLongFieldUpdater:对指定类中的一个long属性进行更新操作
 * AtomicReference:对泛型类型数据进行操作
 * AtomicReferenceArray:对泛型类型数组数组进行操作
 * AtomicReferenceFieldUpdater:对指定类中的一个泛型属性中进行更新操作
 * DoubleAdder:对double类型进行操作
 * LongAdder:对long类型进行操作
 * AtomicStampedReference:解决cas引发的aba问题(把值从a改成b, 又改回a)
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