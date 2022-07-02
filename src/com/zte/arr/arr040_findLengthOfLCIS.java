package com.zte.arr;


/**
 * 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，
 * 如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
 * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 */
public class arr040_findLengthOfLCIS {
    public static int findLengthOfLCIS(int[] nums) {
        // 暴力方法就是一个一个遍历，算连续的子序列；

//        但是呢，假如一段是了，再继续下一个肯定也不行，所以需要从不是的地方继续遍历
        int n = nums.length;
        int maxV = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            while (i + count + 1 < n && nums[i + count] < nums[i + count + 1]) {
                count++;
            }
            maxV = Math.max(maxV, ++count);
            i = i + count - 1;
        }

        return maxV;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 2};

        int lengthOfLCIS = findLengthOfLCIS(arr);
        System.out.println(lengthOfLCIS);
    }


    private static int findLengthOfLCIS1(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }

}
