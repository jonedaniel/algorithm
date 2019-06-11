package leetcode.medium;

import java.util.*;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 * @author zhaomh
 * @since 2019/6/10
 */
public class SubsetsII {
    public static void main(String[] args) {
        List<List<Integer>> lists = new SubsetsII().subsetsWithDup(
                new int[]{1,2,3,4,5,6,7,8,10,0}
        );
        lists.forEach(System.out::println);
    }

//    private List<List<Integer>> subsetsWithDup(int[] ints) {
//        List<List<Integer>> res = new LinkedList<>();
//        if (ints == null || ints.length == 0) return res;
//
//        List<Integer> list = new LinkedList<>();
//        for (int anInt : ints) {
//            list.add(anInt);
//        }
//
//        res.add(new LinkedList<>());
//        for (int i = 0; i < ints.length; i++) {
//            subsetsWithDup(res, list, new LinkedList<>(), i + 1, new HashSet<String>(), "");
//        }
//        return res;
//    }

//    private void subsetsWithDup(List<List<Integer>> res, List<Integer> list, List<Integer> l, int size, HashSet<String> set, String key) {
//        if (l.size() == size && !set.contains(key)) {
//            set.add(key);
//            res.add(l);
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            List<Integer> temp = new LinkedList<>(list);
//
//            Integer remove = temp.remove(i);
//            LinkedList<Integer> nl = new LinkedList<>(l);
//            nl.add(remove);
//            nl.sort(Integer::compareTo);
//            StringBuilder next = new StringBuilder();
//            if (key.length() == 0) {
//                next.append(remove);
//            } else {
//                for (Integer integer : nl) {
//                    next.append(integer);
//                }
//            }
//            subsetsWithDup(res, temp, nl, size, set, next.toString());
//        }
//
//    }


    List<List<Integer>> res=new LinkedList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length==0){
            return res;
        }
        res.add(new LinkedList());
        Arrays.sort(nums);
        recursion(new LinkedList<Integer>(),nums);
        return res;

    }

    public void recursion(LinkedList<Integer> list,int[] nums){
        if(nums==null||nums.length==0)return;
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            res.add(new LinkedList(list));
            recursion(list,Arrays.copyOfRange(nums,i+1,nums.length));
            list.removeLast();
        }
    }
}
