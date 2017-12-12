package BinarySearchTree.ReconstructBST;
/*
    1
    /\
  2   3
/  \
4   5
*/
//Depth First Traversals:
//        (a) Inorder (Left, Root, Right) : 4 2 5 1 3
//        (b) Preorder (Root, Left, Right) : 1 2 4 5 3
//        (c) Postorder (Left, Right, Root) : 4 5 2 3 1

//倒着construct，从右子树开始建起
public class ReconstructBSTWithPostOrder {
    public TreeNode reconstruct(int[] post) {
        //assume post is not null
        // no duplicates in bst
        //traverse and construct from post right to left
        // initialize with the right most index，只用index[0]
        int[] index = new int[] {post.length - 1} ;
        return helper(post, index, Integer.MIN_VALUE);
    }

    private TreeNode helper(int[] post, int[] index, int min){
        //since it's bst, the min is the root
        //we use the root value to determine the boundaries of left and right subtree
        // index[0] < 0 因为会index[0]-- root的左边subtree都走完的时候
        // post[index[0]] <= min  因为是走到左子树了，binary search tree，所以肯定tree的右边都大于root的key，右边都走完的时候就会停
        if(index[0] < 0 || post[index[0]] <= min){
            return null;
        }
        //倒着走的话就根右️左
        // index[0]--
        TreeNode root = new TreeNode(post[index[0]--]);
        root.right = helper(post, index, root.key);
        root.left = helper(post, index, min);
        return root;
    }
}
