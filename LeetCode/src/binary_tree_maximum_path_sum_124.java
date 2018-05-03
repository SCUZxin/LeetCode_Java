/**
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
 * 该路径至少包含一个节点，且不需要经过根节点。
 */
public class binary_tree_maximum_path_sum_124 {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(0);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(1);
        System.out.println(new binary_tree_maximum_path_sum_124().maxPathSum(tree));
    }

//    因为maxPathSum不一定经过根节点，所以用maxValue整个遍历过程中出现过的最大值
    int maxValue = 0;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        getMaxPathSum(root);
        return maxValue;
    }
    public int getMaxPathSum(TreeNode node){
        if(node == null)
            return 0;
//        因为节点的值可以为负数，所以最大值取0和子树值的较大者
        int left = Math.max(0, getMaxPathSum(node.left));
        int right = Math.max(0, getMaxPathSum(node.right));
//        如果将当前node作为根节点，那么最大值是node.val+左子树最大值+右子树最大值
        maxValue = Math.max(maxValue, left + right + node.val);
//        只能返回左右子树中较大值加上node.val
        return Math.max(left, right) + node.val;
    }

}
