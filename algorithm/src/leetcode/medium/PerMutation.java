package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Title: PerMutation
 * Description:
 * <p>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/3/22
 */
public class PerMutation {
    public static void main(String[] args) {
        System.out.println(
                new PerMutation().permute(new int[]{1, 2, 3})
        );
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ll = new ArrayList<>();

        int len  = nums.length;
        int deep = 0;
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            List<Integer> indexRecord = Collections.singletonList(i);
            List<Integer> valList = Collections.singletonList(val);
            recurse(nums,indexRecord,valList,ll);
        }
        return ll;
    }

    private void recurse(int[] nums, List<Integer> indexRecord, List<Integer> valList, List<List<Integer>> ll) {
        if (valList.size() == nums.length) {
            ll.add(valList);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (valList.contains(val)) continue;
            List<Integer> nl = new ArrayList<>(valList);
            nl.add(val);
            recurse(nums,indexRecord,nl,ll);
        }
    }
}
