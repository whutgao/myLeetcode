package com.zte.string;

/**
 *给定两个字符串 s 和 t ，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 */
public class Q389_findTheDifference {





    private static char findTheDifference(String s, String t) {

        int[] arr = new int[26];
        // 计数
        for (int i = 0; i < s.length() ; i++) {
            char c  = s.charAt(i);
            arr[c-'a'] ++;
        }

        for (int i = 0; i < t.length() ; i++) {
            char c = s.charAt(i);
            arr[c-'a']--;
            if (arr[c-'a']<0){
                return c;
            }
        }
        return ' ';
        // 时间复杂度：O(N) 空间复杂度：O(|x|) x 是字符集长度26
    }

    private static char findTheDifference1(String s, String t) {

        // 两个分别求和相减
        int a1 = 0,a2 = 0;
        for (Character c1:s.toCharArray()
             ) {
            a1+=c1;
        }

        for (Character c2:t.toCharArray()
        ) {
            a2+=c2;
        }

        return (char)(a2-a1);
        // 时间复杂度：O(n) 空间复杂度：O(1)
    }


    private static char findTheDifference2(String s, String t) {

        // 位运算 异或本身是0

        int ret = 0;
        for (Character c1:s.toCharArray()
        ) {
            ret^=c1;
        }

        for (Character c2:t.toCharArray()
        ) {
            ret^=c2;
        }
        return (char) ret;
        // 时间复杂度：O(n) 空间复杂度：O(1)

    }



}


