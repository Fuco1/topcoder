import java.util.*;
import java.io.*;

public class TreeFromPairs {

    public TreeFromPairs() {}

    public static void main(String[] args) {
        System.out.println(build(new int[]{3,3,3,-1,2}));
        System.out.println(build(new int[]{4,8,3,8,5,8,3,4,-1,1,9,10,9}));
    }

    private static Node build(int[] parents) {
        Node[] nodes = new Node[parents.length];
        Node root = null;
        for (int i = 0; i < parents.length; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == -1) { root = nodes[i]; continue; }
            nodes[parents[i]].c.add(nodes[i]);
        }
        return root;
    }
}

class Node {
    List<Node> c = new ArrayList<Node>();
    int i;

    Node(int i) {
        this.i = i;
    }

    public String toString() {
        return "" + i + c;
    }
}
