package sort;

import util.ArrayUtil;

/**
 * Title: InsertSort
 * Description: 插入排序深究
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/2/13
 */
public class InsertSort {
    static int[] arr = {9, 5, 3, 2, 5, 1};

    public static void main(String[] args) {
        ArrayUtil.print(arr);
        sort(arr);
        ArrayUtil.print(arr);

        System.out.println(1/2);
    }

    /**
     * 插入排序:
     * 设置一个有序数列, 然后遍历数组,从后到前与有序数列比较,然后将该元素插入到他的位置
     *
     * @author zhaomenghui
     * @createDate 2019/2/13
     */
    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j   = i - 1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void shellSort(int[] arr) {

    }
}
