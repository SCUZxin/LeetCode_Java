/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 一个二叉搜索树具有如下特征：
 *      节点的左子树只包含小于当前节点的数。
 *      节点的右子树只包含大于当前节点的数。
 *      所有左子树和右子树自身必须也是二叉搜索树。
 */
public class validate_binary_search_tree_98 {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.right.left = new TreeNode(3);
        tree.right.left = new TreeNode(6);
        System.out.println(new validate_binary_search_tree_98().isValidBST(tree));
    }

    //方法1：每个结点都对应一个上限，一个下限
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return isValidRoot(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidRoot(TreeNode root, long lower, long upper){
        if(root == null)
            return true;
        if(root.val >= upper || root.val <= lower)
            return false;
        return isValidRoot(root.left, lower, root.val) && isValidRoot(root.right, root.val, upper);
    }

    //方法2：中序遍历，记录前一个结点，与当前结点的值比较。
    TreeNode pre;
    boolean isValid = true;
    public boolean isValidBST_1(TreeNode root) {
        if(root == null)
            return true;
        inOrderTraversal(root);
        return isValid;
    }
    public void inOrderTraversal(TreeNode root){
        if(root == null)
            return;
        inOrderTraversal(root.left);
        if(pre != null && pre.val >= root.val)
            isValid = false;
        pre = root;
        inOrderTraversal(root.right);
    }

}
