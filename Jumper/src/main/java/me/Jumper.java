package me;

import java.util.*;

public class Jumper {

    private static class State {
        int step;
        int x;
        int y;

        State(int step, int x, int y) {
            this.step = step;
            this.x = x;
            this.y = y;
        }
    }

    public Jumper() {}

    private static String rotateString(String s, int offset) {
        int m = s.length();
        char[] ns = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ns[(((i + offset) % m) + m) % m] = s.charAt(i);
        }
        return new String(ns);
    }

    private static boolean[] getStage(int step, String pattern, int speed) {
        int r = step * speed;
        String cp = rotateString(pattern, r);
        cp = cp + cp + cp + cp;
        boolean[] re = new boolean[20];
        for (int i = 0; i < re.length; i++) {
            re[i] = cp.charAt(i) == '#';
        }
        return re;
    }

    public static int minTime(String[] patterns, int[] speeds, String rows) {
        // add the bottom/top layers
        String[] p = Arrays.copyOf(patterns, patterns.length+1);
        p[patterns.length] = "#####";
        int[] s = Arrays.copyOf(speeds, speeds.length+1);
        s[speeds.length] = 0;
        rows = patterns.length + rows;
        int[] r = new int[rows.length()];
        for (int i = 0; i < r.length; i++) {
            r[i] = Integer.parseInt(rows.substring(i, i+1));
        }

        boolean[][][] visited = new boolean[20][r.length][5];

        Deque<State> queue = new ArrayDeque<State>();
        queue.add(new State(0,0,0));
        while (!queue.isEmpty()) {
            State c = queue.poll();
            if (visited[c.x][c.y][c.step % 5]) continue;
            visited[c.x][c.y][c.step % 5] = true;
            if (c.y + 1 == r.length) {
                return c.step + 1;
            } else {
                boolean[] up = getStage(c.step, p[r[c.y + 1]], s[r[c.y + 1]]);
                if (up[c.x] &&
                    0 <= c.x + s[r[c.y + 1]] && c.x + s[r[c.y + 1]] < 20) {
                    queue.add(new State(c.step + 1, c.x + s[r[c.y + 1]], c.y + 1));
                }
            }

            if (0 <= c.x + s[r[c.y]] && c.x + s[r[c.y]] < 20) { // no move
                queue.add(new State(c.step + 1, c.x + s[r[c.y]], c.y));
            }
            boolean[] cur = getStage(c.step, p[r[c.y]], s[r[c.y]]);
            if (c.x + 1 < 20 && cur[c.x + 1] && 0 <= c.x + 1 + s[r[c.y]] && c.x + 1 + s[r[c.y]] < 20) { // right
                queue.add(new State(c.step + 1, c.x + 1 + s[r[c.y]], c.y));
            }
            if (0 <= c.x - 1 && cur[c.x - 1] && 0 <= c.x - 1 + s[r[c.y]] && c.x - 1 + s[r[c.y]] < 20) { // left
                queue.add(new State(c.step + 1, c.x - 1 + s[r[c.y]], c.y));
            }
            if (c.y > 0) {
                boolean[] down = getStage(c.step, p[r[c.y - 1]], s[r[c.y - 1]]);
                if (down[c.x] && 0 <= c.x + s[r[c.y - 1]] && c.x + s[r[c.y - 1]] < 20) {
                    queue.add(new State(c.step + 1, c.x + s[r[c.y - 1]], c.y - 1));
                }
            }
        }
        return -1;
    }
}
