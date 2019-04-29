package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.example.annoations.NotThreadSafe;

/**
 * @author IIIIII
 * @create 2019-01-07-22:34
 * @package com.mmall.concurrency.example.singleton
 **/
/*单例模式
* 懒汉模式
* 实例在第一次使用时创建
* 多线程时可能被创建出多个实例
*
* */
@NotThreadSafe
public class SingletonSimple1 {
    private SingletonSimple1(){

    }

    private static SingletonSimple1 instance=null;

    public static SingletonSimple1 getInstance(){
         if(instance==null){
             instance=new SingletonSimple1();
         }
         return instance;
    }
}
