package demo.producerAndCustomer;

/**
 * @author IIIIII
 * @create 2019-04-29-16:56
 * @package demo.producerAndCustomer
 **/
public class producer extends Thread {
    MyBlockingQueue<String> queue;
    public  producer( MyBlockingQueue<String> queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (true) {
                String task = String.valueOf(num);
                queue.put(task);
                System.out.println("producer task "+task);
                num++;
                Thread.sleep((int)Math.random()*100);
            }
        }catch (InterruptedException e){

        }
    }

}
