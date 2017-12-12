package BinarySearchTree;
//Given an array with integers, determine whether the array contains a valid postorder traversal sequence a BST.
public class ValidPostOrderTraversal {
    //Solution2: Time: O(nlogn)  Space: O(1)
    public boolean validPostOrder(int[] post) {
        int len = post.length;
        return ValidateBSTHelper(post, 0, len-1);
    }

    private static boolean ValidateBSTHelper(int[] nodes, int start, int end){
        //empty tree and a tree has only one node are BST
        if(end <= start)
            return true;

        int root = nodes[end]; //current root value

        //找到分解点
        int i = end-1;
        while(i >= start && nodes[i]>root){
            i--;
        }
        int left = i;
        while(i >= start && nodes[i]<root){
            i--;
        }
        if(i != start-1)
            return false;
        //Recursively check left subtree and right subtree
        return ValidateBSTHelper(nodes, start, left) && ValidateBSTHelper(nodes,left+1,end-1);
    }
}
