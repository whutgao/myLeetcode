package com.zte.string;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class Q680_validPalindrome {

    public static void main(String[] args) {

        String s = "abc";
        System.out.println(validPalindrome(s));

    }


    // 变为回文字串 可以依次删除，判断与翻转是否一致，笨方法
    private static boolean validPalindrome(String s) {

        // 拆分 当对称的不相等了，分成两份看是否其中一份是回文字串
        int i= 0, j = s.length()-1;
        while (i<j){

            if (s.charAt(i)!= s.charAt(j)){
                return validPalindromeSub(s,i,j-1)|| validPalindromeSub(s,i+1,j);
            }

            i++;
            j--;

        }
        return true;
    }

    private static boolean validPalindromeSub(String s,int i,int j){

        while (i<j){

            if (s.charAt(i)!= s.charAt(j)){
                return false;
            }
            i++;
            j--;

        }
        return true;
    }

    // 时间复杂度：O(n) 空间复杂度：O(1)

}
