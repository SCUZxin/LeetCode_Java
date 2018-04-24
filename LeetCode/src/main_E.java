import java.util.Arrays;
import java.util.Scanner;

public class main_E {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int T = in.nextInt();
            long[] ret = new long[T];
            for(int k=0;k<T;k++){
                Arrays.fill(Cnt, 0);
                Arrays.fill(Count, 0);
                //Arrays.fill(p, 0);
                long N = in.nextInt();
                long M = 0;
                for(int i = 0; i < N; ++i)
                {
                    M = in.nextInt();
                    calculate(M);
                }
                long res = 0;
                for(int i = 2; i <= 10000; ++i)
                {
                    if((Cnt[i]&1)!=0)
                        res += C(Count[i]);
                    else res -= C(Count[i]);
                }
                ret[k]=C(N)-res;

            }

            for(int i=0;i<T;i++){
                System.out.println(ret[i]);
            }
        }
    }

    public static long C(long N){ //计算C(N, 4)
        return N * (N-1) * (N-2) * (N-3) / 24;
    }

    static int n;
    static int ct;
    static long[] Cnt = new long[10009];
    static long[] Count = new long[10009];
    static long[] p = new long[100];//p---Factor

    public static void Divide(long N){ //将N分解质因数
            ct = 0;
            for(int i = 2; i <= Math.sqrt(N*1.0); ++i)
            {
                if(N % i == 0)
                {
                    p[ct++] = i;
                    while(N % i == 0)
                        N /= i;
                }
            }
            if(N > 1)
                p[ct++] = N;
    }

    public static void calculate(long N){
        Divide(N);

        for(int i = 1; i < (1<<ct); ++i)
        {
            int mult = 1;
            int cnt = 0;
            for(int j = 0; j < ct; ++j)
            {
                if((i & (1<<j)) != 0)
                {
                    ++cnt;
                    mult *= p[j];
                }
            }
            Count[mult]++;
            Cnt[mult] = cnt;
        }
    }
}

//3
//4
//2 4 6 1
//5
//1 2 4 6 8
//10
//12 46 100 131 5 6 7 8 9 10