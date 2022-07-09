package com.zte.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，
 * 并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
 * <p>
 * 重复出现（不同位置）的子串也要统计它们出现的次数。
 */
public class Q696_countBinarySubstrings {


    public static void main(String[] args) {
        String s = "000011100001";
        System.out.println(countBinarySubstrings2(s));

    }

    // 关键点 ： 只有 0 和 1 ； 成组出现
    private static int countBinarySubstrings(String s) {

        // 01 10
        // 0011 1100 01 10
        // 000111 111000 0011 1100 01 10

        int count = 0;
        int count1 = 0, count2 = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {

            if(j>s.length()){
                count = count + count2;
                break;
            }

            j = i;
            count1 = 0;count2 = 0;
            while (j < s.length()) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 刚开始会是1
                    if (count2 != 0) {
                        i = i + count1 - 1;
                        count = count + count2;
                        break;
                    }
                    count1++;
                    j++;
                    continue;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    count2++;
                    j++;
                }

                if (count1 == count2) {
                    i = i + count1 - 1;
                    count = count +  count2;
                    break;
                }
            }
        }

        return count;
    }


    // 同样是利用前后长度判断，可以直接把相同的字符计数构成集合，再遍历集合每次取最小值即可
    private static  int countBinarySubstrings1(String s) {
        int ans = 0;
        List<Integer> ls = new ArrayList<>();

        int i = 0;
        while (i<s.length()){
            Character c = s.charAt(i);
            int count = 0;
            while (i< s.length()&& c.equals(s.charAt(i))){
                i++;
                count++;
            }
            ls.add(count);
        }
//        System.out.println(ls);

        for (int j = 1; j < ls.size() ; j++) {
            ans = ans + Math.min(ls.get(j-1),ls.get(j));
        }

        return ans;
        // 时间复杂度：O(n) 空间复杂度：O(n)
    }



    private static  int countBinarySubstrings2(String s) {
        int ans = 0;
        int i = 0,last=0;
        while (i<s.length()){
            Character c = s.charAt(i);
            int count = 0;
            while (i< s.length()&& c.equals(s.charAt(i))){
                i++;
                count++;
            }
            ans = ans + Math.min(last,count);
            last = count;
        }
        return ans;
        // 时间复杂度：O(n) 空间复杂度：O(1)
    }


}
