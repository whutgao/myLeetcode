package com.zte.arr;

/**
 * 最大连续 1 的个数
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 */
public class arr025_findMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count=0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i]==1){
                len++;
            }else {
                count=Math.max(count,len);
                len = 0;
            }
        }
        if (len!=0){
            count = Math.max(count,len);
        }

        return count;

        // 时间复杂度：O(n) 空间复杂度：O(1)

    }
}
