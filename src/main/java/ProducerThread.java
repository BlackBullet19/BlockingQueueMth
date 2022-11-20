import java.util.List;

public class ProducerThread implements Runnable {

    private List<Integer> list;
    private int value;

    public ProducerThread(List<Integer> list, int value) {
        this.list=list;
        this.value = value;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.get(0) == 0) {
                    list.add(0, value);
                    System.out.println("Producer added value: " + value + " to list");
                    list.notify();
                }
            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
