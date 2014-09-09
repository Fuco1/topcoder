package me;
import java.util.*;
import java.io.*;
import com.google.common.collect.*;

public class BirthdayReminder {

    public BirthdayReminder() {}

    public static String[] remind(String[] friendNames, int[] birthDates, int currentDate, String[] occasions, int[] days, int k) {
        Queue<Event> q = new PriorityQueue<Event>();
        for (int i = 0; i < friendNames.length; i++) {
            for (int j = 0; j < occasions.length; j++) {
                int crep = (currentDate - birthDates[i]) / days[j];
                if ((currentDate - birthDates[i]) % days[j] != 0) crep++;
                q.add(new Event(friendNames[i], i, occasions[j], j, birthDates[i], days[j], crep));
            }
        }
        List<String> re = new ArrayList<String>();
        while (k > 0) {
            Event e = q.poll();
            q.add(e.bump());
            re.add(String.format("%d. %s %s (%d)", e.day(), e.friend, e.event, e.rep));
            k--;
        }
        return re.toArray(new String[0]);
    }
}

class Event implements Comparable<Event> {

    String friend;
    int findex;
    String event;
    int eventindex;
    int bday;
    int cycle;
    int rep;

    Event(String friend, int findex, String event, int eventindex, int bday, int cycle, int rep) {
        this.friend = friend;
        this.findex = findex;
        this.event = event;
        this.eventindex = eventindex;
        this.bday = bday;
        this.cycle = cycle;
        this.rep = rep;
    }

    Event bump() {
        return new Event(friend, findex, event, eventindex, bday, cycle, rep + 1);
    }

    int day() {
        return bday + rep * cycle;
    }

    public int compareTo(Event other) {
        return ComparisonChain.start().compare(day(), other.day()).compare(eventindex, other.eventindex).compare(findex, other.findex).result();
    }
}
