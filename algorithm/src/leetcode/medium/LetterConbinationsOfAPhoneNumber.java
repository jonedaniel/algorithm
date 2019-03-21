package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title: LetterConbinationsOfAPhoneNumber
 * Description:
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/3/21
 */
public class LetterConbinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(new LetterConbinationsOfAPhoneNumber().letterCombinations("7"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> list  = new ArrayList<>();
        List<char[]> phone = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            int v = c - 48;
            if (v > 1) {
                phone.add(translateToCharArr(v));
            }
        }
        if (phone.size() == 0) return list;
        int    i     = 0;
        char[] chars = phone.get(i);
        for (char c : chars) {
            String record = Character.toString(c);
            if (i + 1 < phone.size()) {
                recurse(phone, record, list, i + 1);
            } else {
                list.add(record);
            }
        }
        return list;
    }

    private void recurse(List<char[]> phone, String record, List<String> list, int i) {
        for (int j = 0; j < phone.get(i).length; j++) {
            char   c         = phone.get(i)[j];
            String newRecord = record + c;
            if (i + 1 < phone.size()) {
                recurse(phone, newRecord, list, i + 1);
            } else {
                list.add(newRecord);
            }
        }
    }


    private char[] translateToCharArr(int v) {
        char[] chars;
        if (v < 7) {
            chars = new char[3];
            chars[0] = (char) ('a' + 3 * (v - 2));
            chars[1] = (char) (chars[0] + 1);
            chars[2] = (char) (chars[1] + 1);
        } else if (v==7){
            chars = new char[4];
            chars[0] = (char) ('a' + 3 * (v - 2));
            chars[1] = (char) (chars[0] + 1);
            chars[2] = (char) (chars[1] + 1);
            chars[3] = (char) (chars[2] + 1);
        } else if (v == 8) {
            chars = new char[3];
            chars[0] = (char) ('a' + 3 * (v - 2) + 1);
            chars[1] = (char) (chars[0] + 1);
            chars[2] = (char) (chars[1] + 1);
        } else {
            chars = new char[4];
            chars[0] = (char) ('a' + 3 * (v - 2) + 1);
            chars[1] = (char) (chars[0] + 1);
            chars[2] = (char) (chars[1] + 1);
            chars[3] = (char) (chars[2] + 1);
        }
        return chars;
    }
}
