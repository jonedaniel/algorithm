package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Title: FourSum
 * Description:
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/3/22
 */
public class FourSum {
    public static void main(String[] args) {
        System.out.println(
                new FourSum().fourSum(new int[]{2, -4, -5, -2, -3, -5, 0, 4, -2}, -14)
        );
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> retList = new ArrayList<>();

        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                for (int k = j + 1; k < len - 1; k++) {
                    for (int l = k + 1; l < len; l++) {
                        if ((nums[i] + nums[j] + nums[k] + nums[l]) == target) {
                            boolean flag = true;
                            for (List<Integer> list : retList) {
                                List<Integer> tempList = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                                for (Integer val : list) {
                                    int index = tempList.indexOf(val);
                                    if (index != -1)
                                        tempList.remove(index);
                                    if (tempList.size() == 0) flag = false;
                                }
                            }
                            if (flag)
                                retList.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
                        }
                    }
                }
            }
        }
        return retList;
    }
}
