import java.util.*;

public class MinMaxSlice {

    public MinMaxSlice() {}

    public static void main(String[] args) {
        minmaxslice(new int[]{3,5,7,6,3});
        minmaxslice(new int[]{1,2,1,2,1});
    }

    public static void minmaxslice(int[] data) {
        MinMaxDeque<Integer> mmq = new MinMaxDeque<Integer>();
        int l = 0;
        int h = 0;
        while (l <= h && h <= data.length) {
            if (h < data.length && mmq.isEmpty()) {
                mmq.add(data[h]);
                h++;
            } else if (h < data.length && Math.abs(data[h] - mmq.min()) <= 2 && Math.abs(data[h] - mmq.max()) <= 2) {
                    mmq.add(data[h]);
                    h++;
            } else {
                for (int i = l; i < h; i++) {
                    System.out.println("(" + l + "," + i + ")");
                }
                mmq.poll();
                l++;
            }
        }
    }
}


class MinMaxDeque<E extends Comparable<E>> extends ArrayDeque<E> {
    Deque<E> minDeque = new ArrayDeque<E>();
    Deque<E> maxDeque = new ArrayDeque<E>();

    //MinMaxDeque() {}

    public E poll() {
        E re = super.poll();
        if (re != null && re.compareTo(min()) == 0) {
            minDeque.poll();
        }
        if (re != null && re.compareTo(max()) == 0) {
            maxDeque.poll();
        }
        return re;
    }

    public boolean add(E e) {
        boolean re = super.add(e);
        while (!minDeque.isEmpty() && e.compareTo(minDeque.peekLast()) < 0) {
            minDeque.pollLast();
        }
        minDeque.add(e);
        while (!maxDeque.isEmpty() && e.compareTo(maxDeque.peek()) > 0) {
            maxDeque.poll();
        }
        maxDeque.add(e);
        return re;
    }

    public E min() {
        if (minDeque.isEmpty()) throw new IllegalStateException("Deque is empty");
        return minDeque.peek();
    }

    public E max() {
        if (maxDeque.isEmpty()) throw new IllegalStateException("Deque is empty");
        return maxDeque.peek();
    }
}
