package com.zte.arr;

/**
 * 岛屿的周长
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地，
 * grid[i][j] = 0 表示水域。
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。
 * 整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
 * 格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 */
public class arr024_islandPerimeter {

    public static void main(String[] args) {
//        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][] grid = {{1,0}};
        int i = islandPerimeter(grid);
        System.out.println(i);
    }

    public static int islandPerimeter(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int count = 0;
                if (grid[i][j]==1){
                    count=4;
                    if (i-1>=0&&grid[i-1][j]==1){
                        count--;
                    }
                    if (j-1>=0&&grid[i][j-1]==1){
                        count--;
                    }
                    if (j+1<y&&grid[i][j+1]==1){
                        count--;
                    }
                    if (i+1<x&&grid[i+1][j]==1){
                        count--;
                    }
                }
                perimeter+=count;
            }
        }
        return perimeter;
        // 空间复杂度：O(1) 时间复杂度：O(mn)
    }

    //res = 4 * 岛屿格子数量 - 2 * 岛屿格子之间的相邻边
//    for(int i=0; i<m; i++){
//        for(int j=0; j<n; j++){
//            if(grid[i][j] == 0) continue;
//            count++;
//
//            if(j+1 < n && grid[i][j+1] == 1)    edge++; // 判断右边是不是 陆地格子
//
//            if(i+1 < m && grid[i+1][j] == 1)    edge++; // 判断下面是不是 陆地格子
//        }
//    }
//  return 4 * count - 2 * edge;


//    深度优先搜索

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    private int islandPerimeter1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1){
                    ans+=dfs(i,j,grid,n,m);
                }
            }
        }
        return ans;
    }

    private int dfs(int x,int y,int[][] grid,int n,int m){

        if (x<0||x>=n||y<0||y>=m||grid[x][y]==0){
            return 1;
        }

        if (grid[x][y]==2){
            return 0;
        }

        grid[x][y]=2;
        int res=0;
        for (int i = 0; i < 4; i++) {
            int tx = x+dx[i];
            int ty = y+dy[i];
            res+=dfs(tx,ty,grid,n,m);
        }
        return res;
    }



}
