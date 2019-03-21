package leetcode.easy;

import search.Count1;

/**
 * Title: RemoveDuplicatesFromSortedArray
 * Description:
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * *************************************************************************************************
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/3/21
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedArray()
                .removeDuplicates(new int[]{1, 1, 2, 2, 3, 4, 4}));
    }

    /**
     * todo 抄的,真的强
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int j = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
