/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意: 你可以假设树中没有重复的元素。
 */
public class Construct_Binary_Tree_InPost_106 {
    public static void main(String[] args){
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        System.out.println(new Construct_Binary_Tree_InPost_106().buildTree(inorder, postorder));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int postLen = postorder.length;
        int inLen = inorder.length;
        if(postLen == 0 || inLen == 0)
            return null;

        return build(inorder,0,inLen-1,postorder,0,postLen-1);
    }
    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){

        if((inStart > inEnd || (postStart > postEnd)))
            return null;
        int val = postorder[postEnd];
        TreeNode root = new TreeNode(val);
        int index = 0;
        for(int i=0;i<=inEnd;i++){
            if(inorder[i] == val) {
                index = i;
                break;
            }
        }
        root.left = build(inorder, inStart, index-1, postorder, postStart, postStart+index-inStart-1);
        root.right = build(inorder, index+1,inEnd, postorder, postStart+index-inStart, postEnd-1);
        return root;
    }
}
