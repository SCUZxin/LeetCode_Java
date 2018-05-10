import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class binary_tree_inorder_traversal_94 {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(0);
        tree.left.left = new TreeNode(5);
        tree.right.right = new TreeNode(1);
        System.out.println(new binary_tree_inorder_traversal_94().inorderTraversal(tree));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }
}
