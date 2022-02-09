package com.zte.arr;

/**
 *
 * 数组 004最大子数组和
 * 给你一个整数数组 nums ，找出一个具有最大和的连续子数组
 * （子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 */
public class arr004_maxSubArray {
    // dp 动态规划的题，这个子数组是连续的，可以判断前边几个num的和与当前num值的大小
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
          dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
          max = Math.max(max,dp[i]);
        }
        return max;
    }
}
