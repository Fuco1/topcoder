import java.util.*;
import java.io.*;

public class SetBits {

    public SetBits() {}

    public static void main(String[] args) {
        System.out.println(setBits(0b110101101));
        System.out.println(setBits(0xFFFFFFFF));
        System.out.println(setBits(0));
        System.out.println(setBits(0x55555555));
    }

    public static int setBits(int i) {
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        return (((i + (i >>> 4)) & 0x0f0f0f0f) * 0x01010101) >>> 24;
    }
}
