import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一组不同的整数 nums，返回所有可能的子集（幂集）。注意事项：自己中的元素非减排序，该解决方案集不能包含重复的子集。
 */
public class subsets_78 {

    public static void main(String[] args){
        int[] nums = new int[]{1,2,2};

        System.out.println(new subsets_78().subsets(nums));
    }

    //牛客
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> subSetList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(S);
        for(int i=0;i<=S.length;i++)
            backtracking(0, i, S, list, subSetList);  // nums中取i个元素

        return subSetList;
    }

    //LeetCode
//    public List<List<Integer>> subsets_1(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//        List<List<Integer>> subSetList = new ArrayList<>();
//        Arrays.sort(nums);
//        for(int i=0;i<=nums.length;i++)
//            backtracking(0, i, nums, list, subSetList);  // nums中取i个元素
//
//        return subSetList;
//    }

    public void backtracking(int index, int num, int[] nums, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> subSetList){
        if(num<0) return;
        if(num == 0){
            subSetList.add(new ArrayList<>(list));
        }

        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            backtracking(i+1, num-1, nums, list, subSetList);
            list.remove(list.size()-1);
        }
    }
}
