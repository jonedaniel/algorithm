package sort;

import java.util.Arrays;

/**
 * Title: Quicksort
 * Description: 深究快排
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/2/10
 */
public class Quicksort {


    public static void main(String[] args) {
        Quicksort qs = new Quicksort();
        System.out.println(Arrays.toString(originalArr));
        qs.quicksortMiddle(originalArr, 0, originalArr.length - 1);
        System.out.println(Arrays.toString(originalArr));
    }

    private void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quicksort(arr, low, pivot - 1);
            quicksort(arr, pivot + 1, high);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
        }

        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        System.out.println(Arrays.toString(originalArr));
        return start;
    }

    private void quicksortMiddle(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) return;
        if(high < low) return;

        int middle = low + (high-low)/2;
        int pivot = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while(arr[i] < pivot)i++;
            while (arr[j]>pivot)j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if(low < j) quicksortMiddle(arr,low,j);
        if(high > i) quicksortMiddle(arr,i,high);
    }

    static int[] originalArr = new int[]{8, 9, 4, 1, 5, 0};

}
