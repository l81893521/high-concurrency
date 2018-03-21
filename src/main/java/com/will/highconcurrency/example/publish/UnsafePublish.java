package com.will.highconcurrency.example.publish;

import com.will.highconcurrency.annoations.NotThreadSafe;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2018/3/20 0020 17:51.
 */
@NotThreadSafe
public class UnsafePublish {

    //定义个字符串数组表示状态
    private String[] states = {"a", "b", "c"};

    //一个get方法, 返回私有属性states的引用
    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        System.out.println(Arrays.toString(unsafePublish.getStates()));
        //可以通过get方法获取私有属性的引用, 从而对里面的值进行任意修改
        //这样的写法是线程不安全的
        unsafePublish.getStates()[0] = "d";
        System.out.println(Arrays.toString(unsafePublish.getStates()));
    }
}
