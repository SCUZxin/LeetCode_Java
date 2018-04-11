import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class word_break2_140 {

    public static void main(String[] args){
//        String s = "abcd";
//        System.out.println(s.substring(4,4).length());

        String s = "catsanddog";
//        Set<String> dict = new HashSet<>();
        List<String> dict = new ArrayList<>();
        dict.add("cat");dict.add("cats");dict.add("and");dict.add("sand");dict.add("dog");
        System.out.println(new word_break2_140().wordBreak(s, dict));
    }

    //LeetCode
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> retList = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        int len = s.length();
        dfs(s, len, wordDict, retList, strings);

        return retList;
    }

    public void dfs(String s, int len, List<String> wordDict, List<String> retList, List<String> strings){
        if(len<=0){//取到字符串最后了
            StringBuffer sb = new StringBuffer();
            int size = strings.size()-1;
            for(int i=size;i>=0;i--){
                sb.append(strings.get(i));
                if(i!=0) {    //没到最后一个
                    sb.append(" ");
                }
            }
            retList.add(sb.toString());
        }

        for(int i=len-1;i>=0;i--){
            if(wordDict.contains(s.substring(i,len))){
                strings.add(s.substring(i,len));
                dfs(s, i,wordDict, retList,strings);
                strings.remove(strings.size()-1);
            }
        }
    }


    //牛客
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> retList = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        int len = s.length();
        //dfs(s, len, dict, retList, strings);

        return retList;
    }


}
