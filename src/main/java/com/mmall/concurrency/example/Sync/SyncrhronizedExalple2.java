package com.mmall.concurrency.example.sync;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author IIIIII
 * @create 2019-01-06-21:21
 * @package com.mmall.concurrency.example.sync
 **/
//!!!!!若synchronized修饰方法，继承该类的子类的该方法不继承cyncyronized！
@Slf4j
public  class SyncrhronizedExalple2 {
    //修饰一个类
    public  static  void test1(int n){
        synchronized (SyncrhronizedExalple2.class){
            for(int i=0;i<10;i++){
                log.info("test1-{}-{}",n,i);
            }
        }
    }

    //修饰静态方法
    public static synchronized void test2(int n){
        for(int i=0;i<10;i++){
            log.info("test2-{}-{}",n,i);
        }
    }

    public static void main(String[] args) {
        SyncrhronizedExalple2 example1=new SyncrhronizedExalple2();
        SyncrhronizedExalple2 example2=new SyncrhronizedExalple2();
        ExecutorService service= Executors.newCachedThreadPool();
        service.execute(()->{
            example1.test1(1);
        });
        service.execute(()->{
            example2.test1(2);
        });
    }

}
