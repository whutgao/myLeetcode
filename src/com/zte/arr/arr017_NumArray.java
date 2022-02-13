package com.zte.arr;

/**
 * 区域和检索 - 数组不可变
 * 给定一个整数数组 nums，处理以下类型的多个查询:
 * 计算索引left和right（包含 left 和 right）之间的 nums 元素的和，其中left <= right
 *
 * 实现 NumArray 类：
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums中索引left和right之间的元素的 总和 ，
 * 包含left和right两点（也就是nums[left] + nums[left + 1] + ... + nums[right])
 *
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 */
public class arr017_NumArray {
    int[] sums;
    // 维护一个sum数组，每次sumRange时直接取值，如果重新算就可能会算之前的导致时间复杂度过高
    public arr017_NumArray(int[] nums) {
        //考虑[1,right]时，需要减去nums[-1]不合理，因此把sum[]长度定为n+1
        sums = new int[nums.length+1];
        sums[0] = 0;
        // 此时的i的sum时前i-1个和的值sum(i-1)与第i个值num[i]的和；
        for (int i = 0; i < nums.length; i++) {
            sums[i+1]+=sums[i]+nums[i];
        }
    }

    // 前right个值的和-前（left-1）个值的和
    public int sumRange(int left, int right) {
        return sums[right+1]-sums[left];
    }
    // 空间复杂度：O(n) 时间复杂度：O(n)
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */