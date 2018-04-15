/**
 * dp[i][j]: 表示的是word1的前i个元素和word2的前j个元素由 word1 -> Word2的最少操作次数
 */
public class edit_istance_72 {

    public static void main(String[] args){
        String word1 = "abc";
        String word2 = "bcd";

        System.out.println(new edit_istance_72().minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            dp[i][0] = i;   //delete的步数
        }
        for(int i=0;i<=len2;i++){
            dp[0][i] = i;   //insert的步数
        }

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                // 如果这两个字符相等，那么交由上一种情况处理,如abc，dfc
                // 这种情况与ab，df花费是一样的
                // 不然就要在删除，插入，修改中取花费最小的那个
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
