package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author zmh
 * @date 2019/9/10
 */
public class MergeInterval {

    public static void main(String[] args) {
        int[][] src = {{2, 3}, {4, 6}, {5, 7}, {3, 4}};
        int[][] merge = new MergeInterval().merge(src);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] merge(int[][] arr) {
        if (arr == null || arr.length <= 1) { return arr; }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        int length = arr.length;
        while (i < length) {
            int left = arr[i][0];
            int right = arr[i][1];
            while (i < length - 1 && right >= arr[i + 1][0]) {
                right = Math.max(right, arr[i + 1][1]);
                i++;
            }
            list.add(new int[] {left, right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}


