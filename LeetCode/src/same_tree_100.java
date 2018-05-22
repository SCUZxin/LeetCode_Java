/**
 *
 */
public class same_tree_100 {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(9);
        tree2.right = new TreeNode(20);

        System.out.println(new same_tree_100().isSameTree(tree, tree2));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null  || q == null)
            return false;
        if(p.val != q.val)// p , q 都不为null
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
