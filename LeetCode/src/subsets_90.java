import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个可能包含重复整数的列表，返回所有可能的子集（幂集）。注意事项：自己中的元素非减排序，该解决方案集不能包含重复的子集。
 */
public class subsets_90 {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,2};

        System.out.println(new subsets_90().subsets(nums));
    }

    //牛客
    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        ArrayList<ArrayList<Integer>> subSetList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(num);
        dfs(0, num, list, subSetList);  // 从第0个元素开始取数据

        return subSetList;
    }


    public void dfs(int index, int[] nums, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> subSetList){
        subSetList.add(new ArrayList<>(list));

        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1])
                continue;
            list.add(nums[i]);
            dfs(i+1, nums, list, subSetList);
            list.remove(list.size()-1);
        }
    }

}
