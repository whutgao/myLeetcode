package com.zte.arr;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

/**
 * 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于n/2的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 思考：
 * 1. hashmap统计次数
 * 2. 排序后，中间的就是； Arrays.sort(nums); nums[nums.length / 2];
 * 3. 找时间复杂度最小的
 */
public class arr011_majorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int val : nums) {
            if (!map.containsKey(val)) {
                map.put(val, 1);
            } else {
                int num = map.get(val) + 1;
                if (num > nums.length / 2) {
                    return val;
                }
                map.put(val, num);
            }
        }
        return nums[0];
    }

    /** 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
    就算是排序后取值时间复杂度也不符合要求 */

    /**
     * 方法四：分治
     * 思路
     * 如果数 a 是数组 nums 的众数，如果我们将 nums 分成两部分，那么 a 必定是至少一部分的众数。
     *
     * 我们使用经典的分治算法递归求解，直到所有的子问题都是长度为 1 的数组。
     * 长度为 1 的子数组中唯一的数显然是众数，直接返回即可。
     * 如果回溯后某区间的长度大于 1，我们必须将左右子区间的值合并(合并后找值)。
     *      如果它们的众数相同，那么显然这一段区间的众数是它们相同的值。否则，我们需要比较两个众数在整个区间内出现的次数来决定该区间的众数。
     */
    public int majorityElement1(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // 分到最小，只有一个元素时，就返回本身
        if (lo == hi) {
            return nums[lo];
        }

        // 分段
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // 如果两段的值相等，那么就返回这个值
        if (left == right) {
            return left;
        }

        // 左右不相等的时候，取两段合并后的众数
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }


    /**
     * 投票算法
     * 维护一个候选众数 candidate 和它出现的次数 count。
     * 初始时 candidate 可以为任意值，count 为 0；
     * 遍历数组 nums 中的所有元素，对于每个元素 x，在判断 x 之前，如果 count 的值为 0，我们先将 x 的值赋予 candidate，随后我们判断 x：
     * 如果 x 与 candidate 相等，那么计数器 count 的值增加 1；
     * 如果 x 与 candidate 不等，那么计数器 count 的值减少 1。
     */
    public int majorityElement2(int[] nums) {
//        Random rand = new Random();
        Integer candidate = null;
        int count=0;
        for ( int num: nums) {
            if (count==0){
                candidate = num;
                count++;
            }else if (candidate == num){
                count++;
            }else {
                count--;
            }
        }
        return candidate;

    }


}
