/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * 状态转移方程: dp[j] = dp[j-1] + dp[j](向右、向下)
 */
public class unique_paths_62 {
    public static void main(String[] args){
        int m = 7;
        int n = 3;
        System.out.println(new unique_paths_62().uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[j] = dp[j-1]+dp[j];
            }
        }
        return dp[n];
    }
}
