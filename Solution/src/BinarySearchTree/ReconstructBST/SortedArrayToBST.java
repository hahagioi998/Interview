package BinarySearchTree.ReconstructBST;


public class SortedArrayToBST {
    private TreeNode buildTree(int[] num, int start, int end) {
        //start超过end才算，等于的话就是还有一个node
        if (start > end) {
            return null;
        }

        //mid
        TreeNode node = new TreeNode(num[(start + end) / 2]);
        //左边是start到mid -1，右边是mid + 1到end
        node.left = buildTree(num, start, (start + end) / 2 - 1);
        node.right = buildTree(num, (start + end) / 2 + 1, end);
        //别忘了返回node，不然上一层就拿不到左边和右边了
        return node;
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null) {
            return null;
        }
        //end index是num.length - 1
        return buildTree(num, 0, num.length - 1);
    }
}
