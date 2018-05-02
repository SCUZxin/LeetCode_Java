import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *  法一：使用递归法
 *  法二：使用stack
 *      注意：入栈时，node.right 先入栈，node.left 后入栈
 */
public class Binary_Tree_Preorder_Traversal_144 {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(3);
        System.out.println(new Binary_Tree_Preorder_Traversal_144().preorderTraversal(tree));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
//        Vector<Integer> porderList = new Vector<>();
        List<Integer> porderList = new ArrayList<>();
        if(root == null)
            return porderList;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            porderList.add(node.val);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }

        return porderList;
    }
}
