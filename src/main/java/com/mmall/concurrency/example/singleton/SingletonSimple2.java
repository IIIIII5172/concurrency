package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.example.annoations.NotThreadSafe;

/**
 * @author IIIIII
 * @create 2019-01-07-22:34
 * @package com.mmall.concurrency.example.singleton
 **/
/*单例模式
* 饿汉模式
* 实例在类装载时创建
* 私有构造东西太多会慢
*万一实例没被用到的话造成资源浪费
*
* */
@NotThreadSafe
public class SingletonSimple2 {
    private SingletonSimple2(){

    }

    private static SingletonSimple2 instance=new SingletonSimple2();

    public static SingletonSimple2 getInstance(){

         return instance;
    }
}
