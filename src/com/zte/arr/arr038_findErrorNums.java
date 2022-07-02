package com.zte.arr;


import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 错误的集合
 * 集合 s 包含从 1 到 n的整数。不幸的是，因为数据错误，
 * 导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
 * 导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 */
public class arr038_findErrorNums {

    public int[] findErrorNums(int[] nums) {

        Arrays.sort(nums);
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                if (nums[i] == i + 1) {
                    // 此时是第i+1个小了
                    res[0] = nums[i];
                    res[1] = nums[i] + 1;
                } else {
                    //此时是第i个大了
                    res[0] = nums[i] - 1;
                    res[1] = nums[i];
                }
            }
        }
        return res;
        // 这种改变了顺序，不合理
    }


    public static int[] findErrorNums1(int[] nums) {
        Arrays.sort(nums);

        // 记录初始，以下一个减去前一个，如果为2，那么前一个数就是多余的，并且需要更新

        int[] res = new int[2];
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
//            如果丢失的数字大于 1 且小于 n，则一定存在相邻的两个元素的差等于 2，这两个元素之间的值即为丢失的数字；
//            如果丢失的数字是 11 或 nn，则需要另外判断。
            int curr = nums[i];
            // 要不就先相等：1 2 3 3 5，要不就先相差2： 1 2 4 4
            // 要注意顺序，先输出哪个，后输出哪个
            if (curr == pre) {
                res[0] = pre;
            } else if (curr - pre > 1) {
                res[1] = pre + 1;
            }
            pre = curr;
        }

        // 判断在两端的,因为pre=0，开头的已经判断了；
        if (nums[nums.length - 1]!=nums.length) {
            res[1] = nums.length;
        }

        return res;
    }

    public static int[] findErrorNums2(int[] nums) {
        // 转为set 计算和
        // 计算1-n的和
        // 相减就是缺少的数
        return null;
    }




}
