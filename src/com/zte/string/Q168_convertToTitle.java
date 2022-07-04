package com.zte.string;

/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 */
public class Q168_convertToTitle {

    public static void main(String[] args) {
        int a = 701;
        String s = convertToTitle(a);
        System.out.println(s);
    }

    /**
     * 题目转化成十进制转26进制问题 使用-1 熨平取模的问题。
     * 因为x%26=[0,25] 但是我们取从[1-26]对应[A-Z] 直接取模 26%26=0
     * 不在我们范围内 所以我们采用-1 [0-25]对应[A-Z] (26-1)%26 =25 25+'A'='Z'
     * @param columnNumber
     * @return
     */
    private static String convertToTitle(int columnNumber) {

        if (columnNumber==0){
            return null;
        }

//        A -- 65
        // 26 进制
        StringBuilder sb = new StringBuilder();
        while (columnNumber!=0) {
            int remainder = columnNumber  % 26;
            columnNumber/= 26;

            if (remainder == 0){
                sb.append('Z');
                columnNumber--;
            }else {
                sb.append((char) ('A' + remainder -1));
            }

        }
        return sb.reverse().toString();
    }
}

