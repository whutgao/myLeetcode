package com.zte.string;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class Q392_isSubsequence {

    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";
        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);

    }

    private static  boolean isSubsequence(String s, String t) {

        if (s.length()>t.length()){
            return false;
        }

        if (s.length()==0){
            return true;
        }

        for (int i = 0,j=0; i < t.length(); i++) {

            if (t.charAt(i)==s.charAt(j)){
                j++;
            }
            if (j==s.length()){
                return true;
            }

        }
        return false;

    }
}
