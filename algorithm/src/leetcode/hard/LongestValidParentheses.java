package leetcode.hard;

import java.util.*;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
    }

    /**
     * copy, not understand
     *
     * @author zhaomenghui
     * @createDate 2019/2/16
     */
    public int longestValidParentheses(String s) {
        int len = s.length(), index = 0, maxLen = 0;

        Stack st = new Stack();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') st.push(i);
            else if (st.size() == 0) {
                index = i + 1;
            } else {
                st.pop();
                if (st.empty()) {
                    maxLen = Math.max(maxLen, i - index + 1);
                } else {
                    maxLen = Math.max(maxLen, i - (int) st.peek());
                }
            }
        }

        return maxLen;
    }
}
