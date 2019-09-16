package pc.combination;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 获取所有组合结果
 *
 * @author zhaomh
 * @since 2019/6/11
 */
public class CombinationBasic {
    public static void main(String[] args) {
        pStr("122");
    }

    public static int count = 0;

    public static void pStr(String s) {
        if (s == null || "".equals(s)) { return; }

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) { pStr(list, "", i + 1, new HashSet<String>()); }
        //        pStr(list,"",1,new HashSet<String>());
    }

    private static void pStr(List<Character> list, String prefix, int size, HashSet<String> dup) {
        if (prefix.length() == size && !dup.contains(prefix)) {
            dup.add(prefix);
            System.out.println(++count + ":" + prefix);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            List<Character> temp = new LinkedList<>(list);
            Character remove = temp.remove(i);

            StringBuilder next = new StringBuilder();
            if (prefix.length() == 0) {
                next.append(remove);
            }
            boolean added = false;
            for (int j = 0; j < prefix.length(); j++) {
                if (prefix.charAt(j) < remove || added) {
                    next.append(prefix.charAt(j));
                } else {
                    next.append(remove).append(prefix.charAt(j));
                    added = true;
                }
            }
            pStr(temp, next.toString(), size, dup);
        }
    }
}
