package sort;

import java.util.Arrays;
/**
 * Title: ChoiceSort
 * Description: n^2
 *
 * @author zhaomenghui93@163.com
 * @createDate 2019/2/13
 */
public class ChoiceSort {
    static int[] arr = {9, 6, 5, 4, 7, 3, 2, 1};

    static void print() {
        System.out.println(Arrays.toString(arr));
    }

    private void sort1(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        print();
        ChoiceSort sort = new ChoiceSort();
        sort.sort2(arr);
        print();
    }

    private void sort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
