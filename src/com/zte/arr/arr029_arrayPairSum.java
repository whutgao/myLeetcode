package com.zte.arr;

import java.util.Arrays;


/**
 * 数组拆分 I
 * 给定长度为2n的整数数组 nums ，你的任务是将这些数分成n 对,
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
 * 使得从 1 到n 的 min(ai, bi) 总和最大。
 * 返回该 最大总和 。
 */
public class arr029_arrayPairSum {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i+=2) {
            ans+= nums[i];
//            i++;
        }
        return ans;
    }
}
