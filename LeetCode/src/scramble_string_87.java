import java.util.Arrays;

/**
 * 扰乱字符串
 *  思路：从简单情况开始，
 *  1.两个字符串都只有一个字符时只需比较是否相等
 *  2.字符个数大于一时，先判断长度是否相等，在判断是否由相同的字符组成，若否则直接返回false
 *  3.分隔字符串，有两种情况，一种是不交换，一种是左右交换
 */
public class scramble_string_87 {

    public static void main(String[] args){
        String s1 = "great";
        String s2 = "rgtae";
        System.out.println(new scramble_string_87().isScramble(s1, s2));
    }

    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if(len != s2.length())
            return false;
        if(len == 1)
            return s1.equals(s2);

        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        Arrays.sort(chs1);
        Arrays.sort(chs2);
        if(!(new String(chs1).equals(new String(chs2)))){
            return false;
        }

        for(int i=1;i<len;i++){
            //当前分割出没有交换
            if(isScramble(s1.substring(0,i), s2.substring(0,i))
                    && isScramble(s1.substring(i), s2.substring(i))){
                return true;
            }

            //当前分割出交换---左右交换
            if(isScramble(s1.substring(0,i), s2.substring(len-i))
                    && isScramble(s1.substring(i), s2.substring(0,len-i))){
                return true;
            }
        }
        return false;
    }
}


