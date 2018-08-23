import util.ArrayUtil;

public class SelfTest {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.intGenerator(20);
        ArrayUtil.print(arr);
//        ArrayUtil.print(bubble(arr));
        ArrayUtil.print(choice(arr));
    }

    public static int[] choice(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int swap = arr[i];
                    arr[i]=arr[j];
                    arr[j] = swap;
                }
            }
        }
        return arr;
    }

    public static int[] bubble(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int mid = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = mid;
                }
            }
        }
        return arr;
    }
}
