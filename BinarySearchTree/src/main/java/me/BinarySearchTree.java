package me;

import java.util.*;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    // create a BST from an array
    public static BinarySearchTree fromArray(final int[] data) {
        return new BinarySearchTree(makeTree(data));
    }

    private static Node makeTree(final int[] data) {
        if (data == null) return null;
        if (data.length == 0) return null;

        int mid = data.length / 2;
        return new Node(data[mid]
                        , makeTree(Arrays.copyOfRange(data, 0, mid))
                        , makeTree(Arrays.copyOfRange(data, mid+1, data.length)));
    }

    public int lca(int x, int y) {
        return root.lca(x, y);
    }

    public String toString() {
        if (root == null) return "Empty";
        else return "" + root;
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int lca(int x, int y) {
        if (x < value && y < value) {
            return left.lca(x,y);
        } else if (x > value && y > value) {
            return right.lca(x,y);
        } else return value;
    }

    public void print() {
        Deque<Node> s = new ArrayDeque<Node>();
        Node tmp = this;
        while (tmp != null) {
            s.push(tmp);
            tmp = tmp.left;
        }
        while (!s.isEmpty()) {
            System.out.print(s.peek().value + " ");
            tmp = s.poll();
            if (tmp.right != null) {
                tmp = tmp.right;
                while (tmp != null) {
                    s.push(tmp);
                    tmp = tmp.left;
                }
            }
        }
    }

    public Node[] findSum(int target) {
        Deque<Node> inc = new ArrayDeque<Node>();
        Deque<Node> dec = new ArrayDeque<Node>();
        Node tmp = this;
        while (tmp != null) { inc.push(tmp); tmp = tmp.left; }
        tmp = this;
        while (tmp != null) { dec.push(tmp); tmp = tmp.right; }

        while (!inc.isEmpty() && !dec.isEmpty()) {
            int sum = inc.peek().value + dec.peek().value;
            if (sum == target) {
                return new Node[]{inc.peek(), dec.peek()};
            } else if (sum < target) {
                tmp = inc.poll();
                if (tmp.right != null) {
                    tmp = tmp.right;
                    while (tmp != null) {
                        inc.push(tmp);
                        tmp = tmp.left;
                    }
                }
            } else {
                tmp = dec.poll();
                if (tmp.left != null) {
                    tmp = tmp.left;
                    while (tmp != null) {
                        dec.push(tmp);
                        tmp = tmp.right;
                    }
                }
            }
        }
        return null;
    }

    public static BSTInfo maxBST(Node n) {
        BSTInfo l = null;
        BSTInfo r = null;
        if (n.left != null) {
            l = maxBST(n.left);
        }
        if (n.right != null) {
            r = maxBST(n.right);
        }
        if ((l == null ? true : l.max <= n.value) &&
            (r == null ? true : n.value < r.min)) {
            BSTInfo re = new BSTInfo(l == null ? n.value : l.min,
                                     r == null ? n.value : r.max,
                                     1 + (l == null ? 0 : l.maxtree) + (r == null ? 0 : r.maxtree));
            return re;
        }
        BSTInfo re = new BSTInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(l == null ? 0 : l.maxtree,
                                                                                r == null ? 0 : r.maxtree));
        return re;
    }

    public static boolean isBST(Node n) {
        if (n == null) return true;
        return isBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(Node n, int l, int r) {
        if (n == null) return true;
        return l <= n.value && n.value < r && isBST(n.left, l, n.value) && isBST(n.right, n.value, r);
    }


    public void printRec(Node n) {
        if (n == null) return;
        printRec(n.left);
        System.out.print(n.value + " ");
        printRec(n.right);
    }

    public String toString() {
        return "(Node " + value + " " +
            (left != null ? left.toString() : "Empty") + " " +
            (right != null ? right.toString() : "Empty") + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != this.getClass()) {
             return false;
        }
        return value == ((Node)other).value;
    }
}

class BSTInfo {
    int min;
    int max;
    int maxtree;

    BSTInfo(int min, int max, int maxtree) {
        this.min = min;
        this.max = max;
        this.maxtree = maxtree;
    }

    public String toString() {
        return min + ":" + max + ":" + maxtree;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != this.getClass()) {
             return false;
        }
        BSTInfo o = (BSTInfo)other;
        return this.min == o.min &&
            this.max == o.max &&
            this.maxtree == o.maxtree;
    }
}
