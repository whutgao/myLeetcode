package com.zte.arr;

/**
 * 图片平滑器
 * 图像平滑器 是大小为3 x 3的过滤器，可以计算是周围的8个单元和它本身的值求平均灰度
 * (即蓝色平滑器中9个单元的平均值)来应用于图像的每个单元。
 * 如果一个单元的一个或多个周围的单元不存在，我们不考虑它的平均值(即红色平滑器中的四个单元的平均值)
 * <p>
 * 给定一个代表图像灰度的 m x n 整数矩阵 img ，返回对图像的每个单元格平滑处理后的图像
 * <p>
 * 输入:img = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出:[[0, 0, 0],[0, 0, 0], [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 */
public class arr039_imageSmoother {
    public int[][] imageSmoother(int[][] img) {

        int n = img.length;
        int m = img[0].length;
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int divisor = 1;//除数
                int temp = img[i][j];
                //下看四周的八个点是否存在
                if (i - 1 >= 0) {
                    divisor++;
                    temp += img[i - 1][j];
                }
                if (i + 1 < n) {
                    divisor++;
                    temp += img[i + 1][j];
                }
                if (j - 1 >= 0) {
                    divisor++;
                    temp += img[i][j - 1];
                }
                if (j + 1 < m) {
                    divisor++;
                    temp += img[i][j + 1];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    divisor++;
                    temp += img[i - 1][j - 1];
                }
                if (i + 1 < n && j + 1 < m) {
                    divisor++;
                    temp += img[i + 1][j + 1];
                }
                if (i - 1 >= 0 && j + 1 < m) {
                    divisor++;
                    temp += img[i - 1][j + 1];
                }
                if (i + 1 < n && j - 1 >= 0) {
                    divisor++;
                    temp += img[i + 1][j - 1];
                }
                ans[i][j] = temp / divisor;
            }
        }
        return ans;
    }


    public int[][] imageSmoother1(int[][] M) {
        int R = M.length, C = M[0].length;
        int[][] ans = new int[R][C];

        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {

                // 用for循环做简单
                int count = 0;
                for (int nr = r - 1; nr <= r + 1; ++nr) {
                    for (int nc = c - 1; nc <= c + 1; ++nc) {
                        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                            ans[r][c] += M[nr][nc];
                            count++;
                        }
                    }
                }
                ans[r][c] /= count;


            }
        }
        return ans;
    }

}
