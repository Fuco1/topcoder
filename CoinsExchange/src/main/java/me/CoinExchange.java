package me;
import java.util.*;
import java.io.*;
import com.google.common.collect.*;

public class CoinExchange {

    public CoinExchange() {}

    public static int countExchanges(int g1, int s1, int b1, int g2, int s2, int b2) {
        int num = 0;
        while (b1 < b2) {
            if (s1 > s2) {
                s1--;
                b1 += 9;
            } else if (g1 > g2) {
                g1--;
                s1 += 9;
            } else return -1;
            num++;
        }
        while (s1 < s2) {
            if (g1 > g2) {
                g1--;
                s1 += 9;
            } else if (b1 - 11 >= b2) {
                b1 -= 11;
                s1++;
            } else return -1;
            num++;
        }
        while (g1 < g2) {
            if (s1 - 11 >= s2) {
                g1++;
                s1 -= 11;
            } else if (b1 - 11 >= b2) {
                b1 -= 11;
                s1++;
            } else return -1;
            num++;
        }
        return num;
    }

    // public static int countExchanges(int g1, int s1, int b1, int g2, int s2, int b2) {
    //     return doCountExchanges(g1, s1, b1, g2, s2, b2, new HashSet<State>());
    // }

    // private static int doCountExchanges(int g1, int s1, int b1, int g2, int s2, int b2, Set<State> visited) {
    //     State target = new State(g2,s2,b2);
    //     State start = new State(g1, s1, b1);
    //     if (target.compareTo(start) <= 0) {
    //         return 0;
    //     }
    //     Deque<State> q = new ArrayDeque<State>();
    //     q.add(start);
    //     while (!q.isEmpty()) {
    //         State cur = q.poll();
    //         for (State s : cur.neighbors()) {
    //             if (target.compareTo(s) <= 0) {
    //                 return cur.d + 1;
    //             }
    //             if (!visited.contains(s)) {
    //                 s.d = cur.d + 1;
    //                 q.add(s);
    //                 visited.add(s);
    //             }
    //         }
    //     }
    //     return -1;
    // }
}

class State implements Comparable<State> {
    int g;
    int s;
    int b;
    int d = 0;

    State(int g, int s, int b) {
        this.g = g;
        this.s = s;
        this.b = b;
    }

    Iterable<State> neighbors() {
        List<State> re = new ArrayList<State>();
        if (g > 0) {
            re.add(new State(g-1, s+9, b));
        }
        if (s > 0) {
            re.add(new State(g, s-1, b+9));
        }
        if (s > 11) {
            re.add(new State(g+1, s-11, b));
        }
        if (b > 11) {
            re.add(new State(g, s+1, b-11));
        }
        return re;
    }

    public int compareTo(State other) {
        boolean le = this.g <= other.g && this.s <= other.s && this.b <= other.b;
        boolean eq = this.g == other.g && this.s == other.s && this.b == other.b;
        if (eq) return 0;
        else if (le) return -1;
        else return 1;
    }

    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        State o = (State) other;
        return this.g == o.g && this.s == o.s && this.b == o.b;
    }

    public int hashCode() {
        return ((31 * g) << 13) ^ ((37 * s) << 7) ^ ((41 * b) << 3);
    }
}
