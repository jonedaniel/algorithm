package sort;

import java.security.PublicKey;
import java.util.Arrays;
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

    int[] originalArr = new int[]{8,9,4,1,5,0};

    public static void main(String[] args) {
        Quicksort qs = new Quicksort();
        System.out.println(Arrays.toString(qs.originalArr));
        qs.quicksort(qs.originalArr, 0, qs.originalArr.length - 1);
        System.out.println(Arrays.toString(qs.originalArr));
    }

    private void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quicksort(arr, low, pivot-1);
            quicksort(arr, pivot+1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot ) ++low;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }


}
