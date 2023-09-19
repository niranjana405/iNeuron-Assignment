import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

class Producer extends Thread {
    private final Queue<Integer> queue;
    private final int maxSize;

    public Producer(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    public void run() {
        Random random = new Random();

        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("Queue is full, waiting for consumer...");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int num = random.nextInt(10) + 1;
                queue.add(num);
                System.out.println("Produced: " + num);

                queue.notifyAll();
            }
        }
    }
}

class Consumer extends Thread {
    private final Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("Queue is empty, waiting for producer...");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int num = queue.poll();
                System.out.println("Consumed: " + num);

                queue.notifyAll();
            }
        }
    }
}

public class Question9 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 5;

        Producer producer = new Producer(queue, maxSize);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();
    }
}
