package com.zte.arr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 */
public class arr021_findDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i <= nums.length ; i++) {
            if (!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        // nums的数字都是小于n的，假如利用nums[i]的值对应索引位置，将该位置的值+n；
        // 当再次利用时先%n取出真正代表的值；去找另外一个索引位置，
        // 那么遍历nums的值，小于n的值的索引就是缺少的值

        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int num:nums
             ) {
            int x = (num-1)%n;
            nums[x] += n;
        }

        for (int i = 0; i < nums.length; i++) {
//            [4,3,2,7,8,2,3,1]
            if (nums[i]<=n){
                // 小于等于n，怕万一等于n的位置正好是没有更新的位置
                arr.add(i+1);
            }
        }
        return arr;

    }


}
