package com.zte.string;

/**
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串
 */
public class Q709_toLowerCase {

    public static void main(String[] args) {

    }

    private static  String toLowerCase(String s) {

        // A-- 65  0 -- 48
        // a-- 97

        // A-Z 二进制表示 01000001 - 01011010
        // 与小写的差距为32 而32对应的位上始终为0 则 +32 可转为或32的位运算

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( c > 65 && c < 90){
                c |=  32;
            }
            sb.append(c);
        }

        return sb.toString();

//        大写变小写、小写变大写 : 字符 ^= 32;
//
//        大写变小写、小写变小写 : 字符 |= 32;
//
//        小写变大写、大写变大写 : 字符 &= -33;
    }
}
