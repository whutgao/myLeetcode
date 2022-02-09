package com.zte.arr;

import java.util.Arrays;

/**
 * 数组 006 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，
 * 另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */

public class arr006_mergeTwoArr {

    public static void main(String[] args) {
        int[] nums1 = {2, 0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        } else if (n == 0) {
            return;
        }

        //注意：合并后数组不应由函数返回，而是存储在数组 nums1 中
        //找范围，困难
        int[] arr = new int[m + n];
        int x = 0;
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            if (x < m && y < n && nums1[x] <= nums2[y]) {
                arr[i] = nums1[x];
                x++;
            } else if (x < m && y < n && nums1[x] > nums2[y]) {
                arr[i] = nums2[y];
                y++;
            } else if (x == m && y < n) {
                arr[i] = nums2[y];
                y++;
            } else if (x < m && y == n) {
                arr[i] = nums1[x];
                x++;
            }
            System.out.println(Arrays.toString(arr));
        }

        for (int i = 0; i < arr.length; i++) {
            nums1[i] = arr[i];
        }

    }

    //  直接合并后排序
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);
    }

    //双指针，既然可以用for 那么也就可以用while做
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur = 0;
        while (p1 < m || p2 < n) {
            // 先判断p1和p2的范围，防止一方已经结束，再取值会报越界错误
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] <= nums2[p2]) {
                cur = nums1[p1];
                p1++;
            } else{
                cur = nums2[p2];
                p2++;
            }
            sorted[p1+p2-1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }

    }

}
