package binarytree.Reconstruct;

import java.util.HashMap;
// inorder 左子树 根 右子树
//postorder 左子树 右子树 根
public class PostOrderAndInorder {
    public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;++i) {
            hm.put(inorder[i], i);
        }

        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0,
                postorder.length-1,hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
                                     HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        //root一定是postorder的最后
        TreeNode root = new TreeNode(postorder[pe]);
        int inMid = hm.get(postorder[pe]);

        //inMid-is 是左子树的大小
        //post的左子树 从ps开始因为根在后面，ps+inMid-is-1 要减1 因为要减掉根
        //post的右子树 要跳过左子树的部分才是右子树的开始，pe -1 因为根在后面
        root.left = buildTreePostIn(inorder, is, inMid-1, postorder, ps, ps+inMid-is-1, hm);
        root.right = buildTreePostIn(inorder,inMid+1, ie, postorder, ps+inMid-is, pe-1, hm);

        return root;
    }
}
