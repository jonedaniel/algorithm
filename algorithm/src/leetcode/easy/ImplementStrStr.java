package leetcode.easy;

/**
 * Title: ImplementStrStr
 * Description:
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/3/22
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        System.out.println(
                new ImplementStrStr().strStr("a", "")
        );
    }

    public int strStr(String haystack, String needle) {
        int     len1 = haystack.length();
        int     len2 = needle.length();
        if (len2 == 0) return 0;
        boolean flag = false;
        labelA:
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (i + j >= len1) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) continue labelA;
                if (j == len2-1) flag = true;
            }
            if (flag) return i;
        }
        return -1;
    }
}
