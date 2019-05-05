package leetcode.easy;

import javax.xml.transform.Source;
import java.util.Arrays;

/**
 * Title: RemoveElement
 * Description:
 * <p>
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/3/22
 */
public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(new RemoveElement().removeElement(new int[]{1,2,2,3,0,4,2}, 2));
    }

    public int removeElement(int[] nums, int val) {
        int len = nums.length, j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }
}
