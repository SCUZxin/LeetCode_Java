import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 思路：先序遍历的思想(根左右)+数字求和(每一层都是上层和*10+当前根节点的值)
 */
public class sum_root_to_leaf_129 {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(0);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(1);
        System.out.println(new sum_root_to_leaf_129().sumNumbers(tree));
    }

    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        List<Integer> numList = new ArrayList<>();
        preorder(root, numList, root.val);
        int sum = 0;
        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
        }
        return sum;
    }

    public void preorder(TreeNode root, List<Integer> numList, int num){
        if(root.left == null && root.right == null){
            numList.add(num);
            return;
        }
        if(root.left != null)
            preorder(root.left, numList, num*10 + root.left.val);
        if(root.right != null)
            preorder(root.right, numList, num*10 + root.right.val);
    }
}
