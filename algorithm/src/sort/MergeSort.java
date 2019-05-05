package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

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
        if (start >= end) return;

        int len = end - start, mid = start + (len / 2);
        int start1 = start, start2 = mid + 1;

        merge(arr, result, start1, mid);
        merge(arr, result, start2, end);
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

    private static void mergeRound2(int[] arr, int[] result, int start, int end) {
        if (arr == null || arr.length == 0 || start >= end) return;

        int len = end - start, mid = start + (len / 2);
        int start1 = start, start2 = mid + 1;
        mergeRound2(arr, result, start, mid);
        mergeRound2(arr, result, start2, end);

        int k = start;
        while (start1 <= mid && start2 <= end) result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= mid) result[k++] = arr[start1++];
        while (start2 <= end) result[k++] = arr[start2++];


        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }
    }

    private static void mergeRound3(int[] arr, int[] result, int low, int high) {
        if (high <= low) return;

        int len = high - low, mid = low + len / 2, start1 = low, start2 = mid + 1;

        mergeRound3(arr, result, start1, mid);
        mergeRound3(arr, result, start2, high);
        int k = low;
        while (start1 <= mid && start2 <= high) result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= mid) result[k++] = arr[start1++];
        while (start2 <= high) result[k++] = arr[start2++];

        for (k = low; k <= high; k++) arr[k] = result[k];
    }

    private static void mergeListVersion(List<Integer> list, int[] result, int low, int high) {
        if (high <= low) return;
        int len = high - low, mid = low + len / 2, start1 = low, start2 = mid + 1;
        mergeListVersion(list, result, start1, mid);
        mergeListVersion(list, result, start2, high);

        int k = low;
        while (start1 <= mid && start2 <= high)
            result[k++] = (list.get(start1) < list.get(start2) ? list.get(start1++) : list.get(start2++));
        while (start1 <= mid)
            result[k++] = (list.get(start1++));
        while (start2 <= high)
            result[k++] = (list.get(start2++));

        for (k = low; k <= high; k++) list.set(k, result[k]);

    }

    static void mergeTwoList() {
        List<Integer> listToMerge1 = new ArrayList<>(asList(9, 7, 5, 3, 1));
        List<Integer> listToMerge2 = new ArrayList<>(asList(8, 6, 4, 2, 0));
        // 输入的两个list假设有序
        listToMerge1.sort(Integer::compareTo);
        listToMerge2.sort(Integer::compareTo);
        System.out.println(listToMerge1 + " : " + listToMerge2);
        List<Integer> resultList = mergeTwoList(listToMerge1, listToMerge2);
        System.out.println(resultList);
    }

    private static List<Integer> mergeTwoList(List<Integer> listToMerge1, List<Integer> listToMerge2) {
        int size1 = listToMerge1.size();
        int size2 = listToMerge2.size();
        List<Integer> resultList = new ArrayList<>(size1 + size2);
        int j=0,k=0;
        while (j < size1 && k < size2)
            resultList.add(listToMerge1.get(j) < listToMerge2.get(k) ? listToMerge1.get(j++) : listToMerge2.get(k++));
        while( j < size1)
            resultList.add(listToMerge1.get(j++));
        while(k < size2)
            resultList.add(listToMerge2.get(k++));
        return resultList;
    }

    public static void main(String[] args) {
        mergeTwoList();
    }
}
