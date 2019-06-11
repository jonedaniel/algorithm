package pc.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 排列组合实现
 *
 * @author zhaomh
 * @since 2019/6/11
 */
public class AllPermutation {

    public static void main(String[] args) {
        permutationString("112").forEach(System.out::println);
//        permutationInteger(new ArrayList<>(asList(1,2,3))).forEach(System.out::println);
        permutationDup("112").forEach(System.out::println);
    }

    /**
     * 字符串全排序(排列是有顺序的,组合是无序的)
     *
     * @author zhaomh
     * @since 2019/6/11
     */
    private static List<String> permutationString(String s) {
        List<String> res = new ArrayList<>();
        if(s == null) return res;

        List<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) list.add(s.charAt(i));
        permutationString(res, list, "");
        return res;
    }

    private static void permutationString(List<String> res, List<Character> list, String prefix) {
        if (list.size() == 0) res.add(prefix);
        for (int i = 0; i < list.size(); i++) {
            List<Character> temp = new LinkedList<>(list);
            Character item = temp.remove(i);
            permutationString(res, temp, prefix + item);
        }
    }

    /**
     * 数字 全排列,没有字符串方便,考虑用String代替List<Integer>
     *
     * @author zhaomh
     */
    private static List<List<Integer>> permutationInteger(List<Integer> srcList) {
        List<List<Integer>> res = new ArrayList<>();
        if (srcList.size() == 0) return null;
        permutationInteger(res, srcList, new ArrayList<>());
        return res;
    }

    private static void permutationInteger(List<List<Integer>> res, List<Integer> list, List<Integer> addedList) {
        if(list.size() == 0) res.add(addedList);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = new LinkedList<>(list);
            Integer remove = temp.remove(i);
            //每次循环需要重新创建,否则会累计,导致错误结果
            LinkedList<Integer> nextList = new LinkedList<>(addedList);
            nextList.add(remove);
            permutationInteger(res,temp,nextList);
        }
    }

    /**
     * 包含重复元素时的 全排列, 使用hashSet 存储结果解决
     *
     * @author zhaomh
     * @since 2019/6/11
     */
    private static List<String> permutationDup(String s) {
        List<String> res = new LinkedList<>();
        if(s==null || "".equals(s)) return res;

        List<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) list.add(s.charAt(i));

        permutationDup(res, list,"", new HashSet<String>());

        return res;
    }

    private static void permutationDup(List<String> res, List<Character> list, String prefix,HashSet<String> set) {
        if (list.size() == 0 && prefix.length()!=0 && !set.contains(prefix)) {
            set.add(prefix);
            res.add(prefix);
        }

        for (int i = 0; i < list.size(); i++) {
            LinkedList<Character> temp = new LinkedList<>(list);
            Character remove = temp.remove(i);
            permutationDup(res, temp, prefix + remove, set);
        }
    }
}
