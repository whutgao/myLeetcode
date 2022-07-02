package com.zte.arr;

/**
 * 子数组最大平均数 I
 * <p>
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5次 的答案都将被视为正确答案。
 */
public class arr037_findMaxAverage {

    public static void main(String[] args) {
        int[] nums = {5};
        int k = 1;
        double maxAverage = findMaxAverage(nums, k);
        System.out.println(maxAverage);
    }

    public static double findMaxAverage(int[] nums, int k) {
        // 对的，但是会超出时间限制
        int sumN = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i <= nums.length - k) {
                int sum = 0;
                int count = 0;
                // 这里可以减去上一个，再加前一个，但是需要先计算出来第一个k和，优化
                while (count < k) {
                    sum += nums[i + count];
                    count++;
                }
                sumN = Math.max(sumN, sum);
            }
        }


        return (double) sumN / (double) k;
    }


    // 修改
    public static double findMaxAverage1(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }

}
