package leetcode.medium;

import java.util.*;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * @author zhaomh
 */
public class CombinationSumII {

    public static void main(String[] args) {
        CombinationSumII sumII = new CombinationSumII();
        long millis = System.currentTimeMillis();
        List<List<Integer>> listList = sumII.combinationSum2(new int[]{23, 16, 5, 28, 20, 17, 27, 20, 12, 21, 12, 29, 12, 20, 22, 32, 7, 26, 20, 30, 28, 17, 7, 26, 5, 24, 20, 27, 5, 8, 9, 15, 19, 31, 9, 5, 13, 31, 12, 20, 10, 11, 6, 17, 27, 16, 7, 21, 7, 22, 16, 30, 26, 10, 21, 27, 29, 28, 11, 21}, 27);
        System.out.println("花费毫秒:" + (System.currentTimeMillis() - millis));
        for (List<Integer> list : listList) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Set<String> addedNums = new HashSet<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> ans = new ArrayList<>();
            int sum = 0;
            for (Integer an : ans) {
                sum += an;
            }
            int candidate = candidates[i];
            ans.add(candidate);
            if (sum + candidate == target) {
                if (!addedNums.contains(String.valueOf(candidate))) {
                    addedNums.add(String.valueOf(candidate));
                    resultList.add(ans);
                    continue;
                }
            }
            combinationSum2(candidates,i+1, target, Collections.singletonList(i), ans, resultList, addedNums);
        }
        return resultList;
    }

    private void combinationSum2(int[] candidates,int start, int target, List<Integer> passed, List<Integer> ans, List<List<Integer>> resultList, Set<String> addedNums) {
        for (int i = start; i < candidates.length; i++) {
            if (passed.contains(i)) {
                continue;
            }
            List<Integer> ans2 = new ArrayList<>(ans);
            int sum = 0;
            for (Integer an : ans2) {
                sum += an;
            }
            int candidate = candidates[i];
            ans2.add(candidate);
            if (sum + candidate == target) {
                StringBuilder sb = new StringBuilder();
                for (Integer an : ans2) {
                    sb.append(an);
                }
                if (!addedNums.contains(sb.toString())) {
                    addedNums.add(sb.toString());
                    resultList.add(ans2);
                }
            } else if (sum + candidate < target) {
                passed = new ArrayList<>(passed);
                passed.add(i);
                combinationSum2(candidates,i+1, target, passed, ans2, resultList, addedNums);
            }
        }
    }
}
