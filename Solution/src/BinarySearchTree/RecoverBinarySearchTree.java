package BinarySearchTree;

//使用了inorder，inorder的顺序会得出一个递增序列
public class RecoverBinarySearchTree {
    TreeNode firstNode = null;//need to use global variable, java is pass by value
    TreeNode secondNode = null;

    //要和前面比较所以需要一个prev node

    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public TreeNode recover(TreeNode root) {
        // inorder traversal of BST
        helper(root);

        //swap只要swap value就可以了
        int temp = firstNode.key;//will throw nullpointerexeption when global variable not used
        firstNode.key = secondNode.key;
        secondNode.key = temp;
        return root;
    }

    private void helper(TreeNode root){
        if(root == null){
            return;
        }

        helper(root.left);
        //两种情况，一个是在root的同一边换了，一个是在root的不同边
        //但一定是更大的数（firstnode）被换到前面来了，小数（secondNode）被换到后面去了，所以第一个node是prev，第二个node是root
        //还没有找到firstNode的时候 && prev.key > root.key
        if(firstNode == null && prev.key > root.key){
            firstNode = prev;// point to prev
        }
        //找到firstNode的时候 && prev.key > root.key
        if(firstNode != null && prev.key > root.key){
            secondNode = root;
        }

        prev = root; //reset prev for each root before goes to right

        helper(root.right);
    }
}
