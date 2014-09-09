import java.util.*;
import java.io.*;

public class MazeWithGuards {

    public MazeWithGuards() {}

    public static void main(String[] args) {
        distance(loadBoard("1.board"));
        distance(loadBoard("2.board"));
        distance(loadBoard("3.board"));
        distance(loadBoard("4.board"));
        distance(loadBoard("5.board"));
    }

    public static void distance(char[][] board) {
        Point[][] points = new Point[board.length][board[0].length];
        Deque<Point> q = new ArrayDeque<Point>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                points[r][c] = new Point(r,c);
                if (board[r][c] == 'G') {
                    points[r][c].type = Type.GUARD;
                    q.add(points[r][c]);
                } else if (board[r][c] == 'B') {
                    points[r][c].type = Type.BLOCK;
                }
            }
        }
        while (!q.isEmpty()) {
            Point c = q.poll();
            for (Point n : c.getNeighbors(points)) {
                n.d = c.d + 1;
                q.add(n);
            }
        }
        printBoard(points);
    }

    private static void printBoard(Point[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                Point p = board[r][c];
                switch (p.type) {
                case GUARD: System.out.print("  G"); break;
                case BLOCK: System.out.print("  B"); break;
                case EMPTY: System.out.format("%3d", p.d); break;
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private static char[][] loadBoard(String file) {
        String line;
        List<String> lines = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while ((line = in.readLine()) != null) {
                lines.add(line);
            }
            in.close();
        } catch (IOException e) {
        }
        char[][] re = new char[lines.size()][lines.get(0).length()];
        int i = 0;
        for (String l : lines) {
            re[i++] = l.toCharArray();
        }
        return re;
    }

}

enum Type {
    GUARD,
    BLOCK,
    EMPTY
}

class Point {
    Type type = Type.EMPTY;
    int d = 0;
    int r;
    int c;
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    List<Point> getNeighbors(Point[][] board) {
        List<Point> re = new ArrayList<Point>();
        if (r - 1 >= 0 && board[r-1][c].type == Type.EMPTY && board[r-1][c].d == 0) {
            re.add(board[r-1][c]);
        }
        if (r + 1 < board.length && board[r+1][c].type == Type.EMPTY && board[r+1][c].d == 0) {
            re.add(board[r+1][c]);
        }
        if (c - 1 >= 0 && board[r][c-1].type == Type.EMPTY && board[r][c-1].d == 0) {
            re.add(board[r][c-1]);
        }
        if (c + 1 < board[0].length && board[r][c+1].type == Type.EMPTY && board[r][c+1].d == 0) {
            re.add(board[r][c+1]);
        }
        return re;
    }
}
