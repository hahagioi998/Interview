package binarytree.Reconstruct;

import java.util.HashMap;
import java.util.Map;
// preorder 根 左子树 右子树
// inorder 左子树 根 右子树
public class PreorderAndInorder {
    public TreeNode reconstruct(int[] in, int[] pre) {
        // preorder traversal = {5, 3, 1, 4, 8, 11}
// inorder traversal = {1, 3, 4, 5, 8, 11}
        Map<Integer, Integer> inIndex = indexMap(in);
        return helper(pre, inIndex, 0, in.length - 1, 0, pre.length - 1);
    }

    //create an map from INORDER that key is the number in array, and index and value
    private Map<Integer, Integer> indexMap(int[] in){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++){
            map.put(in[i], i);
        }
        return map;
    }

    private TreeNode helper(int[] pre, Map<Integer, Integer> inIndex, int inLeft, int inRight, int preLeft, int preRight){
        //不断缩减inorder的index
        if(inLeft > inRight){
            return null;
        }
        //preOrder所以root一定在最左边
        TreeNode root = new TreeNode(pre[preLeft]);//create a treeNode

        int inMid = inIndex.get(root.key);//find middle value

        //inMid - inLeft 给出了左边树的大小   inMid - inRight + 1 给出了右边树的大小 ？
        //pre的左边 从preLeft + 1 因为根在前面 ，右边界加上左子树的大小就好了
        root.left = helper(pre, inIndex, inLeft, inMid - 1, preLeft + 1, preLeft + inMid - inLeft);
        //inMid - inLeft is the size of left subtree
        root.right = helper(pre, inIndex, inMid + 1, inRight, preRight + inMid - inRight + 1, preRight);
        //这样也是对的
//        root.right = helper(pre, inIndex, inMid + 1, inRight, preLeft + inMid - inLeft + 1, preRight);
        return root;
    }
}

class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.key = data;
        left = null;
        right = null;
    }
}