package sort;

import java.util.Arrays;

/**
 * revise sort
 *
 * @author zmh email: zmhzhaomenghui@gmail.com
 * @createDate 2018/7/27
 * @see "https://www.jianshu.com/p/8c915179fd02"
 */
public class SimpleSort {
    static int[] arr = {2, 3, 1, 2, 5, 4, 9, 7, 6, 8, 3};
    static void print() {
        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        print();
//        bubble(arr);
//        choice(arr);
//        binary(arr);
//        qsort(arr, 0, arr.length - 1);
//        shellSort(arr);
//        merge_sort_recursive(arr, new int[arr.length], 0, arr.length - 1);
        shellSort(arr);
        print();
    }


    //归并排序(from wikiPedia)
    public static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }
        System.out.println(start + ":" + end);
        int len    = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }

    //分组插入
    public static void shellSort(int[] arr) {
        int j    = 0;
        int temp = 0;
        //每次将步长缩短为原来的一半
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < arr.length; i++) {
                temp = arr[i];
                for (j = i; j >= increment; j -= increment) {
                    if (temp < arr[j - increment])//如想从小到大排只需修改这里
                    {
                        arr[j] = arr[j - increment];
                    } else {
                        break;
                    }

                }
                arr[j] = temp;
            }

        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    //快排1
    private static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot - 1);                   //递归排序左子数组
            qsort(arr, pivot + 1, high);                  //递归排序右子数组
        }
    }

    //快排2
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];     //基准
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];             //交换比基准小的记录到左端
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];           //交换比基准大的记录到右端
        }
        //扫描完成，基准到位
        arr[low] = pivot;
        //返回的是基准的位置
        return low;
    }


    private static void bubble(int[] arr) {
        print();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int m = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = m;
                }
            }
        }
        print();
    }

    private static void choice(int[] arr) {
        print();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int m = arr[i];
                    arr[i] = arr[j];
                    arr[j] = m;
                }
            }
        }
        print();
    }

    private static void binary(int[] arr) {
        print();
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int low  = 0, high = i - 1;
            int mid  = -1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (arr[mid] > temp) {
                    high = mid - 1;
                } else { // 元素相同时，也插入在后面的位置
                    low = mid + 1;
                }
            }
            if (i - low >= 0) System.arraycopy(arr, low, arr, low + 1, i - low);
            arr[low] = temp;
        }
        print();
    }
}
