package sort;

import java.util.Arrays;

public class ChoiceSort {
    static int[] arr = {9, 6, 5, 4, 7,3, 2, 1};

    static void print() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        print();
        ChoiceSort sort = new ChoiceSort();
        sort.sort1(arr);
        print();
    }

    private void sort1(int[] arr) {
        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
