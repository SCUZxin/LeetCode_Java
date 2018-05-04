/**
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，
 * 则将 next 指针设置为 NULL。 初始状态下，所有 next 指针都被设置为 NULL。
 * 说明:
 你只能使用额外常数空间。
 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 这个问题我们可以通过二叉树的层序遍历进行解决，需要注意的是，对每一层的节点进行对应的层序遍历！
 */
public class populating_next_right_pointer_in_each_node2_117 {
    public static void main(String[] args){
        TreeLinkNode tree = new TreeLinkNode(1);
        tree.left = new TreeLinkNode(2);
        tree.right = new TreeLinkNode(3);
        tree.left.left = new TreeLinkNode(4);
        tree.left.right = new TreeLinkNode(5);
        tree.right.left = new TreeLinkNode(6);
        tree.right.right = new TreeLinkNode(7);
        new populating_next_right_pointer_in_each_node2_117().connect(tree);
    }

    public void connect(TreeLinkNode root) {
        while(root != null){
            //virtual 为新建立的每层第一个节点.  虚拟的 （为了方便后面遍历当前行节点）
            TreeLinkNode virtual = new TreeLinkNode(-1);
            TreeLinkNode cur = virtual;
            while(root != null){
                if(root.left != null){
                    cur.next = root.left;
                    cur = cur.next;
                }
                if(root.right != null){
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            root = virtual.next;
        }
    }
}

