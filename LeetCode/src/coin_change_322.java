import java.util.*;

/**
 * 子结构/状态：sum[k]，其值为所需的最小硬币数
 * 状态转移方程：sum[k] = min(sum[k-coin[0]] , sum[k-coin[1]], ...)+1, 要利用此最优子结构，要先将sum[k]=infinite
 **/

public class coin_change_322 {

    public static void main(String[] args){
        int[] coins = new int[]{2};
        int amount = 3;
        int minCoins = new coin_change_322().coinChange(coins, amount);
        System.out.println(minCoins);


//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//
//        }
    }

    public int coinChange(int[] coins, int amount) {
        int[] sum = new int[amount+1];    //保存带找零为k时需要的最小硬币数
        int max = amount + 1;
        Arrays.fill(sum, max);
        sum[0] = 0;

        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j] >= 0){
                    sum[i] = Math.min(sum[i], sum[i-coins[j]] + 1);
                }
            }
        }
        return sum[amount]==max? -1:sum[amount];
    }
}
