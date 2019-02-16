package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().judge(121));
    }

    private boolean judge(long x) {
        if(x < 0) return false;
        List<Long> list = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();
        while (x > 0) {
            list.add(x % 10);
            list2.add(x % 10);
            x /= 10;
        }
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
