package com.zte.string;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class Q541_reverseStr {

    public static void main(String[] args) {
        String s = "abcdefg";
        String s1 = reverseStr(s, 1);
        System.out.println(s1);
    }

    private static  String reverseStr(String s, int k) {

        int len = s.length();

        // for循环 遍历 判断是否取到最后一次

        StringBuilder sb = new StringBuilder();
        String subString;
        for (int i = 0; i < s.length(); i = i+2*k) {

            if (i+k > s.length()-1){
                // 如果剩余字符少于 k 个，则将剩余字符全部反转
                subString = s.substring(i,s.length());
                sb.append(reverse(subString));
                break;
            } else if (i+k <= s.length()-1 && i+2*k >s.length()-1){
                subString = s.substring(i,i+k);
                sb.append(reverse(subString)).append(s,i+k,s.length());
                break;
            }else {
                // 根据i+2*k 会忽略最后一次的计算
                subString = s.substring(i,i+k);
                sb.append(reverse(subString)).append(s, i+k, i+2*k);
            }
        }

        return sb.toString();
    }

    private static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }
}
