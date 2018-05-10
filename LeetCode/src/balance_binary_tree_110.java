/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class balance_binary_tree_110 {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(8);
//        tree.left.left = new TreeNode(11);
        tree.right.left = new TreeNode(13);
        tree.right.right = new TreeNode(4);
        tree.right.right.right = new TreeNode(4);
        System.out.println(new balance_binary_tree_110().isBalanced(tree));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }
        else
            return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
