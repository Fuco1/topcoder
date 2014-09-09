package me;
import java.util.*;
import java.io.*;

public class NewMagicSquare {

    public NewMagicSquare() {}

    public static String[] completeTheSquare(String[] square) {
        int[][] data = new int[5][5];
        BitSet[][] constrains = new BitSet[5][5];
        int r = 0;
        for (String s : square) {
            for (int c = 0; c < 5; c++) {
                String cell = s.substring(c*3, c*3+2);
                BitSet b = new BitSet();
                constrains[r][c] = b;
                if (cell.charAt(0) == '?') {
                    data[r][c] = -1;
                    for (int i = c+1; i <= 21+c; i++) {
                        b.set(i);
                    }
                }
                else {
                    data[r][c] = Integer.parseInt(cell);
                }
            }
            r++;
        }
        printTable(data);
        boolean search = doComplete(data, constrains);
        if (!search) return new String[0];
        else {
            String[] re = new String[5];
            for (r = 0; r < 5; r++) {
                String s = "";
                for (int c = 0; c < 5; c++) {
                    s += String.format("%02d", data[r][c]);
                    if (c < 4) s += " ";
                }
                re[r] = s;
            }
            return re;
        }
    }

    private static boolean propagate(int[][] data, BitSet[][] constrains) {
        // row propagation
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                int l = data[r][c];
                if (l < 0) continue;
                for (int i = 0; i < c; i++) {
                    BitSet b = constrains[r][i];
                    for (int j = l-c+i+1; 0 < j && j <= 25; j++) {
                        b.clear(j);
                    }
                }
                for (int i = c+1; i < 5; i++) {
                    BitSet b = constrains[r][i];
                    for (int j = 1; 0 < j && j <= l-c-1+i; j++) {
                        b.clear(j);
                    }
                }
            }
        }
        // table propagation of used values
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                int l = data[r][c];
                if (l > 0) {
                    for (int rr = 0; rr < 5; rr++) {
                        for (int cc = 0; cc < 5; cc++) {
                            BitSet b = constrains[rr][cc];
                            b.clear(l);
                        }
                    }
                }
            }
        }
        // set values where only one is possible
        boolean set;
        do {
            set = false;
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    BitSet con = constrains[r][c];
                    if (con.cardinality() == 1) {
                        int l = con.nextSetBit(1);
                        data[r][c] = l;
                        for (int rr = 0; rr < 5; rr++) {
                            for (int cc = 0; cc < 5; cc++) {
                                constrains[rr][cc].clear(l);
                            }
                        }
                        set = true;
                    }
                }
            }
        } while (set);

        // if there is an impossible assignment, return false immediately;
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (data[r][c] == -1 && constrains[r][c].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean doComplete(int[][] data, BitSet[][] constrains) {
        if (!propagate(data, constrains)) return false;
        //printTable(constrains);
        boolean set = true;
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (data[r][c] == -1) {
                    set = false;
                    if (constrains[r][c].isEmpty()) {
                        return false;
                    } else {
                        BitSet con = constrains[r][c];
                        for (int l = con.nextSetBit(1); l > 0; l = con.nextSetBit(l+1)) {
                            int[][] dc = copyInt(data);
                            BitSet[][] bc = copyBitSet(constrains);
                            dc[r][c] = l;
                            bc[r][c].clear();
                            boolean re = doComplete(dc, bc);
                            if (re) {
                                for (int rr = 0; rr < 5; rr++) {
                                    for (int cc = 0; cc < 5; cc++) {
                                        data[rr][cc] = dc[rr][cc];
                                    }
                                }
                                return re;
                            }
                        }
                        return false;
                    }
                }
            }
        }
        return set;
    }

    private static int[][] copyInt(int[][] data) {
        int[][] re = new int[data.length][data[0].length];
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[0].length; c++) {
                re[r][c] = data[r][c];
            }
        }
        return re;
    }

    private static BitSet[][] copyBitSet(BitSet[][] data) {
        BitSet[][] re = new BitSet[data.length][data[0].length];
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[0].length; c++) {
                BitSet b = new BitSet();
                b.or(data[r][c]);
                re[r][c] = b;
            }
        }
        return re;
    }

    private static void printTable(int[][] table) {
        for (int j = 0; j < table.length; j++) {
            for (int i = 0; i < table[0].length; i++) {
                System.out.format("%5d",table[j][i]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private static void printTable(BitSet[][] table) {
        for (int j = 0; j < table.length; j++) {
            for (int i = 0; i < table[0].length; i++) {
                BitSet b = table[j][i];
                for (int k = 1; k <= 25; k++) {
                    if (b.get(k)) System.out.print("1");
                    else System.out.print("0");
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
