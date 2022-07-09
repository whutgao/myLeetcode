package com.zte.string;

import java.util.*;
import java.util.stream.Collectors;

public class Q720_longestWord {

    public static void main(String[] args) {

        String [] words = {"w","wo","wor","worl", "world"};
        String s = longestWord(words);
        System.out.println(s);
    }

    private static  String longestWord(String[] words) {

        Arrays.sort(words,(a,b)->{
            if (a.length()!=b.length()){
                return a.length()-b.length();
            }else {
                return b.compareTo(a);
            }
        });

        String longest = "";
        Set<String> set = new HashSet<>();
        set.add("");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (set.contains(word.substring(0,word.length()-1))){
                set.add(word);
                longest=word;
            }
        }
        return longest;
    }




    // 字典树：一次构建，多次查询； 对于本题，找最长的，并且是在最左边的
    private static  String longestWord1(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        String longest = "";
        for (String word : words) {
            if (trie.search(word)) {
                if (word.length() > longest.length() || (word.length() == longest.length() && word.compareTo(longest) < 0)) {
                    longest = word;
                }
            }
        }
        return longest;
    }


}

class Trie{

    Trie[] children;
    boolean isEnd;

    public Trie(){
        children = new Trie[26];
        isEnd = false;
    }


    public void insert(String word){
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index]==null){
                node.children[index] = new Trie();
            }
            // 依次往下增加
            node = node.children[index];
        }
        node.isEnd = true;
    }

    // a -- 97 A--65  0 -- 48
    public boolean search(String word){
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            // index位置没有 和 index后仍旧有，没有end
            if (node.children[index]== null|| !node.children[index].isEnd){
                return false;
            }
            node = node.children[index];
        }
        return node != null && node.isEnd;
        // node 此时可能有children
    }





}




