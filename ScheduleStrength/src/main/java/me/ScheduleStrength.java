package me;
import java.util.*;
import java.io.*;

public class ScheduleStrength {

    public ScheduleStrength() {}

    public static String[] calculate(String[] teams, String[] results) {
        List<Record> r = new ArrayList<Record>();
        for (int i = 0; i < teams.length; i++) {
            int w = 0;
            int l = 0;
            for (int j = 0; j < teams.length; j++) {
                if (results[i].charAt(j) != '-') {
                    for (int k = 0; k < teams.length; k++) {
                        if (k == i) continue;
                        if (results[j].charAt(k) == 'W') w++;
                        if (results[j].charAt(k) == 'L') l++;
                    }
                }
            }
            r.add(new Record(teams[i], w/(double)(w+l)));
        }
        Collections.sort(r, Collections.reverseOrder());
        List<String> re = new ArrayList<String>();
        for (Record rec : r) {
            re.add(rec.team);
        }
        return re.toArray(new String[0]);
    }
}

class Record implements Comparable<Record> {
    String team;
    double rate;
    Record(String team, double rate) {
        this.team = team;
        this.rate = rate;
    }

    public int compareTo(Record other) {
        int d = Double.compare(this.rate, other.rate);
        if (d != 0) return d;
        else return -team.compareTo(other.team);
    }
}
