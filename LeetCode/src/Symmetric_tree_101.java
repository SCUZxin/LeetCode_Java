/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class Symmetric_tree_101 {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(3);
        System.out.println(new Symmetric_tree_101().isSymmetric(tree));
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isEqual(root.left, root.right);
    }
    public boolean isEqual(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if( root1== null || root2 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        return isEqual(root1.left, root2.right)&&isEqual(root1.right, root2.left);
    }
}
