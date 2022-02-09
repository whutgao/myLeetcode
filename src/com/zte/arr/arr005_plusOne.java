package com.zte.arr;

import java.util.Arrays;

/**
 * 数组 005 加一
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *         最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *         你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  理解为数组转为整数+1，主要是注意临界值
 *
 */
public class arr005_plusOne {

    public static void main(String[] args) {
        int [] in = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
        int[] res = plusOne1(in);
        System.out.println(Arrays.toString(res));
    }

    public static int[] plusOne(int[] digits) {
        String s = "";
        for (int i = 0; i < digits.length; i++) {
            s+=String.valueOf(digits[i]);
        }
        //这样格式互相转化，超出范围就没办法了，因此要一个一个来遍历做
        String res = String.valueOf(Long.parseLong(s)+1);
        int [] arr = new int[res.length()];
        for (int i = 0; i < res.length(); i++) {
            arr[i] = (int) res.charAt(i)-48;
        }
        return arr;
    }

    /*遍历做，记录连续9的个数，否则就加1，break*/
    public static int[] plusOne1(int[] digits) {

        int n = digits.length;
        int j = 0;
        for (int i = n-1; i >=0; i--) {
            if (digits[i]==9){
                digits[i] =0;
                j++;
            }else {
                digits[i] = digits[i]+1;
                break;
            }
        }
        if (j==n){
            int [] res  = new int[n+1];
            for (int i = 0; i < n+1; i++) {
                if (i==0){
                    res[i] = 1;
                }else {
                    res[i]=0;
                }
            }
            return res;
        }
        return digits;
    }
}
