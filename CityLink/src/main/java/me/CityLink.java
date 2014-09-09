package me;
import java.util.*;
import java.io.*;

public class CityLink {

    public CityLink() {}

    public static int timeTaken(int[] x, int[] y) {
        Queue<Link> q = new PriorityQueue<Link>(x.length * y.length);
        for (int i = 0; i < x.length; i++) {
            for (int j = i+1; j < x.length; j++) {
                int dist;
                if (x[i] == x[j]) dist = (Math.abs(y[i] - y[j])+1) / 2;
                else if (y[i] == y[j]) dist = (Math.abs(x[i] - x[j])+1) / 2;
                else dist = Math.max(Math.abs(x[i] - x[j]), Math.abs(y[i] - y[j]));
                q.add(new Link(i,j,dist));
            }
        }
        Node[] cities = new Node[x.length];
        for (int i = 0; i < cities.length; i++) {
            cities[i] = new Node();
        }
        while (!q.isEmpty()) {
            Link c = q.poll();
            if (cities[c.a].getGroup() != cities[c.b].getGroup()) {
                cities[c.a].merge(cities[c.b]);
            }
            if (cities[c.a].getGroup().size == x.length) return c.dist;
        }
        return 1000000000;
    }
}

class Node {
    Node parent;
    int size = 1;

    Node() {
        this.parent = this;
    }

    void merge(Node node) {
        Node np = node.getGroup();
        Node tp = getGroup();
        tp.parent = np;
        np.size += tp.size;
    }

    Node getGroup() {
        if (parent == this) return this;
        Node p = parent.getGroup();
        if (p != null) {
            parent = p;
        }
        return p;
    }
}

class Link implements Comparable<Link> {
    int a;
    int b;
    int dist;

    Link(int a, int b, int dist) {
        this.a = a;
        this.b = b;
        this.dist = dist;
    }

    public int compareTo(Link other) {
        return Integer.compare(dist, other.dist);
    }
}
