package com.zte.arr;

import java.util.*;

/**
 * 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 */
public class arr020_thirdMax {
    public static void main(String[] args) {
        int [] arr = {-2147483648,1,1};
        int i = thirdMax(arr);
        System.out.println(i);
    }

    /**
     * 如果nums中o1-o2 存在临界值-2147483648 时，排序就不准确了
     * {-2147483648,1,1}; 这个结果利用sort就不合适了
     * @param nums
     * @return
     */
    private static int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num:nums) {
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        if (list.size()>=3){
            return list.get(list.size()-3);
        }
        return list.get(list.size()-1);

    }

    private static int thirdMax1(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        while (l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

        // 翻转nums，然后遍历,依次选择三个数
        for (int i = 1,diff=0; i < nums.length ; i++) {
            diff++;
            if (nums[i]!=nums[i-1]&&diff==3){
                return nums[i];
            }
        }
        return nums[0];
        // 空间复杂度：O(nlogn) [排序为nlogn]时间复杂度：O(logn)
    }

    private static int thirdMax2(int[] nums) {
        // 有序集合，维持始终有三个数
        TreeSet<Integer> set = new TreeSet<>();
        for (int num: nums
             ) {
            set.add(num);
            if (set.size()>3){
                set.remove(set.first());
            }
        }
        return set.size()==3?set.first():set.last();
    }

    private static int thirdMax3(int[] nums) {
        // 数组保持三个数,依次变小
        long a= Long.MIN_VALUE;
        long b= Long.MIN_VALUE;
        long c= Long.MIN_VALUE;

        for (long num:
             nums) {
            if (num>a){
                c = b;
                b = a;
                a= num;
            }
            else if (a>num && num>b){
                c = b;
                b= num;
            }
            else if (b>num&&num>c){
                c= num;
            }
        }
        return c==Long.MIN_VALUE? (int)a:(int) c;

    }
}
