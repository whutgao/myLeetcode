package com.zte.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出words 中的 最短补全词 。
 *
 * 补全词 是一个包含 licensePlate 中所有字母的单词。忽略licensePlate 中的 数字和空格 。
 * 不区分大小写。如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 *
 * 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。
 * 可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca" 。
 *
 * 请返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。
 * 当有多个单词都符合最短补全词的匹配条件时取 words 中 第一个 出现的那个。

 */
public class Q748_shortestCompletingWord {
    public static void main(String[] args) {

    }

    private static String shortestCompletingWord(String licensePlate, String[] words) {

        int [] cnt = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (Character.isLetter(c)){
                cnt[Character.toLowerCase(c)-'a']++;
            }
        }

        int idx = -1;

        for (int i = 0; i < words.length; i++) {
            int [] c = new int[26];
            for (int j = 0; j < words[i].length(); ++j) {
                char ch = words[i].charAt(j);
                ++c[ch - 'a'];
            }

            boolean ok = true;
            for (int j = 0; j < 26; ++j) {
                if (c[j] < cnt[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok && (idx < 0 || words[i].length() < words[idx].length())) {
                idx = i;
            }

        }

        return words[idx];


    }





}
