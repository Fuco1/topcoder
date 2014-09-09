package me;
import java.util.*;
import java.io.*;

public class Thimbles {

    public Thimbles() {}

    public static int thimblesWithBall(String[] swaps) {
        int ball = 1;
        for (String s : swaps) {
            int source = Integer.parseInt(s.substring(0,1));
            int target = Integer.parseInt(s.substring(2,3));
            if (ball == source) {
                ball = target;
            } else if (ball == target) {
                ball = source;
            }
        }
        return ball;
    }
}
