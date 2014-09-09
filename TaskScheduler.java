import java.util.*;

public class TaskScheduler {

    public TaskScheduler() {}

    public static void main(String[] args) {
        System.out.println(search(new int[]{8,16,8,30}, new int[]{18,4,8,4,6,6,8,8}));
        System.out.println(search(new int[]{1,3}, new int[]{4}));
    }


    public static boolean search(int[] machines, int[] tasks) {
        int[] re = doSearch(machines, tasks, new int[tasks.length], 0);
        if (re != null) {
            System.out.println(Arrays.toString(re));
            return true;
        }
        return false;
    }

    private static int[] doSearch(int[] machines, int[] tasks, int[] assignment, int ct) {
        if (ct == tasks.length) return assignment;
        for (int j = 0; j < machines.length; j++) {
            if (machines[j] >= tasks[ct]) {
                machines[j] -= tasks[ct];
                assignment[ct] = j;
                int[] re = doSearch(machines, tasks, assignment, ct + 1);
                machines[j] += tasks[ct];
                if (re != null) {
                    return re;
                }
            }
        }
        return null;
    }
}
