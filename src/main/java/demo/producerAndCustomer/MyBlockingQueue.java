package demo.producerAndCustomer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author IIIIII
 * @create 2019-04-29-16:44
 * @package demo.producerAndCustomer
 **/
public class MyBlockingQueue<E> {
    private  Queue<E> queue=null;
    private int limit;

    public MyBlockingQueue(int limit){
        this.limit=limit;
        queue=new ArrayDeque<>(limit);
    }
    //生产者向队列新增元素
    public synchronized void put(E e)throws InterruptedException{
        while(queue.size()==limit){
            wait();
        }
        queue.add(e);
        notifyAll();
    }

    public synchronized E take()throws InterruptedException {
        while(queue.isEmpty()){
            wait();
        }

        E e=queue.poll();
        notifyAll();
        return e;
    }

}
