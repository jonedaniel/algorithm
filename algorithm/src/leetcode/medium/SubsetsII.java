package leetcode.medium;

import java.util.*;

import static java.util.Arrays.asList;

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
//        List<List<Integer>> lists = new SubsetsII().subsetsWithDup(
//                new int[]{1, 2, 3}
//        );
        new SubsetsII().getEleArr(new int[]{1, 2, 3, 4}, 2).forEach(System.out::println);
//        lists.forEach(System.out::println);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        List<Integer> oriArr = new ArrayList<Integer>();
        for (int num : nums) {
            oriArr.add(num);
        }

        retList.add(new ArrayList<>());
        if (oriArr.size() > 0) {
            retList.add(oriArr);
        }


        int length = nums.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j < length; j++) {
                for (int k = 0; k < length - j + 1; k++) {

                }
            }
        }

//        retList.addAll(map.values());
        return retList;
    }

//    public void removeDup(List<Integer> oriArr) {
//        Map<String, List<Integer>> map = new HashMap<>();
//
//        List<Integer> list = oriArr.subList(k, k + j);
//        list.sort(Integer::compareTo);
//        StringBuilder sb = new StringBuilder();
//        for (int n = 0; n < list.size(); n++) {
//            if (n == 0) {
//                sb.append(list.get(n));
//            } else {
//                sb.append("-").append(list.get(n));
//            }
//        }
//        map.put(sb.toString(), list);
//    }

    public List<List<Integer>> getEleArr(int[] arr, int times) {
        List<List<Integer>> retList = new ArrayList<>();
        List<Integer> oriArr = new ArrayList<Integer>();
        for (int num : arr) {
            oriArr.add(num);
        }
        getTimesEleArr(retList, oriArr, 0,times);
        return retList;
    }

    private void getTimesEleArr(List<List<Integer>> retList, List<Integer> oriArr, int start,int times) {
        if (times <=0 ) return;
        List<List<Integer>> tempList = new ArrayList<>();
        for (int i = start; i < oriArr.size(); i++) {
            Integer integer = oriArr.get(i);
            if (retList.size() > 0) {
                for (List<Integer> list : retList) {
                    List<Integer> arrayList = new ArrayList<>(list);
                    arrayList.add(integer);
                    tempList.add(arrayList);
                }
            } else {
                tempList.add(Collections.singletonList(integer));
            }
        }
        retList = tempList;
        getTimesEleArr(retList,oriArr,++start,--times);
    }

}
