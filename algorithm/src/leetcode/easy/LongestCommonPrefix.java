package leetcode.easy;

import search.Count1;

/**
 * Title: LongestCommonPrefix
 * Description:
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/3/18
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String[] arr) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while (arr[i].length() >= j + 1) {
            for (int           i  = 0; i < arr.length; i++) {
                char c = arr[i].charAt(j);
                if (sb.length() < j + 1) {
                    sb.append(c);
                } else {
                    char c2 = sb.charAt(j);
                    if (c2 != c) {
                        sb.deleteCharAt(j);
                        return sb.toString();
                    }
                }
            }
            j++;
        }
        return sb.toString();
    }
}
