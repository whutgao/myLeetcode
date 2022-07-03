package com.zte.string;

import java.util.Arrays;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */
public class Q58_lengthOfLastWord {

    public static void main(String[] args) {
        String s = "Hello World";
        int i = lengthOfLastWord(s);
        System.out.println(i);

    }

    private static int lengthOfLastWord(String s) {

        String[] strs = s.split(" ");

        for (int i = strs.length-1; i >=0 ; i--) {
            if (strs[i].length()!=0){
                return strs[i].length();
            }
        }

        return 0;
        // 时间复杂度：O(n) 空间复杂度：O(1)
    }
}
