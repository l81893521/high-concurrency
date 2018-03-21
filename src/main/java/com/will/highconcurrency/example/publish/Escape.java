package com.will.highconcurrency.example.publish;

import com.will.highconcurrency.annoations.NotRecommand;
import com.will.highconcurrency.annoations.NotThreadSafe;

/**
 * Created by Will.Zhang on 2018/3/20 0020 17:56.
 * 非线程
 * 不推荐写法
 */
@NotThreadSafe
@NotRecommand
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape(){
        //实例化inner class
        new InnerClass();
        //初始化还没完成 如果后面还有代码需要执行
    }

    private class InnerClass {
        public InnerClass() {
            //当初始化还没完成, 这里已经把this发布出去了
            //会造成未知的后果
            System.out.println(Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
