package BinarySearchTree;

//当找的时候，就有三种情况，相等，小于，大于
public class SearchInBST {
    public TreeNode search(TreeNode root, int key) {
        // Write your solution here.
        if(root == null){
            return null;
        }

        if(root.key == key){
            return root;
        }else if(root.key < key){
            return search(root.right, key);
        }else{
            return search(root.left, key);
        }
    }
}
