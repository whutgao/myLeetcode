package com.zte.arr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 丢失的数字
 *
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 *
 */
public class arr015_missingNumber {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 总共有n+1个数，范围是[0,n];
                if (nums[i]!=i){
                    return i;
                }
        }
        return nums.length;
    }

    // hashMap 做 定义一个nums的hashmap,遍历[0,n]看哪个不在

    //
    private int missingNumber1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        // 时间复杂度O(n) 空间复杂度 O(n)
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        // 时间复杂度O(n)
        int missing = -1;
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        // 最终时间复杂度为时间复杂度O(n)； 空间复杂度主要在set是O(n)
        return missing;
    }

    // 位运算 异或本身等于0 异或0等于本身 再增加一组[0,n],异或后结果就是不存在的数
    public int missingNumber2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        for (int i = 0; i <= nums.length; i++) {
            ans ^= i;
        }
        return ans;
        // 时间复杂度： O(n)
//        空间复杂度: O(1)
    }

    // 数学算法 Sum([0,n])-Sum(nums)
    public int missingNumber3(int[] nums) {
        int total = (nums.length+1)*nums.length/2;
        for (int num : nums) {
            total = total - num;
        }
        return total;

    }




}
