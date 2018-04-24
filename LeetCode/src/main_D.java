import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 输出自然序列中（0,1,2,3,4,5……）中去除所有含数字2,3,5,7后的第 k 个数
 */
public class main_D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int T = sc.nextInt();
//            int[] k = new int[T];
//            for(int i=0;i<T;i++){
//                k[i] = sc.nextInt();
//            }
//            solution(T, k);
//        }

        int n=1000;
        int num=0;
        for(int i=0;i<n;i++){
            if(!hasTargetNum(i))
                num++;
        }
        System.out.println(num);
    }

    public static void solution(int T, int[] k){
        for(int i=0;i<T;i++){

        }

    }

    public static boolean hasTargetNum(int x){
        List<Integer> target = new ArrayList<>(Arrays.asList(2,3,5,7));
        while(x > 0){
            int num = x%10;//2345
            x = x/10;
            if(target.contains(num))
                return true;
        }
        return false;
    }

}
