package leetcode.easy;

/**
 * Title: ValidParentheses
 * Description:
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * @author zhaomenghui
 * @createDate 2019/3/21
 * @version 1.0
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("([)]"));
    }
    public boolean isValid(String s) {
        String[] strings = {"()", "{}", "[]"};
        boolean flag = true;
        int size = s.length();
        while (flag) {
            for (String string : strings) {
                s = s.replace(string, "");
            }
            if (s.length() == size) {
                flag = false;
            }
            size = s.length();
        }
        return size == 0;
    }
}
