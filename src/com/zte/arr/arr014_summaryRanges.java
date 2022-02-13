package com.zte.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 无重复元素 的有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字的最小有序区间范围列表。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 */
public class arr014_summaryRanges {

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        List<String> strings = summaryRanges1(nums);
        System.out.println(strings);
    }

    /**
     * 遍历
     */
    public static List<String> summaryRanges(int[] nums) {
        // 循环 假如！=1的时候取索引，==1的时候左索引不变，右索引+1；
        List<String> res = new ArrayList<>();
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            while (j < nums.length) {
                if (nums[j] - nums[j - 1] == 1) {
                    j++;
                    count++;
                } else {
                    if (count == 0) {
                        res.add(String.valueOf(nums[i]));
                    } else {
                        res.add(nums[i] + "->" + nums[j - 1]);
                    }
                    count = 0;
                    i = j;
                    break;
                }
            }
            if (count != 0) {
                res.add(nums[i] + "->" + nums[i + count]);
                return res;
            }
            if (i == nums.length - 1) {
                res.add(String.valueOf(nums[i]));
                return res;
            }
        }
        return res;
    }

    public static List<String> summaryRanges1(int[] nums) {
        /*List<String> list = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                continue;
            }
            if (i == j) {
                list.add(nums[i] + "");
            } else {
                list.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return list;*/

//[0,2,3,4,6,8,9]
        List<String> ans = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; ++i) {
            // 当第i个数满足与后一位差1时，并且不出范围时
            if (!(i + 1 < nums.length && nums[i] == nums[i + 1] - 1)) {
                if (sb.length() > 0) {
                    sb.append("->");
                }
                sb.append(nums[i]);
                ans.add(sb.toString());
                sb = new StringBuilder();
            } else {
                if (sb.length() == 0) {
                    sb.append(nums[i]);
                }
            }
        }
        return ans;
    }


}
