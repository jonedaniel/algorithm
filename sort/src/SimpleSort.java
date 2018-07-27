import java.util.Arrays;

public class SimpleSort {
    static int[] arr = {2, 3, 1, 2, 5, 4, 9, 7, 6};

    public static void main(String[] args) {
//        bubble();
//        choice();
        binary();
    }

    static void print() {
        System.out.println(Arrays.toString(arr));

    }

    private static void bubble() {
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

    private static void choice() {
        print();
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i]>arr[j]) {
                    int m = arr[i];
                    arr[i] = arr[j];
                    arr[j] = m;
                }
            }
        }
        print();
    }

    private static void binary() {
        print();
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int low = 0, high = i - 1;
            int mid = -1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (arr[mid] > temp) {
                    high = mid - 1;
                } else { // 元素相同时，也插入在后面的位置
                    low = mid + 1;
                }
            }
            for(int j = i - 1; j >= low; j--) {
                arr[j + 1] = arr[j];
            }
            arr[low] = temp;
        }
        print();
    }
}
