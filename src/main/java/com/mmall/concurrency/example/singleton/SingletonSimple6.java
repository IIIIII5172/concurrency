package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.example.annoations.NotThreadSafe;
import com.mmall.concurrency.example.annoations.Recommend;
import com.mmall.concurrency.example.annoations.ThreadSafe;

/**
 * @author IIIIII
 * @create 2019-01-07-22:34
 * @package com.mmall.concurrency.example.singleton
 **/
//推荐使用枚举模式，最安全
@ThreadSafe
@Recommend
public class SingletonSimple6 {
    private SingletonSimple6(){
    }

    public static SingletonSimple6 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonSimple6 singletonSimple6;
        //JVM保证这个枚举的构造只被调用一次
        Singleton(){
            singletonSimple6=new SingletonSimple6();
        }
        public  SingletonSimple6 getInstance(){
            return singletonSimple6;
        }
    }
}
