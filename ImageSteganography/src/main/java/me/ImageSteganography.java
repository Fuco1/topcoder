package me;
import java.util.*;
import java.io.*;

public class ImageSteganography {

    public ImageSteganography() {}

    private static int getCode(char c) {
        if (c == ' ') return 0;
        if (c >= 'A' && c <= 'Z') return c - 'A' + 1;
        if (c >= 'a' && c <= 'z') return c - 'a' + 27;
        if (c >= '0' && c <= '9') return c - '0' + 53;
        return 63;
    }

    public static String[] encode(String[] image, String message) {
        Deque<Integer> msg = new ArrayDeque<Integer>();
        for (char c : message.toCharArray()) {
            int code = getCode(c);
            msg.add(code & 3);
            msg.add((code >> 2) & 3);
            msg.add((code >> 4) & 3);
        }
        List<String> re = new ArrayList<String>();
        for (String s : image) {
            String r = "";
            for (int i = 0; i < s.length(); i+=3) {
                int v = Integer.parseInt(s.substring(i, i+3));
                int m = msg.isEmpty() ? 3 : msg.poll();
                v = (v & (~3)) | m;
                r += String.format("%03d", v);
            }
            re.add(r);
        }
        return re.toArray(new String[0]);
    }
}
