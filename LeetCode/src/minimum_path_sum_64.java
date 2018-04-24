/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 状态转移方程：dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
 */

public class minimum_path_sum_64 {
    public static void main(String[] args) {
        int[][] grid = new int[][]
            {{ 1, 3, 1},
             { 1, 5, 1},
             { 4, 2, 1} } ;
        System.out.println(new minimum_path_sum_64().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int rowLen = grid.length;
        int columnLen = grid[0].length;
        int[][] dp = new int[rowLen+1][columnLen+1];
        for(int i=1;i<=rowLen;i++){
            dp[i][1] = dp[i-1][1]+grid[i-1][0];
        }
        for(int j=1;j<=columnLen;j++){
            dp[1][j] = dp[1][j-1]+grid[0][j-1];
        }
        for(int i=2;i<=rowLen;i++){
            for(int j=2;j<=columnLen;j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[rowLen][columnLen];
    }
}
