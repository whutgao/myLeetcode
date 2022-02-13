package com.zte.arr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；
 * 如果数组中每个元素互不相同，返回 false 。
 *
 * 思路：1.可以遍历 双指针
 *      2. 可以利用set 或者map
 *      3. 有没有什么巧妙的呢？
 *
 */
public class arr012_containsDuplicate {
    /**
     * 时间复杂度高
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        if (nums.length==0||nums.length==1){
            return false;
        }
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    //set
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n:nums
             ) {
            if (set.contains(n)){
                return true;
            }else {
                set.add(n);
            }
        }
        return false;
    }
    // 对排序后的数组，找重复元素
    public boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=1;
        while (j<nums.length){
            if (nums[i]==nums[j]){
                return true;
            }else {
                i++;
                j++;
            }
        }
        return false;

    }
}
