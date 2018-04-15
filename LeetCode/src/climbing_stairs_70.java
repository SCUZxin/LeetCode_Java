/**
 * n阶楼梯。每次你可以爬 1 或 2 个台阶。你有多少种不同的方式可以爬到楼顶呢？
 */
public class climbing_stairs_70 {
    public static void main(String[] args){
        int n = 20;
        System.out.println(new climbing_stairs_70().climbStairs(n));
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
