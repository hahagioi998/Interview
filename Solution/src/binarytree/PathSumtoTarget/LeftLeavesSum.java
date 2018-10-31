package binarytree.PathSumtoTarget;



public class LeftLeavesSum {

    // Do the inorder traversal
    // check if node if the left child and leaf node
        //how do we know it's left child
            //1. we need parent node, just need to pass parent
                //to pass parent we need traversal needs stack too tedious
            //2. whenever we go left, pass true
    // if yes then add it to the sum
    public static int leftLeavesSum = 0;


/*  Method 1
    public static void leftSum(Node root, Node parent) {//for root parent is root
        if (root != null) {
//            leftSum(root.left, root); can put here too use inorder
            if (root.left == null && root.right == null && parent.left == root) {
                leftLeavesSum += root.data;
            }
            leftSum(root.left, root);//user preorder
            leftSum(root.right, root);
        }
    }
    */
//Method 2
    public static void leftSum(Node root, Boolean left) {//for root parent is root
        if (root != null) {
//            leftSum(root.left, root); can put here too use inorder
            //只有叶节点才加
            if (root.left == null && root.right == null && left == true) {
                leftLeavesSum += root.data;
            }
            leftSum(root.left, true);//user preorder
            leftSum(root.right, false);
        }
    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(10);
        root.left.right = new Node(12);
        root.left.right.left = new Node(6);
        root.right.right = new Node(8);
        root.right.right.left = new Node(5);
//        leftSum(root, root);
        leftSum(root, false);
        System.out.println("Sum of left leaves: " + leftLeavesSum);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

