package BinarySearchTree.Search;

//largest node smaller 应该是左子树的最大值，left child的右边


public class LargestNumberSmallerInBST {
    public int largestSmaller(TreeNode root, int target) {
        // 不断更新这个值
        int largestSmaller = Integer.MIN_VALUE;//you may not find the number
        while(root != null){
            //也就是说在保证target > root.key的情况下，尽量向右找
            if(target > root.key){
                //largestSmaller = Math.max(largestSmaller, root.key);
                largestSmaller = root.key;
                root = root.right;
            }else{
                //target <= root.key
                root = root.left;
            }
        }

        //当root ==null的时候
        return largestSmaller;
    }


}
