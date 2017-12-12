package BinarySearchTree.ReconstructBST;

import java.util.LinkedList;
import java.util.Queue;

/*
The idea is to use a queue to construct tree. Every element of queue has a structure say NodeDetails which stores details of a tree node. The details are pointer to the node, and two variables min and max where min stores the lower limit for the node values which can be a part of the left subtree and max stores the upper limit for the node values which can be a part of the right subtree for the specified node in NodeDetails structure variable. For the 1st array value arr[0], create a node and then create a NodeDetails structure having pointer to this node and min = INT_MIN and max = INT_MAX. Add this structure variable to a queue. This Node will be the root of the tree. Move to 2nd element in arr[] and then perform the following steps:

Pop NodeDetails from the queue in temp.
Check whether the current array element can be a left child of the node in temp with the help of min and temp.node data values. If it can, then create a new NodeDetails structure for this new array element value with its proper ‘min’ and ‘max’ values and push it to the queue, make this new node as the left child of temp’s node and move to next element in arr[].
Check whether the current array element can be a right child of the node in temp with the help of max and temp.node data values. If it can, then create a new NodeDetails structure for this new array element value with its proper ‘min’ and ‘max’ values and push it to the queue, make this new node as the right child of temp’s node and move to next element in arr[].
Repeat steps 1, 2 and 3 until there are no more elements in arr[].
For a left child node, its min value will be its parent’s ‘min’ value and max value will be the data value of its parent node. For a right child node, its min value will be the data value of its parent node and max value will be its parent’s ‘max’ value.
 用while loop, 因为不是一个complete tree，while loop比较好操作
 需要用min和max，用一个新的node class来做记录
 */
public class ReconstructBSTWithLevelOrder {
    public TreeNode reconstruct(int[] level) {
        Queue<NodeDetail> queue = new LinkedList<>();
        TreeNode root = new TreeNode(level[0]);
        NodeDetail rootD = new NodeDetail(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        queue.offer(rootD);
        int i = 1;
        while(i < level.length){
            NodeDetail cur = queue.poll();

            if(i < level.length && level[i] < cur.node.key && level[i] > cur.min){
                cur.node.left = new TreeNode(level[i++] );
                NodeDetail leftNode = new NodeDetail(cur.node.left, cur.min, cur.node.key);
                queue.offer(leftNode);
            }

            if(i < level.length && level[i] > cur.node.key && level[i] < cur.max){
                cur.node.right = new TreeNode(level[i++]);
                NodeDetail rightNode = new NodeDetail(cur.node.right, cur.node.key, cur.max);
                queue.offer(rightNode);
            }
        }
        return root;
    }

    static class NodeDetail{
        TreeNode node;
        int min, max;
        NodeDetail(TreeNode node, int min, int max){
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

    public void displayTree(TreeNode root) {
        if (root != null) {
            displayTree(root.left);
            System.out.print(" " + root.key);
            displayTree(root.right);
        }
    }

    public static void main(String args[]) {
        ReconstructBSTWithLevelOrder p = new ReconstructBSTWithLevelOrder();
        int[] preOrder = {20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40};
        int[] preOrder2 = {2, 1, 3};
        int[] pIndex = new int[]{0};
        TreeNode root = p.reconstruct(preOrder2);
        System.out.println("Inorder Traversal of Constructed Tree : ");
        p.displayTree(root);
    }
}
