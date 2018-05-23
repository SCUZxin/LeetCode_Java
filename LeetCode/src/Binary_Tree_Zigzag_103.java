import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class Binary_Tree_Zigzag_103 {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        System.out.println(new Binary_Tree_Zigzag_103().zigzagLevelOrder(tree));
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null)
            return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 0;
        boolean reverse = false;
        while(!queue.isEmpty()){
            size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
                if(reverse){
                    tempList.add(0, node.val);
                }
                else {
                    tempList.add(node.val);
                }
            }
            reverse = !reverse;
            ret.add(tempList);
        }
        return ret;
    }
}
