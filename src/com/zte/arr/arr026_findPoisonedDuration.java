package com.zte.arr;

/**
 * 提莫攻击
 *
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄。
 * 他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
 * 当提莫攻击艾希，艾希的中毒状态正好持续duration 秒。
 * 正式地讲，提莫在 t 发起发起攻击意味着艾希在时间区间 [t, t + duration - 1]
 *      （含 t 和 t + duration - 1）处于中毒状态。如果提莫在中毒影响结束 前 再次攻击，
 *      中毒状态计时器将会 重置 ，在新的攻击之后，中毒影响将会在 duration 秒后结束。
 * 给你一个 非递减 的整数数组 timeSeries ，
 * 其中 timeSeries[i] 表示提莫在 timeSeries[i] 秒时对艾希发起攻击，
 * 以及一个表示中毒持续时间的整数 duration 。
 *
 * 返回艾希处于中毒状态的 总 秒数。
 */
public class arr026_findPoisonedDuration {

    public static void main(String[] args) {
        int[] arr = {1,4};
        int poisonedDuration = findPoisonedDuration(arr, 2);
        System.out.println(poisonedDuration);
    }
    public static int findPoisonedDuration(int[] timeSeries, int duration) {

        int n = timeSeries.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 双指针遍历，根据后边一位判断来+多少，
            int j = i+1;
            if (j==n){
                ans+=duration;
                break;
            }
            int t = timeSeries[i];
            if (t<=timeSeries[j]&&timeSeries[j]<=t+duration-1){
                ans+=timeSeries[j]-t;
            }else if (timeSeries[j]>=t+duration-1){
                ans+=duration;
            }

        }
        return ans;
        // 时间复杂度：O(n) 空间复杂度：O(1)
    }


    // 修改

    public int findPoisonedDuration1(int[] timeSeries, int duration) {
        int ans = 0;
        int expired = 0;
        for (int i = 0; i < timeSeries.length; ++i) {
            // 判断加多少
            if (timeSeries[i]>expired){
                ans+=duration;
            }else {
                ans+=timeSeries[i]+duration-expired;
            }
            expired=timeSeries[i]+duration;
        }
        return ans;
        // 时间复杂度：O(n) 空间复杂度：O(1)
    }
}
