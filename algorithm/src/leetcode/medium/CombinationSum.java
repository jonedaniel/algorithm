package leetcode.medium;

import com.sun.org.apache.regexp.internal.RE;
import search.Count1;
import sun.text.resources.cldr.lag.FormatData_lag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Title: CombinationSum
 * Description:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明:
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/3/22
 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(
                new CombinationSum().combinationSum(new int[]{1}, 2)
        );
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rl = new ArrayList<>();

        int len   = candidates.length, i = 0;
        int times = target / candidates[i];
        List<Integer> list = new ArrayList<>();
        rootLoop:
        for (int j = 0; j <= times; j++) {

            int sum        = 0;
            for (Integer integer : list) sum += integer;
            int tempTarget = candidates[i];
            if (j > 0) {
                sum += tempTarget;
                list.add(candidates[i]);
            }
            if (sum > target) continue;
            if (sum < target) {
                recurse(candidates, i + 1, target, new ArrayList<>(list), rl);
            } else if (sum == target) {
                for (List<Integer> integerList : rl) {
                    List<Integer> inspectList = new ArrayList<>(integerList);
                    list.forEach(inspectList::remove);
                    if (inspectList.size() == 0) continue rootLoop;
                }
                rl.add(list);
            }
        }
        return rl;
    }

    private void recurse(int[] candidates, int i, int target, List<Integer> list, List<List<Integer>> rl) {
        int len = candidates.length;
        if (i >= len) return;
        int times = target / candidates[i];
        rootLoop:
        for (int j = 0; j <= times; j++) {
            if (list == null) list = new ArrayList<>();
            int sum = 0;
            for (Integer integer : list) sum += integer;
            int tempTarget = candidates[i];
            if (j > 0) {
                sum += tempTarget;
                list.add(candidates[i]);
            }
            if (sum > target) continue;
            if (sum < target) {
                recurse(candidates, i + 1, target, new ArrayList<>(list), rl);
            } else {
                for (List<Integer> integerList : rl) {
                    List<Integer> inspectList = new ArrayList<>(integerList);
                    list.forEach(inspectList::remove);
                    if (inspectList.size() == 0) continue rootLoop;
                }
                rl.add(new ArrayList<>(list));
            }
        }
    }

}
