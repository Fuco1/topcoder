import java.util.*;

public class Producer extends Thread {

    public static void main(String[] args) {
        IntBuffer buf = new IntBuffer();
        Producer p = new Producer(buf);
        Consumer c = new Consumer(buf);
        p.start();
        c.start();
    }

    private IntBuffer buf;

    public Producer(IntBuffer buf) {
        this.buf = buf;
    }

    public void run() {
        Random r = new Random();
        while (true) {
            int num = r.nextInt();
            buf.add(num);
            // try {
            //     sleep(1000);
            // } catch (InterruptedException e) {
            // }
        }
    }


}

class Consumer extends Thread {

    private IntBuffer buf;

    public Consumer(IntBuffer buf) {
        this.buf = buf;
    }

    public void run() {
        while (true) {
            buf.remove();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

}


class IntBuffer {

    private int[] data = new int[8];
    private int index = 0;

    public synchronized void add(int num) {
        while (index == data.length - 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        data[index++] = num;
        System.out.println("Produced " + num);
        notifyAll();
    }

    public synchronized int remove() {
        while (index == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        int re = data[--index];
        System.out.println("Consumed " + re);
        notifyAll();
        return re;
    }
}
