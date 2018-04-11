import java.util.ArrayList;
import java.util.Arrays;


/**
 * 从下往上加的话：
 * dp = int[a.size()], 初始：dp[i] = a.get(a.size()-1).get(i)
 * dp[i] = a[row][i]+min(dp[i],dp[i+1])
 */
public class triangle_120 {

    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3,4)));
        triangle.add(new ArrayList<>(Arrays.asList(6,5,7)));
        triangle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        System.out.println(new triangle_120().minimumTotal(triangle));
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int len = triangle.size();
        ArrayList<Integer> dp = triangle.get(len-1);
        for(int i=len-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                dp.set(j, triangle.get(i).get(j) + Math.min(dp.get(j),dp.get(j+1)));
            }
        }
        return dp.get(0);
    }
}
