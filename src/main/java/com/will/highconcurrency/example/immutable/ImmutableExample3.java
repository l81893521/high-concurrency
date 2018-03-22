package com.will.highconcurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.will.highconcurrency.annoations.ThreadSafe;

import java.util.List;

/**
 * Created by Will.Zhang on 2018/3/22 0022 14:46.
 */
@ThreadSafe
public class ImmutableExample3 {
    //两种写法都可以, 使用ImmutableList来创建list
    private final static ImmutableList list = ImmutableList.of(1, 2, 3);
    //private final static List<Integer> list = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4);

    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2).put(3, 4).build();

    public static void main(String[] args) {
        //使用ImmutableList创建list, set和map之后, 值就不再允许被修改
        //调用会抛出异常
        //list.add(4);
        //set.add(4);
        //map.put(1, 4);
        //map2.put(1, 5);
    }
}
