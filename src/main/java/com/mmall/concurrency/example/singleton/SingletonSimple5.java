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
public class SingletonSimple6 {
    private SingletonSimple6(){

    }

    private static SingletonSimple6 instance=null;
    static {
        instance=new SingletonSimple6();
    }
    public static SingletonSimple6 getInstance(){

         return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
