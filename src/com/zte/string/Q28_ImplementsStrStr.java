package com.zte.string;


import java.util.Arrays;

/**
 * 实现strStr()函数。
 * <p>
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle
 * 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 */
public class Q28_ImplementsStrStr {

    public static void main(String[] args) {
        int i = strStr("hello", "ll");
        System.out.println(i);


        String s1 = "abcabcabcabcabcabcabcabc";
        String s2 = "abcabcabcabc";
        int[] next = kmpNext(s2);
        System.out.println(Arrays.toString(next));
        int index = kmpSearch(s1,s2,next);
        System.out.println(index);

    }


    //    当 needle 是空字符串时我们应当返回 0 。
    private static int strStr(String haystack, String needle) {

        if (needle == null || needle.length() == 0 || haystack.equals(needle)) {
            return 0;
        }

        if (haystack.contains(needle)) {

            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                int count = 0;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) == needle.charAt(j)) {
                        count++;
                    }
                }
                if (count == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
    // 时间复杂度：O(m*n) 空间复杂度：O(1)


//    KMP算法

    private static int kmpSearch(String s1,String s2,int[] next){

        for (int i = 0,j=0; i < s1.length(); i++) {
            // 每次i增加时，找相同的前后缀个数[已经在next中计算好了]
            // 此时到i，如果字符不一致，则根据前后缀有j个相同，在下一个i时，判断str2的j个后的
            while (j>0 && s1.charAt(i)!= s2.charAt(j)){
                j = next[j-1];
            }
            if (s1.charAt(i)==s2.charAt(j)){
                j++;
            }
            if (j==s2.length()){
                return i-j+1;
            }
        }
        return -1;
    }







    private static int[] kmpNext(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;

        // 双指针理解：i可以看为right j可以看为left
        //j表示前i个字符中前后缀相同的个数
        for (int i = 1, j = 0; i < s.length(); i++) {

            //KMP 算法核心
            // 当s.charAt(i) != s.charAt(j)时，需要取j左侧的部分匹配表对应的值作为新的j
            //当第i个字符和第j个字符不相同时，令j等于第j-1个字符的模式匹配值
            //再次比较第j个字符和第i个字符是否相等，若否，则继续令
            //j等于第j-1个字符的模式匹配值，继续比较
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }

            // 满足即+1 ；i即部分字符串末尾的字符，j即之前部分匹配表的字符；
            // j表示前i个字符中前后缀相同的个数
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            //将中第i个元素设为j，表示前i个字符中前后缀相同的字串长度为j
            next[i] = j;
        }


        return next;

    }


}
