package me;

import java.util.*;

public class BinomialHeap<T extends Comparable> {

    private List<BinomialTree<T>> trees = new ArrayList<BinomialTree<T>>();

    public BinomialHeap() {}

    public BinomialHeap(T item) {
        trees.add(new BinomialTree(item));
    }

    public BinomialHeap(List<BinomialTree<T>> trees) {
        this.trees = new ArrayList<BinomialTree<T>>(trees);
    }

    public void merge(BinomialHeap<T> other) {
        List<BinomialTree<T>> ntrees = new ArrayList<BinomialTree<T>>();
        BinomialTree<T> carry = null;
        Iterator<BinomialTree<T>> ti = this.trees.iterator();
        Iterator<BinomialTree<T>> oi = other.trees.iterator();

        while (ti.hasNext() || oi.hasNext()) {
            BinomialTree<T> t = ti.hasNext() ? ti.next() : null;
            BinomialTree<T> o = oi.hasNext() ? oi.next() : null;

            if (t == null && o == null) {
                ntrees.add(BinomialTree.merge(null, carry));
                carry = null;
            } else if (t == null && o != null) {
                if (carry != null) {
                    ntrees.add(null);
                    carry = BinomialTree.merge(o, carry);
                } else {
                    ntrees.add(BinomialTree.merge(o, carry));
                    carry = null;
                }
            } else if (t != null && o == null) {
                if (carry != null) {
                    ntrees.add(null);
                    carry = BinomialTree.merge(t, carry);
                } else {
                    ntrees.add(BinomialTree.merge(t, carry));
                    carry = null;
                }
            } else {
                ntrees.add(carry);
                carry = BinomialTree.merge(t, o);
            }
        }

        if (carry != null) {
            ntrees.add(carry);
        }

        this.trees = ntrees;
    }

    public void insert(T item) {
        if (item == null) throw new NullPointerException("item is null");
        merge(new BinomialHeap<T>(item));
    }

    private BinomialTree<T> getMinTree() {
        if (trees.size() == 0) return null;

        BinomialTree<T> min = null;
        for (BinomialTree<T> t : trees) {
            if ((min == null && t != null) ||
                (t != null && min.compareTo(t) > 0)) {
                min = t;
            }
        }
        return min;
    }

    public T getMin() {
        BinomialTree<T> minTree = getMinTree();
        return minTree != null ? minTree.item : null;
    }


    public T deleteMin() {
        BinomialTree<T> minTree = getMinTree();
        if (minTree == null) {
            return null;
        } else {
            BinomialHeap<T> newHeap = new BinomialHeap<T>(minTree.children);
            for (int i = 0; i < trees.size(); i++) {
                if (trees.get(i) == minTree) {
                    trees.set(i, null);
                    break;
                }
            }
            merge(newHeap);
            return minTree.item;
        }
    }

    public int rank() {
        return trees.size();
    }

    public int size() {
        int re = 0;
        for (int i = trees.size() - 1; i >= 0; i--) {
            if (trees.get(i) == null) {
                re = re << 1;
            } else {
                re = re << 1;
                re |= 1;
            }
        }
        return re;
    }

    public String toString() {
        return trees.toString();
    }
}

class BinomialTree<T extends Comparable> implements Comparable<BinomialTree<T>> {

    T item;
    List<BinomialTree<T>> children;

    BinomialTree() {
         children = new ArrayList<BinomialTree<T>>();
    }

    BinomialTree(T item) {
        this.item = item;
        children = new ArrayList<BinomialTree<T>>();
    }

    BinomialTree(T item, List<BinomialTree<T>> children) {
        this.item = item;
        this.children = new ArrayList<BinomialTree<T>>(children);
    }

    BinomialTree(BinomialTree<T> old) {
        this.item = old.item;
        this.children = new ArrayList<BinomialTree<T>>(old.children);
    }

    static <T extends Comparable> BinomialTree<T> merge(BinomialTree<T> left, BinomialTree<T> right) {
        if (left != null && right != null && left.rank() != right.rank()) {
            throw new UnsupportedOperationException("Only trees of same rank can be merged");
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        // to keep everything clean we should make copies of left/right
        if (left.item.compareTo(right.item) < 0) {
            BinomialTree<T> re = new BinomialTree<T>(left);
            re.children.add(new BinomialTree<T>(right));
            return re;
        } else {
            BinomialTree<T> re = new BinomialTree<T>(right);
            re.children.add(new BinomialTree<T>(left));
            return re;
        }
    }

    int rank() {
        return children.size();
    }

    public int compareTo(BinomialTree<T> other) {
        return this.item.compareTo(other.item);
    }

    public String toString() {
        return item + ":" + children.toString();
    }
}
