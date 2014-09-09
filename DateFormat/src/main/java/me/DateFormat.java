package me;
import java.util.*;
import java.io.*;

public class DateFormat {

    public DateFormat() {}

    public static String fromEuropeanToUs(String[] dateList) {
        String dateString = "";
        for (String s : dateList) {
            dateString += s;
        }
        String[] dates = dateString.split(" ");
        List<DateInput> dateinputs = new ArrayList<DateInput>();
        for (String s : dates) {
            int first = Integer.parseInt(s.substring(0,2));
            int second = Integer.parseInt(s.substring(3,5));
            dateinputs.add(new DateInput(first, second));
        }
        int lastM = -1;
        int lastD = -1;
        String re = "";
        for (DateInput d : dateinputs) {
            if (lastM == -1) {
                re += String.format("%02d/%02d", d.smaller(), d.bigger());
                lastM = d.smaller();
                lastD = d.bigger();
            } else if (lastM < d.smaller()) {
                re += String.format(" %02d/%02d", d.smaller(), d.bigger());
                lastM = d.smaller();
                lastD = d.bigger();
            } else if (lastM == d.smaller() && lastD < d.bigger()) {
                re += String.format(" %02d/%02d", d.smaller(), d.bigger());
                lastM = d.smaller();
                lastD = d.bigger();
            } else if (d.bigger() <= 12 && lastM < d.bigger()) {
                re += String.format(" %02d/%02d", d.bigger(), d.smaller());
                lastM = d.bigger();
                lastD = d.smaller();
            } else if (d.bigger() <= 12 && lastM == d.bigger() && lastD < d.smaller()) {
                re += String.format(" %02d/%02d", d.bigger(), d.smaller());
                lastM = d.bigger();
                lastD = d.smaller();
            }  else return "";
        }
        return re;
    }
}

class DateInput {
    int first;
    int second;
    DateInput(int first, int second) {
        this.first = first;
        this.second = second;
    }

    int smaller() {
        return first < second ? first : second;
    }

    int bigger() {
        return first > second ? first : second;
    }
}
