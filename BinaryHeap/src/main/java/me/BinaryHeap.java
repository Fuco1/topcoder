package me;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class BinaryHeap<T extends Comparable> {

    private Object[] data;
    private int last = 0;

    public BinaryHeap() {
        data = new Object[2];
    }

    public int size() {
        return last;
    }

    public void insert(T item) {
        if (item == null) throw new NullPointerException("item is null");

        if (last == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[last] = item;

        // sift up
        int current = last;
        int parent = (last - 1) / 2;
        while (current != 0) {
            if (((T)data[parent]).compareTo((T)data[current]) > 0) {
                Object tmp = data[parent];
                data[parent] = data[current];
                data[current] = tmp;
            } else {
                break;
            }
            current = parent;
            parent = (current - 1) / 2;
        }
        last++;
    }

    public T getMin() {
        return (T)data[0];
    }

    public T deleteMin() {
        T re = (T)data[0];

        data[0] = data[last-1];
        last--;
        //sift down
        int current = 0;
        int lchild = 2 *  current + 1;
        int rchild = 2 * (current + 1);
        while ((lchild < last &&
                ((T)data[current]).compareTo((T)data[lchild]) > 0) ||
               (rchild < last &&
                ((T)data[current]).compareTo((T)data[rchild]) > 0)) {
            if (data[rchild] == null ||
                ((T)data[lchild]).compareTo((T)data[rchild]) < 0) {
                Object tmp = data[lchild];
                data[lchild] = data[current];
                data[current] = tmp;
                current = lchild;
            } else {
                Object tmp = data[rchild];
                data[rchild] = data[current];
                data[current] = tmp;
                current = rchild;
            }
            lchild = 2 *  current + 1;
            rchild = 2 * (current + 1);
        }
        return re;
    }
}
