package com.zte.arr;

import java.util.Arrays;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 思路：
 *      重点在：保持相对顺序，
 *
 */
public class arr016_moveZeroes {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    private static void moveZeroes(int[] nums){
        // 表示0的个数
        int count=0;
        for (int j = 0; j < nums.length; j++) {
            // 等于0的时候，统计count
            if (nums[j]==0){
                count++;
            }else {
                // 前边count=0，表示不用交换位置
                // count!=0,表示需要交换位置
                if (count!=0){
                    nums[j-count] = nums[j];
                    nums[j] = 0;
                }
            }
        }
    }
}
