package com.zte.arr;

/**
 * 范围求和 II
 * 给你一个 m xn 的矩阵M，初始化时所有的 0 和一个操作数组 op ，
 * 其中 ops[i] = [ai, bi] 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时，
 * M[x][y] 应该加 1。在执行完所有操作后，计算并返回矩阵中最大整数的个数
 */
public class arr033_maxCount {

    public static void main(String[] args) {
        int m = 3, n = 3;
        int[][] ops = {{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3}};
        int i = maxCount(m, n, ops);
        System.out.println(i);
    }



    // 思考：找最小值的行和列 因为会计算多次行和列
    public static int maxCount(int m, int n, int[][] ops) {
        int minx = m;
        int miny = n;

        for (int i = 0; i < ops.length; i++) {
                minx = Math.min(minx,ops[i][0]);
                miny = Math.min(miny,ops[i][1]);
        }
        return minx*miny;
        // 时间复杂度：O(N) 空间复杂度：O(1)
    }
}
