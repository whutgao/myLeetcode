package com.zte.string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Q14_longestCommonPrefix {

    public static void main(String[] args) {

        String[] strings = {"flower","flow","flight"};

        String s = commonPrefixDichotomy(strings);
        System.out.println(s);
    }

    // 思路： 前缀
    private static String longestCommonPrefix(String[] strs) {

        //既然是前缀，那么每一个都有前几个
        String s1 = strs[0];
        for (int i = 0; i < s1.length() ; i++) {
//            取字符串的前i个字符   str=str.substring(0,i);
            String subString = s1.substring(0,i+1);
            for (int j = 1; j < strs.length; j++) {
                if ( !(strs[j].length()> i && strs[j].substring(0,i+1).equals(subString))){
                    return subString.substring(0,i);
                }
            }
        }
        return s1;
    }

    // 时间复杂度：O(mn) 空间复杂度：O(1)


    /**
     * 分治算法
     * @param s
     * @return
     */
    private static String findLongestCommonPrefix(String[] s){
        if (s ==null || s.length ==0){
            return "";
        }else {
            return divideLongestCommonPrefix(s,0,s.length-1);
        }
    }

    private static String divideLongestCommonPrefix(String[] s, int left, int right){

        if (left==right){
            return s[left];
        }

        int mid = left+ (right-left)/2;

        String s1 = divideLongestCommonPrefix(s, left, mid);
        String s2 = divideLongestCommonPrefix(s, mid + 1, right);
        return commonPrefix(s1,s2);
    }

    private static String commonPrefix(String s1,String s2){
        int minLength = Math.min(s1.length(),s2.length());
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i)!= s2.charAt(i)){
                return s1.substring(0,i);
            }
        }
        return s1.substring(0,minLength);
    }

    // 时间复杂度：O(mn) 空间复杂度：O(mlogn)


    /**
     * 二分查找
     */
    private static String commonPrefixDichotomy(String[] strings){

        if (strings==null || strings.length==0){
            return "";
        }

        int minLength = strings[0].length();
        for (String s: strings
             ) {
            minLength =  Math.min(minLength,s.length());
        }

        int left = 0;
        int right = minLength;
        while (left<right){
            // 注意要加1
            int mid = (right+left+1)/2;
            if (isCommonPrefix(strings,mid)){
                left = mid;
            }else {
                right= mid-1;
            }
        }
        return strings[0].substring(0,left);

    }

    private static boolean isCommonPrefix(String[] strs, int length){
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }



}
