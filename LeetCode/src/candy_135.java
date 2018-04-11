import java.util.*;

/**
 * candy[i] = 1
 * 从左向右：rating[i]>rating[i-1], candy[i]=candy[i-1]+1
 * 从右向左: rating[i]>rating[i+1], candy[i]=candy[i+1]+1
 * 两个中取最大的
 * Time complexity : O(n)
 * Space complexity : O(n)
 */
public class candy_135 {
    public static void main(String[] args){
        int[] ratings = new int[]{2,6,9,2,1,6};
        System.out.println(new candy_135().candy(ratings));
    }

    public int candy(int[] ratings){
        int[] candy = new int[ratings.length];
        Arrays.fill(candy,1);

        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i] = candy[i-1]+1;
            }
        }
        int sum = candy[ratings.length-1];
        for(int j=ratings.length-2;j>=0;j--){
            if(ratings[j] > ratings[j+1]){
                candy[j] = Math.max(candy[j], candy[j+1]+1);
            }
            sum += candy[j];
        }
        return sum;
    }
}
