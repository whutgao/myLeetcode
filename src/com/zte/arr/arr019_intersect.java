package com.zte.arr;

import java.util.Arrays;

/**
 * 两个数组的交集 II
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（
 * 如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 *  思考：不仅仅是要交集，要取到交集的个数（是不是要搞一个东西保存这个数量）
 */
public class arr019_intersect {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] intersect = intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        // 先排序，再遍历
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int left=0;
        int right=0;
        int index = 0;
        int length1 = nums1.length, length2 = nums2.length;
        int[] res = new int[length1 + length2];
        int count = 0;
        while (left<length1&&right<length2){
            if (nums1[left]==nums2[right]){
                // 不用判断是否重复，直接赋值，不同之后就返回
                res[index++] = nums1[left];
                count++;
                left++;right++;
            }else if (nums1[left]<nums2[right]){
                left++;
            }else {
                right++;
            }
        }
        return Arrays.copyOfRange(res,0,count);
    }

}
