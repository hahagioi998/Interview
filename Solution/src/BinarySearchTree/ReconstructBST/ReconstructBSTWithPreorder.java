package BinarySearchTree.ReconstructBST;
/*
Method 1 ( O(n^2) time complexity )
The first element of preorder traversal is always root. We first construct the root. Then we find the index of first element which is greater than root. Let the index be ‘i’. The values between root and ‘i’ will be part of left subtree, and the values between ‘i+1’ and ‘n-1’ will be part of right subtree. Divide given pre[] at index “i” and recur for left and right sub-trees.
For example in {10, 5, 1, 7, 40, 50}, 10 is the first element, so we make it root. Now we look for the first element greater than 10, we find 40. So we know the structure of BST is as following.

             10
           /    \
          /      \
  {5, 1, 7}       {40, 50}
We recursively follow above steps for subarrays {5, 1, 7} and {40, 50}, and get the complete tree.
 */
/*
Method 2 ( O(n) time complexity )
The idea used here is inspired from method 3 of this post. The trick is to set a range {min .. max} for every node. Initialize the range as {INT_MIN .. INT_MAX}. The first node will definitely be in range, so create root node. To construct the left subtree, set the range as {INT_MIN …root->data}. If a values is in the range {INT_MIN .. root->data}, the values is part part of left subtree. To construct the right subtree, set the range as {root->data..max .. INT_MAX}.
 */
class Node {

    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class ReconstructBSTWithPreorder {
//    public int pIndex = 0;

    public Node constructTree(int[] preorder, int pIndex[], int min, int max) {
        //base case，左子树不会超过这个界限
        if (pIndex[0] >= preorder.length) {
            return null;
        }

        if (preorder[pIndex[0]] < min || preorder[pIndex[0]] >= max) {
            return null;
        }
        //超过范围就是叶子了

        //preorder[pIndex] > min && preorder[pIndex] < max 先在左边找，超过这个范围就是右子树了

        Node root = new Node(preorder[pIndex[0]]);
        //看preorder里的下一个元素，如果到了length就说明不用再找left和right了
        pIndex[0]++;

        root.left = constructTree(preorder, pIndex, min, root.data);


        root.right = constructTree(preorder, pIndex,
                root.data, max);


        return root;
    }

    public void displayTree(Node root) {
        if (root != null) {
            displayTree(root.left);
            System.out.print(" " + root.data);
            displayTree(root.right);
        }
    }

    public static void main(String args[]) {
        ReconstructBSTWithPreorder p = new ReconstructBSTWithPreorder();
        int[] preOrder = { 20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40 };
        int[] preOrder2 = { 3, 2, 1};
        int[] pIndex = new int[]{0};
        Node root = p.constructTree(preOrder, pIndex, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
        System.out.println("Inorder Traversal of Constructed Tree : ");
        p.displayTree(root);
    }

}
