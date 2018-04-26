/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 输入: [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 输出: 2
 *
 * 状态转移方程: dp[j] = dp[j-1] + dp[j](向右、向下)
 *
 */
public class unique_paths2_63 {
    public static void main(String[] args){
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(new unique_paths2_63().uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(obstacleGrid[i-1][j-1] != 1)
                    dp[j] = dp[j-1]+dp[j];
                else
                    dp[j] = 0;
            }
        }
        return dp[n];
    }
}
