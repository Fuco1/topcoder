import java.util.*;
import java.io.*;

public class ExternalSort {

    public ExternalSort() {}

    private static int PARTITION_SIZE = 16;
    private static String wp = "/home/matus/test/";

    public static void main(String[] args) {
        sort("nums.txt", "nums-sorted.txt");
    }

    private static void sort(String from, String to) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(wp + from));
            int i = 0;
            int size = 0;
            int batch = 0;
            List<Integer> buf = new ArrayList<Integer>();
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                buf.add(Integer.parseInt(line));
                size++;
                if (++i == PARTITION_SIZE) {
                    output(new PrintWriter(new BufferedWriter(new FileWriter(wp + "out" + batch))), buf);
                    batch++;
                    i = 0;
                }
            }
            if (!buf.isEmpty()) {
                output(new PrintWriter(new BufferedWriter(new FileWriter(wp + "out" + batch))), buf);
                batch++;
            }
            in.close();

            Queue<Item> q = new PriorityQueue<Item>();
            for (i = 0; i < batch; i++) {
                in = new BufferedReader(new FileReader(wp + "out" + i));
                String line = in.readLine();
                if (line != null) {
                    System.out.println(line);
                    q.add(new Item(in, Integer.parseInt(line)));
                }
            }
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(wp + "sorted.txt")));
            while (!q.isEmpty()) {
                Item item = q.poll();
                System.out.println(item);
                out.println(item.n);
                String s = item.r.readLine();
                if (s != null) {
                    q.add(new Item(item.r, Integer.parseInt(s)));
                } else {
                    item.r.close();
                }
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            // fail
        }
    }

    private static void output(PrintWriter out, List<Integer> data) {
        Collections.sort(data);
        for (Integer i : data) {
            out.println(i);
        }
        data.clear();
        out.flush();
        out.close();
    }
}

class Item implements Comparable<Item> {
    BufferedReader r;
    int n;

    Item(BufferedReader r, int n) {
        this.r = r;
        this.n = n;
    }

    public int compareTo(Item other) {
        return Integer.compare(n, other.n);
    }

    public String toString() {
        return "" + n;
    }
}
