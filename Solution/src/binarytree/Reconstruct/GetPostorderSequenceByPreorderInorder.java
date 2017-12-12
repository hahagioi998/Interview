package binarytree.Reconstruct;

import apple.laf.JRSUIUtils;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/*
Input:

Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
Preorder traversal pre[] = {1, 2, 4, 5, 3, 6}

Output:
Postorder traversal is {4, 5, 2, 6, 3, 1}

A naive method is to first construct the tree, then use simple recursive method to print postorder traversal of the constructed tree.

We can print postorder traversal without constructing the tree.
The idea is, root is always the first item in preorder traversal and it must be the last item in postorder traversal.
We first recursively print left subtree, then recursively print right subtree.
Finally, print root.
To find boundaries of left and right subtrees in pre[] and in[], we search root in in[], all elements before root in in[] are elements of left subtree and all elements after root are elements of right subtree.
In pre[], all elements after index of root in in[] are elements of right subtree. And elements before index (including the element at index and excluding the first element) are elements of left subtree.
 */
public class GetPostorderSequenceByPreorderInorder {
    HashMap<Integer, Integer> inMap = null;
    //postIndex必须要是global variable或者atomicInteger
    public int[] postOrder(int[] preorder, int[] inorder) {
        int[] post = new int[inorder.length];
        AtomicInteger postIndex = new AtomicInteger(post.length - 1);

        inMap = new HashMap<Integer,Integer>();
        for (int i=0;i< inorder.length;++i) {
            inMap.put(inorder[i], i);
        }
        postOrder(preorder, inorder, post, 0, inorder.length -1, 0, postIndex);
        return post;
    }

    private void postOrder(int[] preorder, int[] inorder, int post[], int low, int high, int preIndex, AtomicInteger postIndex) {
        //low大于high
        if(low > high) {
            return;
        }
        //用preorder来取值，inorder来找区间
        post[postIndex.getAndDecrement()] = preorder[preIndex];
        int root = inMap.get(preorder[preIndex]);

        //因为postorder是倒着，所有要走根右边左边
        //右子树在inorder的边界就是i是in里面的根，左边界就是i+1，右边界就是in.length-1
        //右子数在pre的左边界就是跳过左子树和根 pre + (i - low)+1
        //左子树在inorder里面的边界就是low到i-1
        //左子树在preorder里面的左边界就是跳过根pre + 1
        postOrder(preorder, inorder, post, root+1, high, preIndex + (root - low) + 1, postIndex);
        postOrder(preorder, inorder, post, low, root-1, preIndex + 1, postIndex);
    }

    public static void main(String args[]) {
//        int preorder[] = {10, 5, 3, 21, 20, 18, 9 , 16};
//        int inorder[] = {3, 5, 21, 10, 18, 9, 20, 16};
        int preorder[] = {1, 2, 4, 5, 3, 6};
        int inorder[] = {4, 2, 5, 1, 3, 6};
        GetPostorderSequenceByPreorderInorder ppp = new GetPostorderSequenceByPreorderInorder();
        int postorder[] = ppp.postOrder(preorder, inorder);
        for(int i : postorder) {
            System.out.print(i + " ");
        }
    }
}
