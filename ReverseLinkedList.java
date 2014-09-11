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
        Node a2 = new Node("a");
        Node b2 = new Node("b");
        Node c2 = new Node("c");
        Node d2 = new Node("d");
        Node e2 = new Node("e");
        a.next = a2;
        a2.next = b;
        b.next = c;
        c.next = b2;
        b2.next = d;
        d.next = e;
        e.next = c2;
        c2.next = d2;
        d2.next = e2;
        System.out.println(a);
        System.out.println(removeDup(a));
        System.out.println(addLists(new Node(3, new Node(1, new Node(5))), new Node(5, new Node(9, new Node(2)))));
        System.out.println(addLists(new Node(3, new Node(1, new Node(5))), new Node(5, new Node(9, new Node(4)))));
        System.out.println(addLists(new Node(3, new Node(1, new Node(5))), new Node(5, new Node(9, new Node(2, new Node(7))))));
        System.out.println(addLists(new Node(3, new Node(1, new Node(5))), new Node(5, new Node(9, new Node(4, new Node(7, new Node(4)))))));
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

    public static Node removeDup(Node start) {
        Node cur = start;
        Node prev = start;
        while (cur != null) {
            Node tmp = start;
            while (tmp != cur) {
                if (tmp.name.equals(cur.name)) break;
                tmp = tmp.next;
            }
            if (tmp != cur) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return start;
    }

    public static Node addLists(Node a, Node b) {
        Node c = new Node();
        Node cur = c;
        int carry = 0;
        while (a != null || b != null) {
            int v = (a == null ? 0 : a.val) + (b == null ? 0 : b.val) + carry;
            Node n = new Node(v % 10);
            carry = v / 10;
            cur.next = n;
            cur = n;
            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }
        if (carry == 1) cur.next = new Node(1);
        return c.next;
    }

    // reverse [] a = a
    // reverse (x:xs) ys = reverse xs (x:ys)

}

class Node {
    String name;
    int val;
    Node next;

    Node() {}

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    Node(String name) {
        this.name = name;
    }

    Node(String name, Node next) {
        this.name = name;
        this.next = next;
    }

    public String toString() {
        return name + "/" + val + (next == null ? " -> nil" : (" -> " + next));
    }
}
