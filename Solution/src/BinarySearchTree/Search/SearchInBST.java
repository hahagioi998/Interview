package BinarySearchTree.Search;


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
            //找到值要每一层都传上来
            //相当于 TreeNode node = search(root.right, key); return node;
            return search(root.right, key);
        }else{
            return search(root.left, key);
        }
    }
}
