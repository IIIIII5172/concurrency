package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.example.annoations.NotThreadSafe;

/**
 * @author IIIIII
 * @create 2019-01-07-22:34
 * @package com.mmall.concurrency.example.singleton
 **/
/*单例模式
* 饿汉模式
*
*
* */
@NotThreadSafe
public class SingletonSimple5 {
    private SingletonSimple5(){

    }

    private static SingletonSimple5 instance=null;
    static {
        instance=new SingletonSimple5();
    }
    public static SingletonSimple5 getInstance(){

         return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
