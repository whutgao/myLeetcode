package com.zte.arr;

import java.util.Arrays;

/** 三个数的最大乘积
 *v 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 */
public class arr036_maximumProduct {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // 都是正数或者都是负数，就是最后三个相乘；
        // 存在正负,就是负的最小的两个*正的最大的一个

        return Math.max(nums[0]*nums[1]*nums[n-1],nums[n-1]*nums[n-2]*nums[n-3]);
        // 时间复杂度：O(NlogN) 排序需要 O(N\log N)O(NlogN) 的时间  空间复杂度：O(logN) 为排序的空间开销
    }
//    只要求出数组中最大的三个数以及最小的两个数，因此我们可以不用排序，用线性扫描直接得出这五个数
    private int maximumProduct1(int[] nums) {
        // 最小的和第二小的
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 最大的、第二大的和第三大的
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }

            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
