package com.zte.arr;

import java.util.Arrays;

/** 数组  002移除元素
//给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
//不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 **/
public class removeElement {

    public static void main(String[] args) {

        int [] arr = {3,2,2,3};
        int i = removeElement1(arr,3);
        System.out.println(i);
        System.out.println(Arrays.toString(arr));
    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right]!=val){
                nums[left]=nums[right];
                left++;
            }
        }
        return left;
    }

    public static int removeElement1(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        int right = n;
        while (left<right){
            if (nums[left]==val){
                nums[left] = nums[right-1];
                right--;
            }else {
                left++;
            }
        }

        return left;
    }
}
