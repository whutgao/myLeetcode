package com.zte.arr;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *  最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、
 * 且不改变其余元素的顺序而得到。
 */
public class arr032_findLHS {

    public static void main(String[] args) {
        int [] arr = {1,1,1,1};
//        int [] arr = {1,3,2,2,5,2,3,7};
        int lhs = findLHS1(arr);
        System.out.println(lhs);
    }


    private static int findLHS(int[] nums) {
        //暴力
        Arrays.sort(nums);

        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int distance = 1;
            while ((i+distance)<nums.length
                    && nums[i+distance]-nums[i]<=1){
                distance++;
            }
            if (distance==1 || nums[i]==nums[i+distance-1]){
                distance = 0;
            }
            maxCount = Math.max(maxCount,distance);
        }

//        int begin = 0;
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            while (nums[i]-nums[begin]>1){
//                begin++;
//                // 刚开始是从0开始，不满足后更新begin到满足条件，统计中间个数
//            }
//            if (nums[i] - nums[begin]==1){
//                res = Math.max(res,i-begin+1);
//            }
//        }
        // 时间复杂度：O(NlogN) 空间复杂度：O(1)



        return maxCount;

    }


    private static int findLHS1(int[] nums) {

        HashMap <Integer, Integer> cnt = new HashMap <>();
        int res = 0;
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        for (int key : cnt.keySet()) {
            if (cnt.containsKey(key + 1)) {
                res = Math.max(res, cnt.get(key) + cnt.get(key + 1));
            }
        }

        return res;
        // 时间复杂度：O(N) 空间复杂度：O(N)


    }
}
