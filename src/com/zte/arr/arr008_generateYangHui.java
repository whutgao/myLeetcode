package com.zte.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class arr008_generateYangHui {

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        List<Integer> generate1 = getYangHuiRow(3);
//        System.out.println(generate);
        System.out.println(generate1);

    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> r = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> nxt = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j==0||j==i){
                    nxt.add(1);
                }else {
                    nxt.add(r.get(i-1).get(j-1)+r.get(i-1).get(j));
                }
            }
            r.add(nxt);
        }

        return r;
    }


    /**
     * 杨辉三角 II
     * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
     *
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     *
     */
    private static List<Integer> getYangHuiRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                if (j==0||j==i){
                    row.add(1);
                }else {
                    row.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
            }
            res.add(row);
        }
        return res.get(rowIndex);
    }







}
