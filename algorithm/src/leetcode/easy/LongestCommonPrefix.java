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
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"a"}));
    }

    public String longestCommonPrefix(String[] arr) {
        if (arr.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int j = 0;
        char c = ' ';
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < arr.length; i++) {
                if (j >= arr[i].length()) {
                    flag = false;
                    break;
                }
                String s    = arr[i];
                char   temp = s.charAt(j);
                if (i == 0) {
                    c = s.charAt(j);
                } else if (c != temp) {
                    return sb.toString();
                }
                if (i == arr.length - 1) {
                    sb.append(c);
                }
            }
            j++;
        }
        return sb.toString();
    }
}
