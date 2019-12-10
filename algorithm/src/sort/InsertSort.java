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

    /**
     * 插入排序:
     * 设置一个有序数列, 然后遍历数组,从后到前与有序数列比较,然后将该元素插入到他的位置
     *
     * @author zhaomenghui
     * @createDate 2019/2/13
     */
    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void sortByFor(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else { break; }
            }
            arr[j + 1] = temp;
        }
    }

    /**
     * 希尔排序:
     * 分组插入,循环减少步长,然后对步长上的数组进行插入排序
     *
     * @author zhaomenghui
     * @createDate 2019/2/13
     */
    private static void shellSort(int[] arr) {
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - increment;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + increment] = arr[j];
                    j -= increment;
                }
                arr[j + increment] = temp;
            }
        }
    }

    private static void insertRound2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    private static void shellRound2(int[] arr) {
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < arr.length; i += increment) {
                int j = i - increment;
                int temp = arr[i];
                while (j >= 0 && arr[j] > temp) {
                    arr[j + increment] = arr[j];
                    j -= increment;
                }
                arr[j + increment] = temp;
            }
        }
    }

    private static void insertByForRound2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];
            for (; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    private static void shellRound3(int[] arr) {
        for (int step = arr.length / 2; step >= 1; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int j = i - step;
                int key = arr[i];
                while (j >= 0 && arr[j] > key) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = key;
            }
        }
    }

    private static void insertRound3(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static int[] arr = {9, 5, 3, 2, 5, 1};

    public static void main(String[] args) {
        for (int i = 10000; i < 100000; i+= 10000) {
            int[] arr = ArrayUtil.intGenerator(i);
            int[] arr1 = new int[i];
            int[] arr2 = new int[i];
            System.arraycopy(arr, 0, arr1, 0, i);
            System.arraycopy(arr, 0, arr2, 0, i);

            long start1 = System.currentTimeMillis();
            insertRound5(arr1);
            System.out.println(i + "插入: " + (System.currentTimeMillis() - start1));

            long start2 = System.currentTimeMillis();
            shellRound5(arr2);
            System.out.println( i + "希尔: " + (System.currentTimeMillis() - start2));
        }
    }

    private static void shellRound5(int[] arr) {
        for (int step = arr.length / 2; step >= 1; step /= 2) {
            for (int i = step; i < arr.length; i += step) {
                int j = i - step, temp = arr[i];
                while (j >= 0 && arr[j] >= temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }

    private static void insertRound5(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int j = i - 1;
            int temp = arr[i];
            while (j >= 0 && arr[j] >= temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    private static void shellRound4(int[] arr) {
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i += step) {
                int j = i - step, key = arr[i];
                while (j >= 0 && arr[j] > key) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = key;
            }
        }
    }

    private static void insertRound4(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1, key = arr[i];
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

}
