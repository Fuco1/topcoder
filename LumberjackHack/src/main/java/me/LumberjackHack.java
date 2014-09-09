package me;
import java.util.*;
import java.io.*;

public class LumberjackHack {

    public LumberjackHack() {}

    private static boolean[][] done;
    private static int[][] time;
    private static char[][] map;

    public static int timeToShore(String[] riverMap) {
        Queue<Point> q = new PriorityQueue<Point>();
        done = new boolean[riverMap.length][riverMap[0].length()];
        time = new int[riverMap.length][riverMap[0].length()];
        map = new char[riverMap.length][riverMap[0].length()];
        int r = 0;
        Point start = null;
        for (String s : riverMap) {
            for (int c = 0; c < s.length(); c++) {
                map[r][c] = s.charAt(c);
                time[r][c] = 99999999;
                if (s.charAt(c) == '+') {
                    start = new Point(r,c,0);
                    map[r][c] = '|';
                    time[r][c] = 0;
                }
            }
            r++;
        }
        q.add(start);
        while (!q.isEmpty()) {
            Point cur = q.poll();
            //System.out.println(cur);
            done[cur.r][cur.c] = true;
            if (cur.c == 0 || cur.c == riverMap[0].length() - 1) return time[cur.r][cur.c];
            if (cur.r - 1 >= 0 && !done[cur.r-1][cur.c]) {
                if (map[cur.r-1][cur.c] == '.') {
                    if (!cur.seenWater) relax(q, new Point(cur.r - 1, cur.c, cur.time + 3, true));
                } else {
                    relax(q, new Point(cur.r - 1, cur.c, cur.time + 1, cur.seenWater));
                }
            }
            if (cur.r + 1 < riverMap.length && !done[cur.r+1][cur.c]) {
                if (map[cur.r+1][cur.c] == '.') {
                    if (!cur.seenWater) relax(q, new Point(cur.r + 1, cur.c, cur.time + 3, true));
                } else {
                    relax(q, new Point(cur.r + 1, cur.c, cur.time + 1, cur.seenWater));
                }
            }
            if (cur.c - 1 >= 0 && !done[cur.r][cur.c-1]) {
                if (map[cur.r][cur.c-1] == '.') {
                    if (!cur.seenWater) relax(q, new Point(cur.r, cur.c - 1, cur.time + 3, true));
                } else {
                    relax(q, new Point(cur.r, cur.c - 1, cur.time + 2, cur.seenWater));
                }
            }
            if (cur.c + 1 < riverMap[0].length() && !done[cur.r][cur.c+1]) {
                if (map[cur.r][cur.c+1] == '.') {
                    if (!cur.seenWater) relax(q, new Point(cur.r, cur.c + 1, cur.time + 3, true));
                } else {
                    relax(q, new Point(cur.r, cur.c + 1, cur.time + 2, cur.seenWater));
                }
            }
        }
        return -1;
    }

    private static void relax(Queue<Point> q, Point c) {
        if (c.time < time[c.r][c.c]) time[c.r][c.c] = c.time;
        q.add(c);
    }
}

class Point implements Comparable<Point> {
    int r;
    int c;
    int time;
    boolean seenWater = false;

    Point(int r, int c, int time) {
        this.r = r;
        this.c = c;
        this.time = time;
    }

    Point(int r, int c, int time, boolean seenWater) {
        this.r = r;
        this.c = c;
        this.time = time;
        this.seenWater = seenWater;
    }

    public int compareTo(Point other) {
        return Integer.compare(this.time, other.time);
    }

    public String toString() {
        return String.format("r: %2d c: %2d time: %4d seenWater %d", r, c, time, seenWater ? 1 : 0);
    }
}
