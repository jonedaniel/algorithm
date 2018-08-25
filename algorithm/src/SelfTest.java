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
        ArrayUtil.print(arr);
//        ArrayUtil.print(bubble(arr));
//        binaryTest(bubble(arr),15);
    }





    public static void binaryTest(int[] arrtest,int aim) {
        int   ret     = binarySearch(arrtest, aim, 0, arrtest.length);
        System.out.println(ret >=0 ?ret + ":" + arrtest[ret]:"不存在目标值");
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

    public static int[] choice(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int swap = arr[i];
                    arr[i] = arr[j];
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
