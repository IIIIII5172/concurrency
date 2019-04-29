package com.mmall.concurrency.example.atomic;


import com.mmall.concurrency.example.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author IIIIII
 * @create 2019-01-02-23:57
 * @package com.mmall.concurrency
 **/
@Slf4j
@ThreadSafe
public class AtomicExample3 {
    public static int clientTotal=5000;
    public static int threadTotal=200;
    //AtomicInteger换成AtomicLong
    public static AtomicLong count=new AtomicLong(0);

    public static void main(String[] args)throws  Exception {
        ExecutorService executorService= Executors.newCachedThreadPool();
        final Semaphore semaphore=new Semaphore(threadTotal);
        final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
        for(int i=0;i<clientTotal;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e){
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",count);
    }
    private static void add(){
        //先加还是先取值
        /*这里的源码调用unsafe类的getAndAddInt方法
        * */
        count.incrementAndGet();
//        count.getAndAccumulate();
    }
}
