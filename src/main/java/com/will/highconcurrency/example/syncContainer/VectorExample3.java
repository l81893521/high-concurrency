package com.will.highconcurrency.example.syncContainer;

import com.will.highconcurrency.annoations.NotThreadSafe;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Will.Zhang on 2018/3/22 0022 18:22.
 */
public class VectorExample3 {

    /**
     * 在遍历集合的过程中
     * 尽量不要更新集合中的值
     * 如果需要在遍历过程中对值进行修改
     * 建议在遍历的时候记录下需要修改的内容
     * 遍历完毕后再作修改
     *
     * 特别在多线程环境下更加容易出现错误
     * 如A线程在对数据遍历, B线程在删除数据
     * @param v1
     */
    private static void test1(Vector<Integer> v1){
        //java.util.ConcurrentModificationException
        for (Integer i : v1) {
            if(i.equals(3)){
                v1.remove(i);
            }
        }
    }

    private static void test2(Vector<Integer> v1){
        //java.util.ConcurrentModificationException
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            if (i.equals(3)){
                v1.remove(i);
            }
        }
    }

    /**
     * 推荐使用for循环来做包含增删的遍历
     * @param v1
     */
    private static void test3(Vector<Integer> v1){
        for (int i = 0; i < v1.size(); i++) {
            if(v1.get(i).equals(3)){
                v1.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);

        test1(vector);
    }

}
