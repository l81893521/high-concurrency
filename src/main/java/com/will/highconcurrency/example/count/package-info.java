/**
 * Created by Will.Zhang on 2018/3/21 0021 16:47.
 * 计数的例子
 *
 * CountExample 1: 模拟了在多线程的环境计算出现的不准确
 *
 * CountExample 2: 使用了AtomicInteger保证了正确性
 *
 * CountExample 3: 使用了synchronized保证了正确性
 *
 * CountExample 4: 单独使用volatile是无法保证原子性, 需要加上synchronized
 */
package com.will.highconcurrency.example.count;