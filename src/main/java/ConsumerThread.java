import java.util.List;

public class ConsumerThread implements Runnable {

    private List<Integer> list;

    public ConsumerThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.get(0) != 0) {
                    Integer value = list.get(0);
                    System.out.println("Consumer took value: " + value + " from list");
                    list.add(0, 0);
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}