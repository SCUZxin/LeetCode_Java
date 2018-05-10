import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 返回其层次遍历结果：
 * [[3], [9,20], [15,7]]
 */
public class binary_tree_level_order_traversal_102 {

    public static void main(String[] args){
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(0);
        tree.left.left = new TreeNode(5);
        tree.right.right = new TreeNode(1);
        System.out.println(new binary_tree_level_order_traversal_102().levelOrder(tree));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null)
            return ret;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            ret.add(list);
        }
        return ret;
    }
}
