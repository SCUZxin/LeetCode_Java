import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * dp[i]:表示字符串s[0~i]是否可分的bool值
 */
public class word_break_139 {

    public static void main(String[] args){
        String s = "dogs";
        Set<String> dict = new HashSet<>();
        dict.add("dog");dict.add("gs");dict.add("s");
        System.out.println(new word_break_139().wordBreak(s, dict));
    }

    //LeetCode（形参不同）
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=i-1;j>=0;j--){
//                System.out.println(i+subs);
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }else{
                    dp[i]=false;
                }
            }
        }
        return dp[s.length()];
    }

    //牛客（形参不同）
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=i-1;j>=0;j--){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }else{
                    dp[i]=false;
                }
            }
        }
        return dp[s.length()];
    }


}
