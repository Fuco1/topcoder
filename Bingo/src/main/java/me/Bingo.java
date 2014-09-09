package me;
import java.util.*;
import java.io.*;

public class Bingo {

    public Bingo() {}

    private static int getIndex(char c) {
        if (c == 'B') return 0;
        if (c == 'I') return 1;
        if (c == 'N') return 2;
        if (c == 'G') return 3;
        if (c == 'O') return 4;
        return -1;
    }

    private static char getChar(int c) {
        return "BINGO".charAt(c);
    }

    public static String winner(String[] card, String[] calls) {
        int[][] board = new int[5][5];
        for (int[] i : board) {
            Arrays.fill(i, 1000000);
        }
        board[2][2] = 0;
        int[][] cards = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String[] s = card[i+1].replaceAll(" +", " ").replaceAll("^ *", "").split(" ");
            //System.out.println(Arrays.toString(s));
            for (int j = 0; j < 5; j++) {
                if (i == j && j == 2) cards[i][j] = 0;
                else cards[i][j] = Integer.parseInt(s[j]);
            }
        }
        //print(cards);
        int turn = 1;
        for (String call : calls) {
            if (call.equals("BINGO")) return "YOU LOSE";
            int c = getIndex(call.charAt(0));
            int val = Integer.parseInt(call.substring(1));
            int j = 0;
            for (; j < 5; j++) {
                if (cards[j][c] == val) {
                    board[j][c] = turn;
                    break;
                }
            }
            //System.out.format("c %d, val %d, j %d\n",c, val, j);
            //print(board);
            if (j == 5) continue;
            int sumr = 0;
            int sumc = 0;
            int sumd = (c == j) ? 0 : 1000000;
            int suma = (c == 4-j) ? 0 : 1000000;
            //System.out.println(j);
            for (int k = 0; k < 5; k++) {
                sumr += board[j][k];
                sumc += board[k][c];
                if (c == j) {
                    sumd += board[k][k];
                }
                if (c == 4-j) {
                    suma += board[k][4-k];
                }
            }
            //System.out.format("r %d c %d d %d a %d\n", sumr, sumc, sumd, suma);
            int m = Math.min(sumr, Math.min(sumc, Math.min(sumd, suma)));
            //System.out.println(m);
            if (m < 1000000) {
                List<Pair> re = new ArrayList<Pair>();
                for (int k = 0; k < 5; k++) {
                    if (m == sumr) {
                        re.add(new Pair(""+getChar(k)+cards[j][k], board[j][k]));
                    } else if (m == sumc) {
                        re.add(new Pair(""+getChar(c)+cards[k][c], board[k][c]));
                    } else if (m == sumd) {
                        re.add(new Pair(""+getChar(k)+cards[k][k], board[k][k]));
                    } else if (m == suma) {
                        re.add(new Pair(""+getChar(4-k)+cards[k][4-k], board[k][4-k]));
                    }
                }
                Collections.sort(re);
                List<String> f = new ArrayList<String>();
                for (Pair p : re) {
                    f.add(p.name);
                }
                f.remove("N0");
                String r = "";
                for (int i = 0; i < f.size()-1; i++) {
                    r += f.get(i) + ",";
                }
                r += f.get(f.size()-1);
                return r;
            }
            turn++;
        }
        return "YOU LOSE";
    }

    private static void print(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                System.out.format("%3d", data[i][j]);
            }
            System.out.println("");
        }
    }
}

class Pair implements Comparable<Pair> {
    String name;
    int turn;

    Pair(String name, int turn) {
        this.name = name;
        this.turn = turn;
    }

    public int compareTo(Pair p) {
        return Integer.compare(turn, p.turn);
    }
}
