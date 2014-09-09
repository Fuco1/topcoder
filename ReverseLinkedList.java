import java.util.*;
import java.io.*;

public class ReverseLinkedList {

    public ReverseLinkedList() {}

    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(a);
        Node reverse = reverseR(a, null);
        System.out.println(reverse);
        Node reverse2 = reverse(null);
        System.out.println(reverse2);
    }

    private static Node reverse(Node head) {
        Node re = null;
        while (head != null) {
            Node tmp = head.next;
            head.next = re;
            re = head;
            head = tmp;
        }
        return re;
    }

    private static Node reverseR(Node head, Node newHead) {
        if (head == null) return newHead;
        Node a = head.next;
        head.next = newHead;
        return reverseR(a, head);
    }

    // reverse [] a = a
    // reverse (x:xs) ys = reverse xs (x:ys)

}

class Node {
    String name;
    Node next;

    Node(String name) {
        this.name = name;
    }

    Node(String name, Node next) {
        this.name = name;
        this.next = next;
    }

    public String toString() {
        return name + (next == null ? " -> nil" : (" -> " + next));
    }
}
