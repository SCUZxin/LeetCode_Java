import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点
 */
public class path_sum_113 {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(9);
        tree.left.left = new TreeNode(8);
        tree.right.left = new TreeNode(8);
        tree.right.right = new TreeNode(3);
        System.out.println(new path_sum_113().pathSum(tree, 17));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> retLists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, sum, retLists, list);
        return retLists;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> retLists, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left == null && root.right == null && sum == root.val) {
            retLists.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
        }
        else{
            dfs(root.left, sum-root.val, retLists, list);
            dfs(root.right, sum-root.val, retLists, list);
            list.remove(list.size() - 1);
        }
    }
}
