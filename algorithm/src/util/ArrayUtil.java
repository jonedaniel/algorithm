package util;


import java.util.Arrays;
import java.util.Random;

public class ArrayUtil {

    public static int[] intGenerator(int length) {
        int[]  arr = new int[length];
        Random r   = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = r.nextInt(length);
        }
        return arr;
    }

    public static String toString(int[] arr) {
        int           length = arr.length;
        StringBuilder sb     = new StringBuilder(length);
        sb.append("(");
        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                sb.append(arr[i]).append(",");
            } else if (i == length - 1) {
                sb.append(arr[i]);
            }
        }
        sb.append(")");
        return new String(sb);
    }

    public static void print(int[] arr) {
        System.out.println(toString(arr));
    }
}
