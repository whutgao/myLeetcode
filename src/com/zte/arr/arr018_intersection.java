package com.zte.arr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。
 * 我们可以 不考虑输出结果的顺序 。
 */
public class arr018_intersection {
    public static void main(String[] args) {
//        int [] nums1 = {1,2,2,1}, nums2 = {2,2};
//        int[] intersection = intersection(nums1, nums2);
//        System.out.println(Arrays.toString(intersection));

         int[] arr = new int[4];
         int i=0;
         arr[++i] = 1;// 是先自增(=1)再给i(=1)赋值;
         arr[i++] = 1;// 是先给i(=1)赋值再自增(=2);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        //暴力
        for (int num1:nums1
             ) {
            for (int num2:nums2
                 ) {
                if (num1==num2){
                    set.add(num1);
                }
            }
        }
        int[] ints = set.stream().mapToInt(Number::intValue).toArray();
        return ints;


        /* Set<Integer> set1 = new HashSet<>(),set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i:nums1){
            list.add(i);
        }
        for(int i:nums2){
            set2.add(i);
        }
        list.retainAll(set2);
        set1.addAll(list);
        // 关于流的操作需要重新学习
        return set1.stream().mapToInt(i->i).toArray(); */
    }


    public int[] intersection3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[length1 + length2];

        int index=0;
        int left = 0,right = 0;
        while (left<nums1.length&&right<nums2.length){
            int num1 = nums1[left];
            int num2 = nums2[right];
            if (num1==num2){
                // 保证有序结果列表中不重复
                if (index==0||intersection[index-1]!=num1){
                    intersection[index++] = num1;
                }
                left++;right++;
            }else if (num1<num2){
                left++;
            }else {
                right++;
            }
        }

        return Arrays.copyOfRange(intersection,0,index);
    }



}
