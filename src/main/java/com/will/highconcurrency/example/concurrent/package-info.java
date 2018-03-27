/**
 * Created by Will.Zhang on 2018/3/27 0027 17:05.
 *
 * 并发容器
 *
 * 非线程安全的集合类推荐对应的并发容器
 *
 * ArrayList -> CopyOnWriteArrayList
 *
 * HashSet -> CopyOnWriteArraySet
 *
 * TreeSet -> ConcurrentSkipListSet
 *
 * TreeMap -> ConcurrentSkipListMap
 *
 * HashMap -> ConcurrentHashMap
 *
 */
package com.will.highconcurrency.example.concurrent;