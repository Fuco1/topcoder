import java.util.*;
import java.io.*;

public class Hanoi {

    public Hanoi() {}

    private static Deque<Integer> d1 = new ArrayDeque<Integer>();
    private static Deque<Integer> d2 = new ArrayDeque<Integer>();
    private static Deque<Integer> d3 = new ArrayDeque<Integer>();

    public static void main(String[] args) {
        d1.push(5);
        d1.push(4);
        d1.push(3);
        d1.push(2);
        d1.push(1);
        hanoi(d1, d2, d3, d1.size());
        System.out.println(d1 + " " + d2 + " " + d3);
    }

    private static void hanoi(Deque<Integer> s, Deque<Integer> c, Deque<Integer> a, int n) {
        if (n == 1) {
            c.push(s.pop());
        } else {
            hanoi(s,a,c,n-1);
            c.push(s.pop());
            System.out.println(d1 + " " + d2 + " " + d3);
            hanoi(a,c,s,n-1);
        }
    }

}
