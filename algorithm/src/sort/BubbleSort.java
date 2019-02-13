package sort;

import java.util.Arrays;

/**
 * Title: BubbleSort
 * Description: 冒泡深究
 *
 * @author zhaomenghui93@163.com
 * @createDate 2019/2/12
 */
public class BubbleSort {
    static int[] arr = {9, 6, 5, 4, 7, 3, 2, 1};

    static void print() {
        System.out.println(Arrays.toString(arr));
    }

    private void sort1(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        print();
        BubbleSort sort = new BubbleSort();
        sort.sort2(arr);
        print();
    }

    private void sort2(int[] arr) {
        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
