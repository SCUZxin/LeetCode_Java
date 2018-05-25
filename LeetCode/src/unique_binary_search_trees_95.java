/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class unique_binary_search_trees_95 {
    public static void main(String[] args){
        int n = 7;
        System.out.println(new unique_binary_search_trees_95().numTrees(n));
    }

    /**
     * 确定根节点后，左右字数的节点个数就确定了
     * eg：n=5，root=2，左：1，右：3,4,5 共3个节点，所以节点数是 dp[1]*dp[3]
     * root=1,2,3……n --> 得到最终结果
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if(n<0)
            return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int root=1;root<=i;root++){
                dp[i] += dp[root-1]*dp[i-root];
            }
        }
        return dp[n];
    }
}
