import java.util.*;

public class Graphs {

    public Graphs() {}

    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");
        Node j = new Node("J");
        Node k = new Node("K");
        a.add(b).add(c);
        b.add(a).add(c);
        c.add(a).add(b).add(d).add(e);
        d.add(c).add(f).add(g);
        e.add(c).add(g).add(h);
        f.add(d).add(g);
        g.add(f).add(d).add(e);
        h.add(e).add(i).add(j);
        i.add(j).add(h);
        j.add(i).add(h).add(k);
        k.add(j);
        List<Node> graph = new ArrayList<Node>();
        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);
        graph.add(f);
        graph.add(g);
        graph.add(h);
        graph.add(i);
        graph.add(j);
        graph.add(k);
        System.out.println("triangles: " +  triangles(graph));
    }

    public static int triangles(List<Node> graph) {
        int triangles = 0;
        Collections.sort(graph, new Comparator<Node>() {

                public int compare(Node it, Node other) {
                    return Integer.compare(it.degree(), other.degree());
                }
            });

        for (Node n : graph) {
            for (Node m : n.next) {
                if (m.state != State.DELETED) {
                    m.state = State.MARKED;
                }
            }
            for (Node m : n.next) {
                if (m.state != State.MARKED) continue;
                for (Node x : m.next) {
                    if (x.state == State.MARKED) {
                        triangles++;
                        System.out.println("Triangle found: " + n.name + " " + m.name + " " + x.name);
                    }
                }
                m.state = State.READY;
            }
            n.state = State.DELETED;
        }
        return triangles;
    }

}

enum State {
    DELETED,
    MARKED,
    READY
}

class Node {
    State state = State.READY;
    String name;
    List<Node> next = new ArrayList<Node>();

    Node(String name) {
        this.name = name;
    }

    Node add(Node node) {
        next.add(node);
        return this;
    }

    int degree() {
        return next.size();
    }
}
