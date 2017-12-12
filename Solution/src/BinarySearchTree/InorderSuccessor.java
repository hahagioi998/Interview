package BinarySearchTree;

import apple.laf.JRSUIUtils;

/*Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * Time complexity O(h)
 * Space complexity O(h)
 *
重点
In Binary Search Tree, Inorder Successor of an input node can also be defined as the node with the smallest key greater than the key of input node.！！
So, it is sometimes important to find next node in sorted order.

1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
Go to right subtree and return the node with minimum key value in right subtree.

2) If right sbtree of node is NULL, then start from root and us search like technique. Do following.
Travel down the tree, if a node’s data is greater than root’s data then go right side, otherwise go to left side.
 */
public class InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //smallest number larger than the node，所有从p出发如果可以的话要先往右走
        if (p.right != null) {
            p = p.right;
            //然后可以的话要往左走
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            //如果p没有右子树，那么就要从root出发，去找p
            //p的parent就是
            return succ(root, p.key);
        }
    }

    private TreeNode succ(TreeNode root, int data) {
        //根据bst的性质来做recursion traversal
        //找到了返回null
        if (root.key == data) {
            return null;
        }
        if (root.key < data) {
            //如果比root比data小，那么要去找更大的右边
            return succ(root.right, data);
        } else {
            //如过root比data大，那么去左边找
            TreeNode s = succ(root.left, data);
            //如果root的左边就是p，那么就返回root，不然就返回s继续找下去
            return s == null ? root : s;
        }
    }
}
