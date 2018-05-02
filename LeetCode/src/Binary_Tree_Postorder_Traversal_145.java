import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * 巧妙的方法：前序遍历 根->左->右 变成 根->右->左 结果再reverse一下
 *  此时：入栈时，node.left 先入栈，node.right 后入栈
 */
public class Binary_Tree_Postorder_Traversal_145 {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(3);
        System.out.println(new Binary_Tree_Postorder_Traversal_145().postorderTraversal(tree));
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return postList;
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            postList.add(node.val);
            if(root.left != null)
                stack.push(root.left);
            if(root.right != null)
                stack.push(root.right);
        }
        Collections.reverse(postList);
        return postList;
    }
}
