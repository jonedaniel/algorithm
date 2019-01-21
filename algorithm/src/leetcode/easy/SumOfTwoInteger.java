package leetcode.easy;

import org.junit.Test;

/**
 * Title: AddTwoInteger
 * Description:
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = -2, b = 3
 * Output: 1
 *
 * @url https://leetcode.com/problems/sum-of-two-integers/
 * @author zhaomenghui
 * @createDate 2019/1/21
 * @version 1.0
 */
public class SumOfTwoInteger {

    @Test
    public void test() {
        System.out.println(getSum(23,23));
    }

    public int getSum(int a, int b) {
        return Integer.sum(a, b);
    }

}
