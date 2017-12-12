package BinarySearchTree;

public class DeleteInBST {
    public TreeNode delete(TreeNode root, int key) {
        //传进去一个node，传出来一个node
        if(root == null){
            return root;
        }
        if(root.key > key){
            root.left = delete(root.left, key);
        }else if(root.key < key){
            root.right = delete(root.right, key);
        }else{
            if(root.right == null){
                return root.left;// return newroot of subtree
            }else if(root.left == null){
                return root.right;//return newroot of subtree
            }else if(root.right.left == null){//don't have smallest in right subtree
                root.right.left = root.left;//move left subtree
                return root.right;
            }else{
                TreeNode newRoot = deleteSmallest(root.right);//get smallest
                newRoot.left = root.left;
                newRoot.right = root.right;
                return newRoot;
            }
        }

        return root;
    }

    private TreeNode deleteSmallest(TreeNode root){//find the smallest in right substree
        while(root.left.left != null){//stop at parent of smallest
            root = root.left;
        }
        TreeNode smallest = root.left;
        root.left = root.left.right;//get right subtree of smallest and delete smallest
        return smallest;//return smallest
    }
}
