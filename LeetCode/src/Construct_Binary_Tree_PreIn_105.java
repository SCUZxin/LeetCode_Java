/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意: 你可以假设树中没有重复的元素。
 */
public class Construct_Binary_Tree_PreIn_105 {
    public static void main(String[] args){
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        System.out.println(new Construct_Binary_Tree_PreIn_105().buildTree(preorder, inorder));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if(preLen == 0 || inLen == 0)
            return null;

        return build(preorder,0,preLen-1,inorder,0,inLen-1);
    }
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart>preEnd || inStart>inEnd)
            return null;
        int val = preorder[preStart];
        int index = 0;
        int size = 0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==val){
                index=i;
                size = index-inStart;
                break;
            }
        }
        TreeNode root = new TreeNode(val);
        root.left = build(preorder,preStart+1, preStart+size, inorder, inStart, index-1);
        root.right = build(preorder,preStart+size+1, preEnd, inorder, index+1, inEnd);

        return root;
    }
}
