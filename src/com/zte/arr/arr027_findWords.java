package com.zte.arr;

import java.util.*;


/**
 * 键盘行
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。
 * 键盘所示。
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 *
 */
public class arr027_findWords {

    public static void main(String[] args) {
        String[] r = {"Hello","Alaska","Dad","Peace"};
        String[] words = findWords(r);
        System.out.println(Arrays.toString(words));
    }

    private static String[] findWords(String[] words) {

        String str0 = "qwertyuiop";
        String str1 = "asdfghjkl";
        String str2 = "zxcvbnm";

        Set<Character> set0 = new HashSet<>();
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (int i = 0; i < str0.length(); i++) {
            set0.add(str0.charAt(i));
        }
        for (int i = 0; i < str1.length(); i++) {
            set1.add(str1.charAt(i));
        }
        for (int i = 0; i < str2.length(); i++) {
            set2.add(str2.charAt(i));
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            int flag;
            char c = Character.toLowerCase(words[i].charAt(0));
            if (set0.contains(c)){
                flag= 0;
            }else if (set1.contains(c)){
                flag= 1;
            }else if (set2.contains(c)){
                flag= 2;
            }else{
                continue;
            }
            System.out.println(flag);
            int count0 = 1;
            int count1 = 1;
            int count2= 1;
            for (int j = 1; j < words[i].length(); j++) {
                char c1 = Character.toLowerCase(words[i].charAt(j));
                if (flag==0&&set0.contains(c1) ){
                    count0++;
                }else if (set1.contains(c1)&&flag==1){
                    count1++;
                }else if (flag==2&&set2.contains(c1)){
                    count2++;
                }
            }

            if (count0==words[i].length()||count1==words[i].length()||count2==words[i].length())
            {
                res.add(words[i]);
            }
        }

        return res.toArray(new String[res.size()]);


    }


    public String[] findWords1(String[] words) {
        List<String> list = new ArrayList<String>();
        String rowIdx = "12210111011122000010020202";
        for (String word : words) {
            boolean isValid = true;
            char idx = rowIdx.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
            for (int i = 1; i < word.length(); ++i) {
                if (rowIdx.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != idx) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(word);
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
