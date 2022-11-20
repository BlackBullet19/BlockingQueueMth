import java.util.ArrayList;
import java.util.List;

public class MainProducerConsumerApp {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>(1);
        list.add(0,0);

        ProducerThread producerThread = new ProducerThread(list, 1);
        Thread threadProducer = new Thread(producerThread);
        threadProducer.setDaemon(true);
        threadProducer.start();

        ConsumerThread consumerThread = new ConsumerThread(list);
        Thread threadConsumer = new Thread(consumerThread);
        threadConsumer.setDaemon(true);
        threadConsumer.start();

        Thread.sleep(100);

        ProducerThread producerThreadTwo = new ProducerThread(list, 2);
        Thread threadProducerTwo = new Thread(producerThreadTwo);
        threadProducerTwo.setDaemon(true);
        threadProducerTwo.start();

        Thread.sleep(3000);
    }
}
