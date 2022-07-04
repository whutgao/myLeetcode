package com.zte.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern和一个字符串s，判断 s是否遵循相同的规律。
 *
 * 这里的遵循指完全匹配，
 *
 * 例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律。
 */
public class Q290_wordPattern {

    public static void main(String[] args) {
        String p = "abba";
        String s = "dog cat cat fish";

        boolean b = wordPattern(p, s);
        System.out.println(b);
    }


    private static boolean wordPattern(String pattern, String s) {

        String[] strs = s.split(" ");

        if (strs.length!=pattern.length()){
            return false;
        }


        Map<Character,String> map1 = new HashMap<>();
        Map<String,Character> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            if (!map1.containsKey(c)){
                map1.put(c,strs[i]);
            }else {
                if (!strs[i].equals(map1.get(c))){
                    return false;
                }
            }
            if (!map2.containsKey(strs[i])){
                map2.put(strs[i],c);
            }else {
                if (!c.equals(map2.get(strs[i]))){
                    return false;
                }
            }
        }


// 时间复杂度：O(m+n) 空间复杂度：O(m+n)

        return true;
    }

    // 根据依次put的结果判断是否相同

    private static boolean wordPatter1(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }




}
