package sort;


import java.util.Arrays;

public class TopKSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(bubbleK(arr, 4)));
    }

    private static int[] sortFirst(int[] arr, int k) {
        int[] ans = new int[k];
        Arrays.sort(arr);
        int j = k - 1;
        for (int i = arr.length - 1; i > arr.length - 1 - k; i--) {
            ans[j--] = arr[i];
        }
        return ans;
    }

    private static int[] bubbleK(int[] arr, int k) {
        int[] ans = new int[k];
        for (int i = arr.length - 1; i > arr.length - 1 - k; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) swap(arr, i, j);
            }
        }
        System.arraycopy(arr, arr.length - k, ans, 0, k);
        return ans;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * todo:    heap sort
     */
    public static void heapSort(int[] arr) {

    }

}
