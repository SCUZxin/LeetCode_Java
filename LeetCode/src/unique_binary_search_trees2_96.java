import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 */
public class unique_binary_search_trees2_96 {
    public static void main(String[] args){
        int n = 3;
        System.out.println(new unique_binary_search_trees2_96().generateTrees(n));
    }

    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<>();
        return build(1,n);
    }
    public List<TreeNode> build(int low, int high){
        List<TreeNode> ret = new ArrayList<>();
        if(low>high) {

            ret.add(null);
            return ret;
        }
        for(int i=low;i<=high;i++){
            List<TreeNode> left = build(low, i-1);
            List<TreeNode> right = build(i+1, high);
            for(int j=0;j<left.size();j++){
                for(int k=0;k<right.size();k++){
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}
