package me;

import java.util.Arrays;
import java.lang.reflect.Array;

public class MergeSort {

    static <T extends Comparable> T[] merge(Class<T> cl, T[] left, T[] right) {
        T[] re = (T[])Array.newInstance(cl, left.length + right.length);
        int i = 0;
        int j = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                re[i+j] = left[i];
                i++;
            } else {
                re[i+j] = right[j];
                j++;
            }
        }
        if (i == left.length) {
            System.arraycopy(right, j, re, i+j, right.length - j);
        } else {
            System.arraycopy(left, i, re, i+j, left.length - i);
        }
        return re;
    }

    public static <T extends Comparable> T[] sort(Class<T> cl, T[] data) {
        if (data.length <= 1) {
            return data;
        } else if (data.length == 2) {
            if (data[0].compareTo(data[1]) <= 0) {
                return data;
            } else {
                T tmp = data[0];
                data[0] = data[1];
                data[1] = tmp;
                return data;
            }
        } else {
            int mid = data.length / 2;
            return merge(cl,
                         sort(cl, Arrays.copyOfRange(data, 0, mid)),
                         sort(cl, Arrays.copyOfRange(data, mid, data.length)));
        }
    }

    static <T extends Comparable> T[] mergeInPlace(Class<T> cl, T[] data, int low, int high) {
        T[] re = (T[])Array.newInstance(cl, high - low);
        int mid = low + ((high - low) / 2);
        int i = low;
        int j = mid;
        while (i < mid && j < high) {
            if (data[i].compareTo(data[j]) <= 0) {
                re[i+j-low-mid] = data[i];
                i++;
            } else {
                re[i+j-low-mid] = data[j];
                j++;
            }
        }
        if (i == mid) {
            System.arraycopy(data, j, re, i+j-low-mid, high - j);
        } else {
            System.arraycopy(data, i, re, i+j-low-mid, mid - i);
        }
        System.arraycopy(re, 0, data, low, re.length);
        return data;
    }

    public static <T extends Comparable> T[] sortInPlace(Class<T> cl, T[] data, int low, int high) {
        if (high - low <= 1) {
            return data;
        } else if (high - low == 2) {
            if (data[low].compareTo(data[high-1]) <= 0) {
                return data;
            } else {
                T tmp = data[low];
                data[low] = data[high-1];
                data[high-1] = tmp;
                return data;
            }
        } else {
            int mid = low + ((high - low) / 2);
            sortInPlace(cl, data, low, mid);
            sortInPlace(cl, data, mid, high);
            return mergeInPlace(cl, data, low, high);
        }
    }
}
