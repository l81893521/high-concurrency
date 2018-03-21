/**
 * Created by Will.Zhang on 2018/3/21 0021 16:54.
 * 安全发布对象和非安全发布对象的写法
 *
 * SingletonExample1 : 单例模式-懒汉, 非线程安全
 *
 * SingletonExample2 : 单例模式-饿汉, 线程安全并且描述缺点
 *
 * SingletonExample3 : 单例模式-懒汉, 线程安全, 但是不推荐写法
 *
 * SingletonExample4 : 单例模式-懒汉, 由于指令重排导致的非线程安全
 *
 * SingletonExample5 : 单例模式-懒汉, 线程安全, 解决由于指令重排导致的问题
 *
 * SingletonExample6 : 单例模式-饿汉, 线程安全, 使用静态块需要主要的问题
 *
 * SingletonExample7 : 单例模式-懒汉, 线程安全, 使用枚举来实现, 推荐写法
 */
package com.will.highconcurrency.example.singleton;