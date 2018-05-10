import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 返回其层次遍历结果：
 * [[15,7], [9,20], [3]]
 */
public class binary_tree_level_order_traversal2_107 {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(0);
        tree.left.left = new TreeNode(5);
        tree.right.right = new TreeNode(1);
        System.out.println(new binary_tree_level_order_traversal2_107().levelOrderBottom(tree));
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            ret.add(0, list);
        }
        return ret;
    }
}
