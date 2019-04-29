package com.mmall.concurrency.example.atomic;


import com.mmall.concurrency.example.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;


@Slf4j
@ThreadSafe
public class AtomicExample6 {
    private static AtomicIntegerFieldUpdater<AtomicExample6> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample6.class,"count");
    @Getter
    public volatile  int count=100;
    private static AtomicExample6 example5=new AtomicExample6();
    public static void main(String[] args){
        if(updater.compareAndSet(example5,100,120)){
            log.info("update success,{}",example5.getCount());
        }

        if(updater.compareAndSet(example5,100,120)){
            log.info("update success,{}",example5.getCount());
        }else{
            log.info("update failed,{}",example5.getCount());
        }
    }
        }
