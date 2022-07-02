package com.zte.arr;


import java.util.*;

/**
 *
 * 下一个更大元素 I
 *
 * nums1中数字x的 下一个更大元素 是指x在nums2中对应位置右侧 的 第一个 比x大的元素。
 * 给你两个 没有重复元素 的数组nums1 和nums2 ，下标从 0 开始计数，
 * 其中nums1是nums2的子集。
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。
 * 如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * 返回一个长度为nums1.length 的数组 ans 作为答案，
 * 满足 ans[i] 是如上所述的 下一个更大元素 。
 */
public class arr026_nextGreaterElement {

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ints = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res  =new int[nums1.length];
        for (int i = 0; i < nums1.length ; i++) {
            boolean f = false;
            for (int j = 0; j < nums2.length ; j++) {
                if (nums1[i] == nums2[j]){
                    f = true;
                }
                if (f&&nums2[j]>nums1[i]){
                    res[i] = nums2[j];
                    break;
                }
                res[i] = -1;
            }
        }
        return res;
        // 时间复杂度：O(mn) 空间复杂度：O(1)
    }


    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
//        pop(element):
//        刪除在頭部元素，同時返回被刪除元素。

        // 把nums2的都找到，再nums1遍历取值
        for (int i = nums2.length-1; i >0; i++) {
            while (!stack.isEmpty()&&stack.peek()<=nums2[i]){
                stack.pop();
            }
            map.put(nums2[i],stack.isEmpty()?-1:stack.peek());
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i <nums1.length ; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;

    }


}
