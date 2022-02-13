package com.zte.arr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 存在重复元素 II
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个不同的索引i和j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 */
public class arr013_containsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(n)) {
                int val = map.get(n);
                if (Math.abs(i - val) <= k) {
                    return true;
                } else {
                    map.put(n, i);
                }
            } else {
                map.put(n, i);
            }
        }
        return false;

    }

    /**
     * 滑动窗口
     * 始终保持一个个数为 k的set
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * for 循环来做
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length && j<= i+k ; j++) {
                if (nums[i]==nums[j]){
                    return true;
                }
            }
        }

        return false;
    }



}
