package BinarySearchTree;


//凡是closest的题一定要想到用Math.abs()
public class ClosestNumberInBST {
    public int closest(TreeNode root, int target) {
        // 二分查找
        int res = root.key;
        //interative
        while(root != null){
            if(target == root.key){
                return root.key;
            }else{
                //通过比较记录
                if(Math.abs(target - root.key) < Math.abs(res - target)){
                    res = root.key;
                }
                if(root.key > target){
                    root = root.left;
                }else{
                    root = root.right;
                }
            }
        }
        return res;
    }
}
class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.key = data;
        left = null;
        right = null;
    }
}