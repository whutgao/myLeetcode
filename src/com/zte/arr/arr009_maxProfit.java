package com.zte.arr;


/**
 * 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 思路：dp[n] 找最大的
 */
public class arr009_maxProfit {

    /**
     * 可以这么做，但是prices太长的话，时间太长了
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i; j < prices.length; j++) {
                max = Math.max(max,prices[j]-prices[i]);
            }
        }
        return max;
    }

    private static int maxProfit1(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 0;
        int min = prices[0];
        int max =0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = prices[i]-min;
            max = Math.max(dp[i],max);
            min = Math.min(min,prices[i]);
        }
        return max;


//        dp[i] = min(d[i-1],prices[i]) dp维护的第i个对应的最小的值
//        int max = 0;
//        int[] dp = new int[prices.length];
//        dp[0] = prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            dp[i] = (dp[i - 1] < prices[i]) ? dp[i - 1] : prices[i];
//            max = (prices[i] - dp[i]) > max ? prices[i] - dp[i] : max;
//        }
//        return max;
    }

    // 优化空间
    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

}
