/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点
 */
public class path_sum_112 {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(8);
        tree.left.left = new TreeNode(11);
        tree.right.left = new TreeNode(13);
        tree.right.right = new TreeNode(4);
        System.out.println(new path_sum_112().hasPathSum(tree, 21));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null){
            if(root.val == sum)
                return true;
            else
                return false;
        }
        else{
            return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
        }
    }
}
