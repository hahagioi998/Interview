package binarytree.BasicTreeTraversal;

public class ReverseBinaryTree {
    public Node reverse(Node root) {
        if(root == null){
            return root;
        }
        // Write your solution here.
        if(root.left == null){
            return root;
        }

        Node newRoot = reverse(root.left);
        //重点是root.left和newRoot还是连着的 root.left is newRoot at the bottom
        root.left.left = root;
        root.left.right = root.right;
        root.left = null;//have to set them null
        root.right = null;
        return newRoot;

        //need to know iterative method also
    }
}
