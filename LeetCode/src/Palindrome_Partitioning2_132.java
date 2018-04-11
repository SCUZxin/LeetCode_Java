import java.util.Arrays;

/**
 * 回文的最小分割数
 * 1.dp[i]表示当前i到len-1这段的最小分割数
 * 2.dp[i]=min{dp[j+1]+1}（i=<j<len）其中str[i..j]必须是回文、
 * 3.p[i][j]=true表示str[i..j]是回文
 * 4.p[i][j]=s.charAt(i)==s.charAt(j) && (j-i<2||p[i+1][j-1])
 */
public class Palindrome_Partitioning2_132 {
    public static void main(String[] args){
        String s = "cdd";
        System.out.println(new Palindrome_Partitioning2_132().minCut(s));
    }

    /*
    法一
     */
    public int minCut(String s) {
        int max = s.length();
        int[] dp = new int[s.length()+1];
        boolean[][] p = new boolean[s.length()][s.length()];
        Arrays.fill(dp,max);
        dp[s.length()] = -1;//确保dp[s.length()-1]+1=0
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
//                System.out.println(s.substring(i,j+1));
//                System.out.println("i,j:"+i+"  "+j);
                if(s.charAt(i)==s.charAt(j) && (j-i<2||p[i+1][j-1])){
                    p[i][j] = true;
                    dp[i] = Math.min(dp[j+1]+1, dp[i]);
                }
//                System.out.println("dp[i]:"+dp[i]);
            }
        }

        return dp[0];
    }

    /*
    法二
     */
    public int minCut2(String s) {
        int max = s.length();
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,max);
        dp[s.length()] = -1;//使得dp[s.length()-1]+1=0
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                //System.out.println(s.substring(i,j+1));
                //System.out.println("i,j:"+i+"  "+j);
                if(isPalindrome(s.substring(i,j+1))){
                    dp[i] = Math.min(dp[j+1]+1, dp[i]);
                }
                //System.out.println("dp[i]:"+dp[i]);
            }
        }

        return dp[0];
    }

    /*
    判断字符串是否为回文
     */
    public static boolean isPalindrome(String s){
        int low=0;
        int high=s.length()-1;
        while(low<high){
            if(s.charAt(low++) != s.charAt(high--)){
                return false;
            }
        }
        return true;
    }
}
