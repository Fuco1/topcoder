package me;
import java.util.*;
import java.io.*;

public class RoadConstruction {

    public RoadConstruction() {}

    public static int getExitTime(String[] lines) {
        List<Deque<Slot>> queues = new ArrayList<Deque<Slot>>();
        for (String l : lines) {
            Deque<Slot> d = new ArrayDeque<Slot>();
            for (char c : l.toCharArray()) {
                d.add(new Slot(c));
            }
            queues.add(d);
        }
        int t = 0;
        while (true) {
            Iterator<Deque<Slot>> it = queues.iterator();
            while (it.hasNext()) {
                Deque<Slot> q = it.next();
                if (q.peek().yielded || !it.hasNext()) {
                    if (q.poll().name == 'D') return t;
                    if (q.isEmpty()) it.remove();
                    break;
                } else {
                    q.peek().yielded = true;
                }
            }
            t++;
        }
    }
}


class Slot {
    char name;
    boolean yielded = false;
    Slot(char name) {
        this.name = name;
    }
}
