package binarytree.LCA;

import java.util.ArrayList;
import java.util.Collections;
//用preorder
/*
    Approach :

    since it’s not a binary search tree, we can­not use binary search tech­nique to reach to the TreeNode. we need to travel all the TreeNodes in order to find the TreeNode

    Start from the root and com­pare it with x, if matched then we have found the TreeNode.
    Else go left and right.
            Recur­sively do step 2 and 3 till you find the TreeNode x.
    Now when you have found the TreeNode, stop the recursion.
            Now while going back to the root while back track­ing, store the TreeNode val­ues in the ArrayList.
    ReversalAndRotation the ArrayList and print it.
 */
class PathFromRootToTreeNode {
    public static ArrayList path;
    public Boolean printPath(TreeNode root, TreeNode dest){
        if(root==null) return false;
        if(root==dest||printPath(root.left,dest)||printPath(root.right,dest)){
            //System.out.print("  " + root.data);
            path.add(root.data);
            return true;
        }
        return false;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode (2);
        root.right = new TreeNode (3);
        TreeNode n1 = new TreeNode (4);
        root.left.left = n1;
        root.left.right = new TreeNode (5);
        TreeNode n2 = new TreeNode (8);
        root.left.right.right = n2;
        root.left.right.left = new TreeNode (7);

        PathFromRootToTreeNode i = new PathFromRootToTreeNode();
        path = new ArrayList();
        i.printPath(root,n2);
        Collections.reverse(path);
        System.out.println(" Path " + path);
    }

}
