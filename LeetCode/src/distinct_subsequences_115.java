/**
 * 不同子序列: 给定一个字符串 S 和一个字符串 T，求 S 的不同的子序列中 T 出现的个数。
 * dp[i][j]：表示 T[0,j] 在 S[0,i] 中的匹配个数
 * 如果不使用 S[i] , 那么f(i,j) = f(i-1,j)
 * 如果使用了 S[i] , 那么一定有 S[i] == T[j], f(i,j) = f(i-1, j-1)
 * 所以当 S[i]==T[j] 时，dp(i,j) = dp(i-1, j) +　dp(i-1, j-1);
 * 当 S[i]!=T[j] 时，有 dp(i,j) = dp(i-1, j);
 */
public class distinct_subsequences_115 {
    public static void main(String[] args){
        String S = "rabbbit";
        String T = "rabbit";
        System.out.println(new distinct_subsequences_115().numDistinct(S, T));
    }

    public int numDistinct(String s, String t) {
        int Slen = s.length();
        int Tlen = t.length();
        if(Slen == 0 || Tlen == 0 || Slen < Tlen){
            return 0;
        }
        int[][] dp = new int[Slen+1][Tlen+1];
        for(int i=0; i<=Slen; i++) dp[i][0] = 1;
        for(int i=1;i<=Slen;i++){
            for(int j=1;j<=Tlen;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-1];//没使用S[i-1] + 使用S[i-1]
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[Slen][Tlen];
    }
}
