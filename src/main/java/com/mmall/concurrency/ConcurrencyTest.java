package com.mmall.concurrency;



import com.mmall.concurrency.example.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author IIIIII
 * @create 2019-01-02-23:57
 * @package com.mmall.concurrency
 **/
@Slf4j
@NotThreadSafe
public class ConcurrencyTest {
    public static int clientTotal=5000;
    public static int threadTotal=200;
    public static int count=0;

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
        count++;
    }
}
