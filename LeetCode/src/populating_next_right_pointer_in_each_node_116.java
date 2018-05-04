/**
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，
 * 则将 next 指针设置为 NULL。 初始状态下，所有 next 指针都被设置为 NULL。
 * 说明:
     你只能使用额外常数空间。
     使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     你可以假设它是一个完美二叉树（即所有叶子节点都在同一层，每个父节点都有两个子节点）。
 * 
 */
public class populating_next_right_pointer_in_each_node_116 {
    public static void main(String[] args){
        TreeLinkNode tree = new TreeLinkNode(1);
        tree.left = new TreeLinkNode(2);
        tree.right = new TreeLinkNode(3);
        tree.left.left = new TreeLinkNode(4);
        tree.left.right = new TreeLinkNode(5);
        tree.right.left = new TreeLinkNode(6);
        tree.right.right = new TreeLinkNode(7);
        new populating_next_right_pointer_in_each_node_116().connect(tree);
    }

    /**
     * 不使用递归
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        TreeLinkNode p, q;
        p = root;
        while(p.left != null){
            q = p;
            while(q != null){
                q.left.next = q.right;
                if(q.next != null)  //否则  q.right.next = null;
                    q.right.next = q.next.left;
                q = q.next;
            }
            p = p.left;
        }
    }

    /**
     * 使用递归
     * @param root
     */
    public void connect1(TreeLinkNode root) {
        if(root == null)
            return;
        if(root.left != null && root.right != null){
            if(root.next == null)
                root.right.next = null;
            else
                root.right.next = root.next.left;
            if(root.right != null)
                root.left.next = root.right;
            connect(root.left);
            connect(root.right);
        }
    }
}

class TreeLinkNode{
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int val){
        this.val = val;
    }
}
