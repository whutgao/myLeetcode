package com.zte.arr;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 相对名次
 * 给你一个长度为 n 的整数数组 score ，
 * 其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 * <p>
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，
 * 名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 * <p>
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 */
public class arr028_findRelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        int[] copyarr = score.clone();
        Arrays.sort(copyarr);

        String[] res = new String[score.length];

        for (int i = 0; i < score.length; i++) {
            for (int j = copyarr.length - 1; j >= 0; j--) {
                if (score[i] == copyarr[j]) {
                    if (j == copyarr.length - 1) {
                        res[i] = "Gold Medal";
                    } else if (j == copyarr.length - 2) {
                        res[i] = "Silver Medal";
                    } else if (j == copyarr.length - 3) {
                        res[i] = "Bronze Medal";
                    } else {
                        res[i] = String.valueOf(copyarr.length - j);
                    }
                }
            }
        }
        return res;
    }

    public static String[] findRelativeRanks1(int[] score) {
//        也可以利用二维数组来做，二维中的一维数组【0】表示数【1】表示index
        // 再重写Arrays.sort里的排序方法
        int[][] res = new int[score.length][2];
        for (int i = 0; i < score.length; i++) {
            res[i][0] = score[i];
            res[i][1] = i;
        }

        Arrays.sort(res, (o1, o2) -> o2[0] - o1[0]);


        String[] ans = new String[score.length];

        for (int i = 0; i < res.length; i++) {
            if (i == 0) {
                ans[res[i][1]] = "Gold Medal";
            } else if (i == 1) {
                ans[res[i][1]] = "Silver Medal";
            } else if (i == 2) {
                ans[res[i][1]] = "Bronze Medal";
            } else {
                ans[res[i][1]] = String.valueOf(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] score = {5, 4, 3, 2, 1};
        findRelativeRanks1(score);

    }


}
