package leetcode.medium;

import com.sun.org.apache.regexp.internal.RE;
import sun.text.resources.cldr.lag.FormatData_lag;

import java.util.ArrayList;
import java.util.Arrays;
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
                new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8)
        );
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rl   = new ArrayList<>();
        List<Integer>       list = new ArrayList<>();
        for (int candidate : candidates) list.add(candidate);
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) return rl;
            int remain = target % candidates[i];
            int times  = target / candidates[i];
            if ((list.contains(remain)) || remain == 0) {
                List<Integer> aim = new ArrayList<>();
                for (int j = 0; j < times; j++)
                    aim.add(candidates[i]);
                if (remain != 0) aim.add(remain);
                aim.sort(Integer::compareTo);
                boolean flag = true;
                for (List<Integer> il : rl) {
                    if (il.size() != aim.size()) continue;
                    boolean sameObj = true;
                    for (int j = 0; j < il.size(); j++){
                        if (!il.get(j).equals(aim.get(j))) {
                            sameObj = false;
                        }
                    }
                    if (sameObj) {flag = false;break;}
                }
                if (flag) rl.add(aim);
            }
            for (int j = i; j < candidates.length; j++) {
                for (int k = times - 1; k > 0; k--) {
                    if ((candidates[j] != candidates[i]) && (candidates[j] + candidates[i] * k) == target) {
                        List<Integer> la = new ArrayList<>();
                        for (int l = 0; l < k; l++)
                            la.add(candidates[i]);
                        la.add(candidates[j]);
                        rl.add(la);
                    }
                }
            }
        }
        return rl;
    }
}
