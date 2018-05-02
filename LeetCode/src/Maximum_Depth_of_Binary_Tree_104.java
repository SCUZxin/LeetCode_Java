import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Maximum_Depth_of_Binary_Tree_104 {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        System.out.println(new Maximum_Depth_of_Binary_Tree_104().maxDepth(tree));
    }

    /**
     * 思路1：DFS
     * 思路2：
     * 广度优先遍历（BFS）
     * 找到第一个叶子结点就可以停止遍历
     * 效率高
     */
    public int maxDepth(TreeNode root) {
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
                    continue;
                }
                if(v.left != null){
                    queue.add(v.left);
                }
                if(v.right != null){
                    queue.add(v.right);
                }
            }
        }
        return level;
    }
}

//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x){
//        val = x;
//    }
//}
