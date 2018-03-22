package com.will.highconcurrency.example.immutable;

import com.google.common.collect.Maps;
import com.will.highconcurrency.annoations.NotThreadSafe;
import com.will.highconcurrency.annoations.ThreadSafe;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Will.Zhang on 2018/3/21 0021 17:54.
 */
@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        /*
        当使用Collections.unmodifiableMap之后, 就不能改变map里面的值了
        可以进去看看unmodifiableMap的实现
        当初始化完毕后
        大部分方法只要被调用, 就直接抛出异常, 不进行任何的逻辑处理

        还有unmodifiableSet, unmodifiableList等等
         */
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        //当使用Collections.unmodifiableMap之后, 尝试修改map的值就会报错
        map.put(1, 3);
        System.out.println(map.get(1));
    }
}
