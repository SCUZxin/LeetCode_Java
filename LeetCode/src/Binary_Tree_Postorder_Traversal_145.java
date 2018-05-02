import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        }
        Collections.reverse(postList);
        return postList;
    }

    /**
     * 这个解法可能是最佳实践，思路清晰，易于理解。
     * 核心思想是用栈做辅助空间，先从根往左一直入栈，直到为空，然后判断栈顶元素的右孩子，如果不为空且未被访问过，
     * 则从它开始重复左孩子入栈的过程；否则说明此时栈顶为要访问的节点（因为左右孩子都是要么为空要么已访问过了），
     * 出栈然后访问即可，接下来再判断栈顶元素的右孩子...直到栈空。
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal_1(TreeNode root) {
        TreeNode p = root, r = null;        //P记录当前节点，r用来记录上一次访问的节点
        Stack<TreeNode> s = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        while(p != null || !s.isEmpty()) {
            if(p != null) {     //左孩子一直入栈，直到左孩子为空
                s.push(p);
                p = p.left;
            } else {
                p = s.peek();
                p = p.right;
                if(p != null && p != r) {   //如果栈顶元素的右孩子不为空，且未被访问过
                    s.push(p);              //则右孩子进栈，然后重复左孩子一直进栈直到为空的过程
                    p = p.left;
                } else {
                    p = s.pop();            //否则出栈，访问，r记录刚刚访问的节点
                    list.add(p.val);
                    r = p;
                    p = null;
                }
            }
        }
        return list;
    }
}
