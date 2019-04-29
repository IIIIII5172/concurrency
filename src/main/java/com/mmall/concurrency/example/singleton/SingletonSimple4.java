package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.example.annoations.NotThreadSafe;
import com.mmall.concurrency.example.annoations.ThreadSafe;

/**
 * @author IIIIII
 * @create 2019-01-07-22:34
 * @package com.mmall.concurrency.example.singleton
 **/
/*
*synchrosized直接放方法上会造成性能低
* 双重同步锁单例模式
* */
@ThreadSafe
public class SingletonSimple4 {
    private SingletonSimple4(){

    }

    private static volatile SingletonSimple4 instance=null;
    //实际并不是线程安全
    //因为创建对象分3步
    //1.分配对象内存空间
    //2.初始化对象
    //3.将初始化的对象实例指向刚刚分配的内存
    //JVM和CPU优化时，发生了指令重排，顺序变为132时
    //线程1走到3，线程2也走到3，此时最后会返回空
    //解决方法volatile
    public static SingletonSimple4 getInstance(){
         if(instance==null){//双重监测机制？？？
             synchronized (SingletonSimple4.class){
                 if(instance==null){
                     instance=new SingletonSimple4();
                 }

             }

         }
         return instance;
    }
}
