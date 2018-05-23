/**
 * 二叉搜索树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 */
public class recover_binary_search_tree_99 {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.right.left = new TreeNode(2);
//        System.out.println(new recover_binary_search_tree_99().recoverTree(tree));
    }

    TreeNode firstElem, secondElem, pre;
    public void recoverTree(TreeNode root) {
        firstElem = secondElem = pre = null;
        //中序遍历
        inOrderTraverse(root);
        int temp = firstElem.val;
        firstElem.val = secondElem.val;
        secondElem.val = temp;
    }
    public void inOrderTraverse(TreeNode root){
        if(root == null)
            return;
        inOrderTraverse(root.left);

        if(pre != null && pre.val > root.val){
            //第一个元素还未找到
            if(firstElem == null){
                firstElem = pre;
                secondElem = root;
            }
            //第一个元素已经确定
            else{
                secondElem = root;
            }
        }
        pre = root;

        inOrderTraverse(root.right);
    }
}
