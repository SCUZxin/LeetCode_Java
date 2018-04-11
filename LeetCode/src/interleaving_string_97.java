
/**
 * 交错字符串
 * dp[i][j]代表 chs1[0...i]  chs2[0...j]能否顺序匹配chs3[i+j]
 */
public class interleaving_string_97 {
    public static void main(String[] args){
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        System.out.println(new interleaving_string_97().isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1+len2 != len3)
            return false;
        boolean[][] dp = new boolean[len1+1][len2+1];
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        char[] chs3 = s3.toCharArray();
        //初始化 s1中取0个字符 s2中取0个字符 匹配s3从0开始的0个字符 肯定匹配true
        dp[0][0] = true;
        //s1中取0个, s2中取i个 去和s3中0+i 个匹配
        for(int i=1;i<=len2;i++)
            dp[0][i] = dp[0][i-1] && (chs2[i-1]==chs3[i-1]);
        //s1中取i个，s2中取0个，去和s3中0+i 个匹配
        for(int i=1;i<=len1;i++)
            dp[i][0] = dp[i-1][0] && (chs1[i-1]==chs3[i-1]);
        //s1中取i个，s2中取j个，去和s3中i+j 个匹配
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                dp[i][j] = (dp[i-1][j] && (chs1[i-1]==chs3[i-1+j]))
                        || (dp[i][j-1] && (chs2[j-1]==chs3[i+j-1]));
            }
        }
        return dp[len1][len2];
    }
}
