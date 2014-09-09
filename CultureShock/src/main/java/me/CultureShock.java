package me;
import java.util.*;
import java.io.*;

public class CultureShock {

    public CultureShock() {}

    // yay statemachines
    public static String translate(String text) {
        int replace = 0;
        char [] buf = text.toCharArray();
        for (int i = 0; i < buf.length; i++) {
            if (replace == 0) {
                if (buf[i] == 'Z') replace = 1;
                else replace = -1;
            }
            if (replace == 2 && buf[i] == 'E') replace = 3;
            if (replace == 1 && buf[i] == 'E') replace = 2;
            if (replace == 3) {
                if (i == buf.length - 1) buf[i] = 'D';
                else if (buf[i+1] == ' ') buf[i] = 'D';
                else replace = -1;
            }
            if (buf[i] == ' ') replace = 0;
        }
        return String.valueOf(buf);
    }
}
