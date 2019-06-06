package leetcode.medium;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * @author zhaomh
 */
public class _3sum_closest {
    public static void main(String[] args) {
        System.out.println(new _3sum_closest().threeSumClosest(
                new int[]{-1, 2, 1, -4}, 1
        ));
    }

    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        int ans = -9999999;
        int min = 999999;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    int sum3 = nums[i] + nums[j] + nums[k];
                    int interval = Math.abs(sum3 - target);
                    if (interval < min) {
                        min = interval;
                        ans = sum3;
                    }
                }
            }

        }
        return ans;
    }
}
