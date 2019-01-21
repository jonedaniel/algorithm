package leetcode.medium;

import org.junit.Test;

import java.rmi.MarshalledObject;
import java.util.*;

/**
 * Title: FindKPairsWithSmallestSums
 * Description
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 *
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 *              [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence:
 *              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 *
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 * @url https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * @author zhaomenghui
 * @createDate 2019/1/21
 * @version 1.0
 */
public class FindKPairsWithSmallestSums {

    @Test
    public void test() {

    }


    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> retList = new ArrayList<>();
        for (int i : nums1) {
            for (int j : nums2) {
                retList.add(new int[]{i, j});
            }
        }
        retList.sort(Comparator.comparingInt((x)->{
            int sum = 0;
            for (int i : x) {
                sum += i;
            }
            return sum;
        }));
        return k > retList.size()? retList:retList.subList(0,k);
    }


}
