package com.zte.arr;

/**
 *
 *  数组  003搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class arr003_searchInsert {

    public int searchInsert(int[] nums, int target) {
        /*因为要求时间复杂度为O(log n) 使用二分法
         * 思路：
         * 首先从数组的中间元素开始搜索，如果该元素正好是目标元素，则结束，否则下一步
         * 如果目标元素大于/小于中间元素，则在数组大于/小于中间元素的一半区域查找，然后重复步骤
         * mid = (right + left) / 2;
         * 如果 left 和 right 都很大，有的编程语言会有整数溢出的情况（例如 C++，Java），
         * 那么可以用 mid = left + (right - left) / 2 代替前者
         */
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int ans=nums.length;
        while (left <= right) {
//            mid  = left + ((right-left)>>1);
//            mid = left + (right-left)/2;
            mid = (left + right) / 2;
            if (target<=nums[mid]){
                ans = mid;
                right=mid-1;
            }else {
                left = mid+1;
            }
        }
        return ans;

    }
}
