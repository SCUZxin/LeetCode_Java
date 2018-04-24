import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码
 */
public class gray_code_89 {
    public static void main(String[] args){
        int n = 2;
        System.out.println(new gray_code_89().grayCode(n));
    }

    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(n==0){
            arr.add(0);
            return arr;
        }else{
            arr.add(0);
            arr.add(1);
            for(int i=1;i<n;i++){
                int size = arr.size();
                for(int j=size-1;j>=0;j--){
                    arr.add(arr.get(j)+(1<<i));
                }
            }
        }
        return arr;
    }

    //移位法
    public List<Integer> grayCode1(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int num = 1 << n;

        System.out.println(num);
        for(int i = 0; i < num; ++i){
            System.out.println(i>>1);
            arr.add(i>>1^i);//先右移一位，再‘或’运算
        }
        return arr;
//00  00  00
//01  00  01
//10  01  11
//11  01  10
    }
}
