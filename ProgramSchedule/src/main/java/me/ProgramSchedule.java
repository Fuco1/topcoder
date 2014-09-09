package me;
import java.util.*;
import java.io.*;

public class ProgramSchedule {

    public ProgramSchedule() {}

    public static int schedule(int[] a, int[] b) {
        List<Task> tasks = new ArrayList<Task>();
        for (int i = 0; i < a.length; i++) {
            tasks.add(new Task(a[i], b[i]));
        }
        Collections.sort(tasks, Collections.reverseOrder());
        int max = 0;
        int start = 0;
        for (Task t : tasks) {
            max = Math.max(max, start+t.p+t.d);
            start += t.p;
        }
        return max;
    }

}


class Task implements Comparable<Task> {
    int p;
    int d;

    Task(int p, int d) {
        this.p = p;
        this.d = d;
    }

    public int compareTo(Task other) {
        return Integer.compare(this.d, other.d);
    }
}
