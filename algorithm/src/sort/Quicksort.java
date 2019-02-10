package sort;

import java.util.Random;

/**
 * Title: Quicksort
 * Description: 深究快排
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/2/10
 */
public class Quicksort {

    int[] originalArr = new int[]{3, 7, 8, 4, 1, 2};

    public static void main(String[] args) {
        Quicksort qs = new Quicksort();

    }

    private void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = arr[low];
        }
        return 0;
    }

}
