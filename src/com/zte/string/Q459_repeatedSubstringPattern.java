package com.zte.string;

import java.util.Arrays;

/**
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 */
public class Q459_repeatedSubstringPattern {

    //思考：
    //

    // 最蠢的办法：for循环

    public static void main(String[] args) {
        String abab = "aba";
        boolean b = repeatedSubstringPatternKMP(abab);
        System.out.println(b);
    }

    private static boolean repeatedSubstringPattern(String s) {

        if (s.length() == 0 || s.length() == 1) {
            return false;
        }
        int mid = s.length() / 2;
        for (int i = 1; i <= mid; i++) {
            if (s.length() % i == 0) {
                String st = s.substring(0, i);
                boolean flag = true;
                for (int j = 0; j < s.length(); j = j + i) {
                    if (!s.substring(j, j + i).equals(st)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean repeatedSubstringPattern1(String s) {

        // 如果s中有循环字串，将s从左侧开始依次加到最后，那么加字串个长度就是本身
        // abcabc-- 1: bcabca-- 2: cabcab -- 3: abcabc

        // 1. 这种可以做for循环
        //  xxx暴力
        //
        // 2. 假设字符串s是由s1+s2组成的，s+s后，str就变成了s1+s2+s1+s2，
        // 去掉首尾，破环了首尾的s1和s2，变成了s3+s2+s1+s4,此时str中间就是s2+s1,
        // 如果s是循环字串，也就是s1=s2,所以str中间的s2+s1就和原字符串相等。
        // 如果s不是循环字串，s1!=s2，那么s1+s2是不等于s2+s1的，也就是str中间不包含s
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
        // 也是找到s的位置不在第二个s开始的地方，下标不为n
//        return (s + s).indexOf(s, 1) != s.length();

    }


    private static boolean repeatedSubstringPatternKMP(String s) {
//        / 既然是找字串，可以利用KMP算法来找

        if (s.length() == 0 || s.length() == 1) {
            return false;
        }

        int[] next = kmpNext(s);
        System.out.println(Arrays.toString(next));
        // 也可以根据next数组直接判断出，如果有循环的话，s.length() - next[n-1] 就是公约数，也是最小的循环字串
        return next[s.length()-1]!=0 && s.length()%(s.length()-next[s.length()-1])==0;
//        int i = kmpSearch(s + s, s, next);
//        System.out.println(i);
//        return i != -1&&i != 0&&i != s.length();
    }


    private static int kmpSearch(String s1, String s2, int[] next) {


        for (int i = 1, j = 0; i < s1.length(); i++) {

            while (j > 0 && s1.charAt(i) != s2.charAt(j)) {
                j = next[j - 1];
            }

            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }

            if (j == s2.length()) {
                return i - j + 1;
            }

        }
        return -1;
    }

    private static int[] kmpNext(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;

        for (int i = 1, j = 0; i < s.length(); i++) {

            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;

        }

        return next;
    }


}
