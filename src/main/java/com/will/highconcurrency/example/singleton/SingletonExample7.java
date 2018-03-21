package com.will.highconcurrency.example.singleton;

import com.will.highconcurrency.annoations.Recommand;
import com.will.highconcurrency.annoations.ThreadSafe;

/**
 * Created by Will.Zhang on 2018/3/21 0021 16:05.
 * 枚举模式:最安全
 * 也是懒汉模式, 在调用时候才会被初始化
 */
@ThreadSafe
@Recommand
public class SingletonExample7 {

    /**
     * 私有构造函数
     */
    private SingletonExample7(){

    }

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getIinstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singleton;

        /**
         * JVM保证这个方法绝对只调用一次
         */
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getIinstance(){
            return singleton;
        }
    }
}
