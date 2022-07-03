package com.zte.string;


/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class Q67_addBinary {

    public static void main(String[] args) {
        String a = "1";
        String b = "11";

        String s = addBinary(a, b);
        System.out.println(s);

    }


    private static String addBinary(String a, String b) {

        int maxLen = Math.max(a.length(), b.length());

        int pre = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            int v1, v2, v;
            v1 = i < a.length() ? a.charAt(a.length() - i - 1) - 48 : 0;
            v2 = i < b.length() ? b.charAt(b.length() - i - 1) - 48 : 0;
//             System.out.println(v1+"--"+v2);
            v = v1 + v2 + pre;
            if (v >= 2) {
                res.insert(0, (v - 2));
                pre = 1;
            } else {
                res.insert(0, v);
                pre = 0;
            }
        }
        if (pre == 1) {
            return res.insert(0, "1").toString();
        }
        return res.toString();
        // n是maxLen
        // 时间复杂度：O(n) 空间复杂度：O(1)
    }


    private static String addBinary2(String a, String b) {

        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }




}
