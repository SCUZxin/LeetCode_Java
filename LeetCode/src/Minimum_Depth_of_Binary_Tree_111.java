import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Minimum_Depth_of_Binary_Tree_111 {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        System.out.println(new Minimum_Depth_of_Binary_Tree_111().minDepth(tree));
    }

    /**
     * 思路1：
     * 深度优先遍历（DFS）
     * 如果当前节点是空，则最小深度为 0，返回
     * 效率低
     * @param root
     * @return
     */
//    public int minDepth(TreeNode root) {
//        if(root == null)
//            return 0;
//        int l = minDepth(root.left);
//        int r = minDepth(root.right);
//        if(l==0 || r == 0)
//            return l+r+1;
//        return Math.min(l,r)+1;
//    }

    /**
     * 思路2：
     * 广度优先遍历（BFS）
     * 找到第一个叶子结点就可以停止遍历
     * 效率高
     */
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            level ++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode v = queue.remove();//移除队头元素
                if(v.left == null && v.right == null){
                    return level;
                }
                if(v.left != null){
                    queue.add(v.left);
                }
                if(v.right != null){
                    queue.add(v.right);
                }
            }
        }
        return 0;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
