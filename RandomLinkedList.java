import java.util.*;

public class RandomLinkedList {

    public RandomLinkedList() {}

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
        a.random = d;
        b.random = c;
        c.random = a;
        d.random = d;
        e.random = c;
        System.out.println(a);
        Node copy = copy(a);
        System.out.println(copy);
    }

    public static Node copy(Node start) {
        Node tmp = start;
        while (tmp != null) {
            Node tmpnext = tmp.next;
            Node n = new Node(tmp.name + " copy");
            tmp.next = n;
            n.next = tmpnext;
            tmp = tmpnext;
        }
        tmp = start;
        while (tmp != null) {
            tmp.next.random = tmp.random.next;
            tmp = tmp.next.next;
        }
        tmp = start;
        while (tmp != null) {
            Node n = tmp.next;
            tmp = tmp.next.next;
            n.next = tmp == null ? null : tmp.next;
        }
        return start.next;
    }
}


class Node {
    String name;
    Node next;
    Node random;

    Node(String name) {
        this.name = name;
    }

    Node(String name, Node next) {
        this.name = name;
        this.next = next;
    }

    Node(String name, Node next, Node random) {
        this.name = name;
        this.next = next;
        this.random = random;
    }

    public String toString() {
        return name + "(random:" + random.name + ")" + (next == null ? " -> nil" : (" -> " + next));
    }
}
