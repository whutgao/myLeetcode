package com.zte.arr;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 思考： 暴力解法 for循环*for循环 复杂度是n方；
 *       如果用hashset可以保证是线性，但是需要额外空间；
 *       那么如何使线性+不使用额外空间
 *
 *       异或 ：相同数异或为0 0
 *             0 异或 任意一个数为 本身
 *             异或存在交换律
 *
 *
 */
public class arr010_singleNumber {

    public int singleNumber(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        int n = nums.length;
        int left = 0;
        int right = 0;
        // 从left开始遍历，right依次从0开始遍历
        while(right<n){
            if (nums[left]==nums[right]&& left!=right){
                left++;
                right = 0;
            }else {
                right = right+1;
            }
        }
        return nums[left];
    }


    public int singleNumber1(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n = n ^ nums[i];
        }
        return n;
    }




}
