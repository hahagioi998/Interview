package binarytree.BasicTreeTraversal;

import binarytree.BinaryTree;

// (a sibling is a node that has same parent. In a Binary Tree, there can be at most one sibling).
/*
 * This does not print root node even though it has no sibling

This is a typical tree traversal question. We start from root and check if the node has one child, if yes then print the only child of that node. If node has both children, then recur for both the children.
 * Test cases:
 * Null tree
 * Only one node tree
 * All left side tree
 * All right side tree
 * Regular mix tree
 *
 */
public class NodeWithNoSiblings {
    public void printNodes(Node root){
        if(root == null){
            return;
        }
        if(root.left == null || root.right == null){
            if(root.left != null){
                System.out.print(root.left.data + " ");
            }
            if(root.right  != null){
                System.out.print(root.right.data + " ");
            }
        }
        printNodes(root.left);
        printNodes(root.right);
    }

    public static void main(String args[]){
        BinaryTree bt = new BinaryTree();
        Node root = null;
//        root = bt.addNode(10, root);
//        root = bt.addNode(5, root);
//        root = bt.addNode(-1, root);
//        root = bt.addNode(-5, root);
//        root = bt.addNode(20, root);
//        root = bt.addNode(25, root);
        NodeWithNoSiblings nws = new NodeWithNoSiblings();
        nws.printNodes(root);
    }
}
