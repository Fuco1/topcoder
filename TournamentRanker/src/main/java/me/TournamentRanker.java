package me;
import java.util.*;
import java.io.*;
import com.google.common.collect.*;

public class TournamentRanker {

    public TournamentRanker() {}

    public static String[] rankTeams(String[] names, String[] lostTo) {
        Map<String, Node> nodes = new HashMap<String, Node>(names.length);
        for (int i = 0; i < names.length; i++) {
            nodes.put(names[i], new Node(names[i]));
        }
        Node root = null;
        for (int i = 0; i < lostTo.length; i++) {
            if (!lostTo[i].isEmpty()) nodes.get(lostTo[i]).children.add(nodes.get(names[i]));
            else root = nodes.get(names[i]);
        }

        Queue<Node> q = new PriorityQueue<Node>(names.length, Collections.reverseOrder());
        q.add(root);
        int tick = 0;
        List<String> re = new ArrayList<String>();
        while (!q.isEmpty()) {
            Node c = q.poll();
            re.add(c.name);
            for (Node n : c.children) {
                n.order = tick++;
                q.add(n);
            }
        }
        return re.toArray(new String[0]);
    }

}


class Node implements Comparable<Node> {
    String name;
    List<Node> children = new ArrayList<Node>();
    int height = -1;
    int order;

    Node(String name) { this.name = name; }

    int getHeight() {
        if (height != -1) return height;
        if (children.isEmpty()) height = 0;
        else height = Collections.max(children).getHeight() + 1;
        return height;
    }

    // not really needed, just for pretty output
    void order() {
        Collections.sort(children, Collections.reverseOrder());
        for (Node n : children) n.order();
    }

    public int compareTo(Node other) {
        return ComparisonChain.start().compare(this.getHeight(), other.getHeight()).compare(other.order, this.order).result();
    }

    public String toString() {
        return name + "(" + height + ") " + children ;
    }
}
