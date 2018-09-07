import util.ArrayUtil;

/**
 * Title: SelfTest
 * Description: 熟练排序
 *
 * @author zhaomenghui93@163.com
 * @createDate 2018/8/25
 */
public class SelfTest {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.intGenerator(100);
//        int[] arr = {4, 3, 2, 1};
        ArrayUtil.print(arr);
//        ArrayUtil.print(bubble(arr));
//        ArrayUtil.print(choice(arr));
        ArrayUtil.print(tempMethod(arr));
//        binaryTest(bubble(arr),15);
//        ArrayUtil.print(insert(arr));
    }


    public static int[] tempMethod(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }


    public static int[] insert(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

    public static void binaryTest(int[] arrtest, int aim) {
        int ret = binarySearch(arrtest, aim, 0, arrtest.length);
        System.out.println(ret >= 0 ? ret + ":" + arrtest[ret] : "不存在目标值");
    }

    private static int binarySearch(int[] arr, int aim, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (arr[mid] == aim) {
            return mid;
        } else if (arr[mid] > aim) {
            return binarySearch(arr, aim, start, mid - 1);
        } else if (arr[mid] < aim) {
            return binarySearch(arr, aim, mid + 1, end);
        }
        return -2;
    }

    /**
     * unstable choice sort
     *
     * @createDate 2018/8/25
     */
    public static int[] choice(int[] arr) {
        int len = arr.length, min, temp, i, j;
        for (i = 0; i < len - 1; i++) {
            min = i;
            for (j = i + 1; j < len; j++)
                if (arr[min] > arr[j]) {
                    min = j;
                }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
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
