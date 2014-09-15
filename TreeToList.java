import java.util.*;
import java.io.*;

public class TreeToList {

    public TreeToList() {}

    public static void main(String[] args) {
        Node root = new Node(11, new Node(9, new Node(5, new Node(4), new Node(7, new Node(6), new Node(8))), new Node(10)), new Node(12));
        //Node root = new Node(2, new Node(1), new Node(3));
        System.out.println(root);
        System.out.println(transform(root));
    }

    public static Node transform(Node n) {
        if (n == null) return null;
        Node l = transform(n.left);
        Node r = transform(n.right);
        n.left = null;
        n.right = r;
        if (l != null) {
            Node tmp = l;
            while (tmp.right != null) tmp = tmp.right;
            tmp.right = n;
            return l;
        }
        return n;
    }
}

class Node {
    int value;
    Node left;
    Node right;
    Node parent;

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

    public String toString() {
        return "(" + value + " " +
            (left != null ? left.toString() : "E") + " " +
            (right != null ? right.toString() : "E") + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != this.getClass()) {
             return false;
        }
        return value == ((Node)other).value;
    }
}
