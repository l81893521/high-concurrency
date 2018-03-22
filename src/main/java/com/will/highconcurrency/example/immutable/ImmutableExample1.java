package com.will.highconcurrency.example.immutable;

import com.google.common.collect.Maps;
import com.will.highconcurrency.annoations.NotThreadSafe;

import java.util.Map;

/**
 * Created by Will.Zhang on 2018/3/21 0021 17:54.
 * final的基本说明
 *
 * 如果使用final定义一个类
 * 那么它里面所有的方法都会被隐式指定为final方法
 */
@NotThreadSafe
public class ImmutableExample1 {
    //不允许改变值
    private final static Integer a = 1;
    //不允许改变值
    private final static String b = "2";
    //可以改变值, 不允许改变引用
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        //是没办法对a和b的值进行修改的
        //a = 2;
        //b = "3";

        //是没办法对map的引用进行修改的
        //map = Maps.newHashMap();

        //但是可以对map的值进行修改
        map.put(1, 3);
        System.out.println(map.get(1));
    }

    /**
     * 如果使用final修饰传入的参数
     * @param a
     */
    private void test(final int a){
        //那么参数的值也是不能修改的
        //如果参数是引用传递, 那么使用final修饰, 也是不能修改该参数的引用的
        //a = 1;
    }

    /**
     * 私有方法会被隐式定义成final
     */
    private void test2(){

    }

    /**
     * 这个类将不能被继承者修改
     */
    public final void test3(){}
}
