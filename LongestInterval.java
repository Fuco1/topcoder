import java.util.*;

public class LongestInterval {

    public LongestInterval() {}

    public static void main(String[] args) {
        System.out.println(longestIntervalOtherEnd(new int[]{5,1,9,3,8,20,4,10,2,11,3}));
        System.out.println(longestIntervalOtherEnd(new int[]{1,3,5,7,9,8,6,4,2}));
        System.out.println(longestIntervalOtherEnd(new int[]{1,3,5,7,9,2,4,6,8}));
        System.out.println(longestIntervalOtherEnd(new int[]{9,7,5,3,1,8,6,4,2}));
        System.out.println(longestIntervalOtherEnd(new int[]{19,16,5,1,9,3,18,17,8,20,4,10,2,11,3,6,13,15,12,14}));
    }

    public static Interval longestInterval(int[] data) {
        Map<Integer, Interval> ints = new HashMap<Integer, Interval>();
        for (int i : data) {
            Interval left = ints.get(i-1);
            Interval right = ints.get(i+1);
            Interval cur = new Interval(i,i);
            cur.merge(left).merge(right);
            if (left != null) left.reset(cur);
            if (right != null) right.reset(cur);
            ints.put(i, cur);
        }
        return Collections.max(ints.values(), new Comparator<Interval>() {
                public int compare(Interval t, Interval o) {
                    return Integer.compare(t.length(), o.length());
                }
            });
    }

    public static Interval longestIntervalOtherEnd(int[] data) {
        Map<Integer, Integer> ints = new HashMap<Integer, Integer>();
        for (int i : data) {
            if (ints.containsKey(i)) continue;
            if (ints.containsKey(i-1) && ints.containsKey(i+1)) {
                int a = ints.get(i-1);
                int b = ints.get(i+1);
                ints.put(a, b);
                ints.put(b, a);
                ints.put(i,i);
            } else if (ints.containsKey(i-1)) {
                int a = ints.get(i-1);
                ints.put(a,i);
                ints.put(i,a);
            } else if (ints.containsKey(i+1)) {
                int b = ints.get(i+1);
                ints.put(b,i);
                ints.put(i,b);
            } else {
                ints.put(i,i);
            }
        }
        System.out.println(ints);
        int max = 0;
        int maxi = 0;
        for (int i : ints.keySet()) {
            if (Math.abs(i - ints.get(i)) > max) {
                max = Math.abs(i - ints.get(i));
                maxi = i;
            }
        }
        return new Interval(Math.min(maxi, ints.get(maxi)), Math.max(maxi, ints.get(maxi)));
    }

    public static Interval longestIntervalUnionFind(int[] data) {
        Map<Integer, Integer> ints = new HashMap<Integer, Integer>();
        for (int i : data) {
            if (ints.containsKey(i-1)) {
                ints.put(i, i-1);
            } else if (!ints.containsKey(i)) {
                ints.put(i, i);
            }
            if (ints.containsKey(i+1)) {
                ints.put(i+1, ints.get(i));
            }
        }
        int max = Integer.MIN_VALUE;
        int maxi = 0;
        Deque<Integer> s = new ArrayDeque<Integer>();
        for (int i : data) {
            int p = i;
            int dist = 0;
            while (p != ints.get(p)) {
                s.push(p);
                p = ints.get(p);
                dist++;
            }
            System.out.println(i + " -> " + p + " (dist: " + dist + " )");
            while (!s.isEmpty()) ints.put(s.poll(), p);
            if (i - p > max) {
                maxi = i;
                max = i - p;
            }
        }
        return new Interval(ints.get(maxi), maxi);
    }
}

class Interval {
    int l;
    int h;

    Interval(int l, int h) {
        this.l = l;
        this.h = h;
    }

    void reset(Interval other) {
        this.l = other.l;
        this.h = other.h;
    }

    Interval merge(Interval other) {
        if (other == null) return this;
        this.l = Math.min(other.l, l);
        this.h = Math.max(other.h, h);
        return this;
    }

    int length() {
        return h - l;
    }

    public String toString() {
        return l+"-"+h;
    }
}
