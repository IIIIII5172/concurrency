package demo.producerAndCustomer;

/**
 * @author IIIIII
 * @create 2019-04-29-17:09
 * @package demo.producerAndCustomer
 **/
public class customer extends  Thread {
    MyBlockingQueue<String> queue;
    public customer(MyBlockingQueue<String> queue){
        this.queue=queue;
    }
    @Override
    public void run(){
        try {
            while (true){
                String task=queue.take();
                System.out.print("customer take "+task);
                Thread.sleep((int)Math.random()*100);
            }
        }catch (InterruptedException e){
        }
    }
    //执行
    public static void main(String[] args) {
        MyBlockingQueue<String> queue=new MyBlockingQueue<>(1);//队列最大容量
        new producer(queue).start();
        new customer(queue).start();
    }
}
