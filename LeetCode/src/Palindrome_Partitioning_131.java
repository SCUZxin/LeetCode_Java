import java.util.ArrayList;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。eg: s = "aab",   返回 [["aa","b"], ["a","a","b"]]
 * 思路：初始position=0，position--i(position--n) 采用DFS 判断是不是回文字符串，是就list.add()，然后DFS后记住 list.remove()<未访问过>
 */

public class Palindrome_Partitioning_131 {
    public static void main(String[] args){
        String s = "aab";
        System.out.println(new Palindrome_Partitioning_131().partition(s));
    }

    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        dfs(s, 0, list, res);
        return res;
    }

    public void dfs(String s, int pos, ArrayList<String> list, ArrayList<ArrayList<String>> res){
        if(pos == s.length())
            res.add(new ArrayList(list));     //访问到最后一个字符时，加入res
        else{
            for(int i=pos;i<s.length();i++){
                if(isPalindrome(s,pos,i)){
                    list.add(s.substring(pos, i+1));
                    dfs(s, i+1, list, res);
                    list.remove(list.size()-1); //移除最后一个，看作还未访问
                }
            }
        }
    }

    /*
    判断字符串是否为回文
     */
    public boolean isPalindrome(String s, int low, int high){
        while(low<high){
            if(s.charAt(low++) != s.charAt(high--)){
                return false;
            }
        }
        return true;
    }
}
