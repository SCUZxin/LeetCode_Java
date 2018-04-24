/**
 * 给定一个包含数字的编码消息，请确定解码方法的总数。
 * dp[i]:表示 i--end 的编码总数
 * if S[i-1,i]可以解码 dp[i] = dp[i-1]+dp[i-2]
 * 不能解码：dp[i] = dp[i-1]，0 是特殊情况
 */
public class decode_ways_91 {

    public static void main(String[] args){
        String S = "12";
        System.out.println(new decode_ways_91().numDecodings(S));
    }

    public int numDecodings(String s){
        if(s.length()==0 || s==null || s.charAt(0)=='0')
            return 0;
        char[] chars = s.toCharArray();
        int lenS = s.length();
        int[] dp = new int[lenS+1];
        dp[0] = 1;
        dp[1] = 1;//1个字符解码方法为1
        for(int i=2;i<=lenS;i++){
            //前面一个字符不是'0'则dp[i]至少等于dp[i-1]
            if(chars[i-1]!='0'){
                dp[i] = dp[i-1];
            }
            //判断前一个字符和当前字符是不是可以凑
            if(i>1 && (chars[i-2]=='1' || (chars[i-2]=='2' && chars[i-1]>='0' && chars[i-1]<='6'))){
                dp[i] = dp[i] + dp[i-2];
            }
        }
        return dp[lenS];
    }
}
