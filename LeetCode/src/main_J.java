import java.util.Scanner;

/**
 * n个数中取相邻的一些数，使其和为数 K 的整数倍     0 <= n <= 300,000
 * sum[i][j]表示从i-j的数之和
 * dp[i][j]表示从i-j的数之和能被 K 整除
 */
public class main_J {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int K = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            System.out.println(solutionNum(n, K, a));
        }
    }

    public static int solutionNum(int n, int K, int[] a){
        int num=0;
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                sum = 0;
                for(int k=i;k<=j;k++){
                    sum += a[k];
                }
                if(sum%K == 0 && sum!=0)
                    num++;
            }
        }
        return num;
    }

}
