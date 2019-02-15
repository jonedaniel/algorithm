package sort;

import javafx.beans.property.ReadOnlyMapProperty;

import java.awt.image.Kernel;
import java.util.Arrays;
import java.util.logging.Level;

/**
 * Title: Quicksort
 * Description: 深究快排
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/2/10
 */
public class Quicksort {

    private void quicksort(int[] arr, int low, int high) {
        if (low < high) {
//            int pivot = partition1(arr, low, high);
//            int pivot = partition2(arr, low, high);
            int pivot = partitionSelf1(arr, low, high);

            quicksort(arr, low, pivot - 1);
            quicksort(arr, pivot + 1, high);
        }
    }

    private int partition2(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    private int partition1(int[] arr, int start, int end) {
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
        return start;
    }

    private void quicksortMiddle(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) return;
        if (high < low) return;

        int middle = low + (high - low) / 2;
        int pivot  = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) quicksortMiddle(arr, low, j);
        if (high > i) quicksortMiddle(arr, i, high);
    }

    /**
     * 基准取尾:
     * core point:
     * while(low < high && arr[low] <= pivot) ++low;
     * 当low的值小于pivot就累加low,直到遇到一个low大于pivot.则这个low,应该被放到右边,arr[high] = arr[low],
     * 此时数组中存在两个arr[low],而第一个arr[high]值即是我们的pivot.
     * 然后 while(low < high && arr[high] >= pivot) --high;由之前的操作可以确定,第一个high必>pivot,于是--high,
     * 然后遇到一个arr[high] < pivot 时,这个应该被放到左边. 既是那个存在两个的,被赋值给arr[high+1]的arr[low] = arr[high]
     * 然后判断 while(low < high) 进行下一次循环.
     * 相当于从两边依次对比pivot,然后移动交换值. 当low = high时,此时的high或low即是我们pivot 的position. 返回,再进行迭代此过程
     *
     * @author zhaomenghui
     * @createDate 2019/2/12
     */
    private int partitionSelf1(int[] arr, int low, int high) {
        int pivot = arr[high];

        while (low < high) {
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];
        }
        arr[high] = pivot;
        return high;
    }


    /**
     * 基准取中:
     * 取low与high的index作为middle,arr[middle] 为基准值.
     * while(i<=j) while(arr[i]<pivot) ++i;获取到第一个大于基准值的位置i;
     * while(arr[j]>pivot)--j;获取到第一个小于基准值的位置j;
     * 如果i <= j. 交换这两个值,然后++i,--j; 继续循环.
     * <p>
     * 使用 <= ,i<=j 是为了让j作为 左半部分去递归
     *
     * @createDate 2019/2/12
     */
    private void quicksortSelf(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || high < low) return;

        int midlle = low + (high - low) / 2;
        int pivot  = arr[midlle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) ++i;
            while (arr[j] > pivot) --j;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                ++i;
                --j;
            }
        }
        if (low < j) quicksortSelf(arr, low, j);
        if (high > i) quicksortSelf(arr, i, high);
    }

    private void quickSortWithTailRound2(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || high < low) return;
        int temp  = arr[high];
        int start = low, end = high;
        while (low < high) {
            while (low < high && arr[low] <= temp) ++low;
            arr[high] = arr[low];
            while (low < high && arr[high] >= temp) --high;
            arr[low] = arr[high];
        }
        arr[high] = temp;

        quickSortWithTailRound2(arr, start, high - 1);
        quickSortWithTailRound2(arr, high + 1, end);
    }

    private void quicksortWithMiddleRound2(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || high < low) return;

        int mid   = low + (high - low) / 2;
        int pivot = arr[mid];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) ++i;
            while (arr[j] > pivot) --j;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                ++i;
                --j;
            }
        }
        if (low < j) quicksortWithMiddleRound2(arr, low, j);
        if (high > i) quicksortWithMiddleRound2(arr, i, high);
    }

    private void quicksortWithMiddleRound3(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || high < low) return;

        int middle = low + (high - low) / 2;
        int pivot  = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) ++i;
            while (arr[j] > pivot) --j;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                ++i;
                --j;
            }
        }

        if (low < j) quicksortWithMiddleRound3(arr, low, j);
        if (high > i) quicksortWithMiddleRound3(arr, i, high);
    }

    private void quicksortWithTailRound3(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || high < low) return;
        int pivot = arr[high];

        int start = low, end = high;
        while (low < high) {
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];
        }
        arr[high] = pivot;

        quicksortWithTailRound3(arr, start, high - 1);
        quicksortWithTailRound3(arr, pivot + 1, end);
    }

    private void quicksortWithMiddleRound4(int[] arr, int low, int high) {
        if (high < low) return;
        int mid   = low + ((high - low) / 2);
        int pivot = arr[mid];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] <pivot) ++i;
            while (arr[j] >pivot) --j;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                ++i;
                --j;
            }
        }
        if (low < j) quicksortWithMiddleRound4(arr, low, j);
        if (high>i) quicksortWithMiddleRound4(arr, i, high);
    }

    public static void main(String[] args) {
        Quicksort qs = new Quicksort();
        System.out.println(Arrays.toString(originalArr));
//        qs.quicksort(originalArr, 0, originalArr.length - 1);
//        qs.quicksortSelf(originalArr, 0, originalArr.length - 1);
//        qs.quickSortWithTailRound2(originalArr, 0, originalArr.length - 1);
//        qs.quicksortWithMiddleRound2(originalArr, 0, originalArr.length - 1);
//        qs.quicksortWithTailRound3(originalArr, 0, originalArr.length - 1);
//        qs.quicksortWithMiddleRound3(originalArr, 0, originalArr.length - 1);
//        qs.quicksortWithMiddleRound4(originalArr, 0, originalArr.length - 1);
        qs.quicksortWithTailRound4(originalArr, 0, originalArr.length - 1);

        System.out.println(Arrays.toString(originalArr));
    }

    private void quicksortWithTailRound4(int[] arr, int low, int high) {
        if(high < low )return;
        int pivot = arr[high];

        int start = low, end = high;
        while (low < high) {
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];
        }
        arr[high] = pivot;
        quicksortWithTailRound4(arr, start, high - 1);
        quicksortWithTailRound4(arr, high + 1, end);
    }

    static int[] originalArr = new int[]{9, 8, 7, 6, 1, 4, 3, 2, 5};


}
