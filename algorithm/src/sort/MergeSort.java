package sort;

import java.util.Arrays;

/**
 * Title: MergeSort
 * Description:
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/2/13
 */
public class MergeSort {

    static int[] oriArr = {9, 8, 7, 6, 5, 4, 3, 2, 1};

    private static void print() {
        System.out.println(Arrays.toString(oriArr));
    }

    public static void main(String[] args) {
        print();
        merge(oriArr, new int[oriArr.length], 0, oriArr.length - 1);
        print();
    }

    private static void mergeTwoArr(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;
        while (j < arr1.length && k < arr2.length)
            arr3[i++] = arr1[j] < arr2[k] ? arr1[j++] : arr2[k++];
        while (j < arr1.length)
            arr3[i++] = arr1[j++];
        while (k < arr2.length)
            arr3[i++] = arr2[k++];
        System.out.println(Arrays.toString(arr3));
    }

    private static void merge(int[] arr, int[] result, int start, int end) {
        if(start >= end) return;

        int len = end - start, mid = start + (len / 2);
        int start1 = start,start2 = mid +1;

        merge(arr, result, start1, mid);
        merge(arr,result,start2,end);
        int k = start;
        while (start1 <= mid && start2 <= end)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= mid)
            result[k++] = arr[start1++];
        while (start2 <= end)
            result[k++] = arr[start2++];

        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }
}
