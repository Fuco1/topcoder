import java.util.*;

public class ProjectDependency {

    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");

        a.add(b);
        a.add(c);
        b.add(d);
        b.add(e);
        c.add(f);
        c.add(g);
        d.add(f);
        //f.add(a);

        List<Node> graph = new ArrayList<Node>(Arrays.asList(new Node[]{f,c,b,a,d,g,e}));

        System.out.println(topoSort(graph));
    }

    public static List<Node> topoSort(List<Node> graph) {
        List<Node> out = new ArrayList<Node>();
        for (Node n : graph) {
            if (n.state == State.DONE) continue;
            visit(n, out);
        }
        return out;
    }

    private static void visit(Node n, List<Node> out) {
        if (n.state == State.PROC) throw new UnsupportedOperationException("Cycle");
        if (n.state == State.READY) {
            n.state = State.PROC;
            for (Node m : n.neighbors) {
                visit(m, out);
            }
            n.state = State.DONE;
            out.add(n);
        }
    }

}

enum State {
    READY,
    DONE,
    PROC
}

class Node {
    String name;
    State state = State.READY;
    List<Node> neighbors = new ArrayList<Node>();

    Node(String name) {
        this.name = name;
    }

    void add(Node n) {
        neighbors.add(n);
    }

    public String toString() {
        return name;
    }
}
