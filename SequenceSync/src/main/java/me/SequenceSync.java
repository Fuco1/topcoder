package me;
import java.util.*;
import java.io.*;

public class SequenceSync {

    public SequenceSync() {}

    // riesenie je mat proste tabulku pre vsetkych 1 << 21 stavov a pridavat si tie dostupne...
    public static int getLength(String[] transitions) {
        System.out.println(transitions);
        int[][] t = new int[transitions.length][4];
        BitSet[] avail = new BitSet[transitions.length];
        for (int i = 0; i < transitions.length; i++) {
            avail[i] = new BitSet();
            avail[i].set(i);
            String[] trans = transitions[i].split(" ");
            for (int j = 0; j < 4; j++) {
                t[i][j] = Integer.parseInt(trans[j]);
            }
        }
        boolean change;
        int step = 0;
        do {
            BitSet r = new BitSet();
            r.set(0,avail.length);
            //System.out.println("re " + r);
            for (BitSet b : avail) {
                r.and(b);
                //System.out.println("re " + r);
            }
            if (!r.isEmpty()) return step;
            step++;
            change = false;
            for (int k = 0; k < avail.length; k++) {
                BitSet next = new BitSet();
                for (int i = avail[k].nextSetBit(0); i >= 0; i = avail[k].nextSetBit(i+1)) {
                    for (int j = 0; j < 4; j++) {
                        next.set(t[i][j]);
                    }
                }
                System.out.println(next);
                if (!avail[k].equals(next)) change = true;
                avail[k] = next;
            }
            System.out.println("-----");
        } while (change && step <= t.length * 4);
        return -1;
    }
}
