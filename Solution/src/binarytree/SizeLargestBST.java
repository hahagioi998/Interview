package binarytree;
//还是比较接近post order traversal的概念
//和isbalanced binary tree是相似的思路
public class SizeLargestBST {
    class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int x)
        {
            this.data = x;
        }
    }

    TreeNode root;

    private int minimum(int a, int b)
    {
        if (a < b) return a;
        return b;
    }

    private int maximum(int a, int b)
    {
        if (a > b) return a;
        return b;
    }


    /*
                            10
                      6             12
                  7      4       9       14
                                      13    16
    */
    private TreeNode createTree()
    {
        this.root = new TreeNode(10);
        TreeNode n1   = new TreeNode(6);
        TreeNode n2   = new TreeNode(12);
        TreeNode n3   = new TreeNode(7);
        TreeNode n4   = new TreeNode(4);
        TreeNode n5   = new TreeNode(9);
        TreeNode n6   = new TreeNode(14);
        TreeNode n7   = new TreeNode(13);
        TreeNode n8   = new TreeNode(16);

        root.left  = n1;
        root.right = n2;

        n1.left  = n3;
        n1.right = n4;

        n2.left  = n5;
        n2.right = n6;

        n6.left = n7;
        n6.right = n8;

        return root;
    }

    private int findSizeOfLargestBST(TreeNode currentNode, int[] min, int[] max, boolean[] isBST, int[] maxBSTSize)
    {
        //对每一个node做isBST的检查，就不能是想preorder traversal只传当前的root值做为边
        // preorder traversal可以做是因为在root的时候如果条件不满足就可以放弃下面的nodes，recursion就要传无限大的边界
        min[0] = Integer.MAX_VALUE;
        max[0] = Integer.MIN_VALUE;

        if (currentNode == null)
        {
            isBST[0] = true;
            return 0;
        }

        // in this call, min[0] and max[0] would be updated !!!
        // isBST[0] would be updated if left sub-tree is BST
        int leftTreeSize = findSizeOfLargestBST(currentNode.left, min, max, isBST, maxBSTSize);

        // check if left sub-tree is a BST and no node in left sub-tree is greater than current node
        //当遇到要返回多个值的困难的时候，其实isBST[0]，min[0]，max[0]也相当于是存了下一node的返回值，因为每次只看一个node
        boolean isLeftValid = isBST[0] && (max[0] < currentNode.data);

        // before updating min[0] and max[0] in right sub-tree save min and max values seen so far
        int tempMin = minimum(currentNode.data, min[0]);
        int tempMax = maximum(currentNode.data, max[0]);

        // in this call, min[0] and max[0] would be updated
        // isBST[0] would be updated if right sub-tree is BST
        int rightTreeSize = findSizeOfLargestBST(currentNode.right, min, max, isBST, maxBSTSize);

        // check if right sub-tree is a BST and no node in right sub-tree is less than current node
        boolean isRightValid = isBST[0] && (currentNode.data < min[0]);

        // before returning update min[0] which would be the minimum value seen in this sub-tree with root as currentNode
        // and update max[0] which would be the maximum value seen in this sub-tree before
        min[0] = minimum(tempMin, min[0]);
        max[0] = maximum(tempMax, max[0]);

        // if this tree with root as currentNode is a valid BST
        if (isLeftValid && isRightValid)
        {
            // this sub-tree at currentNode is also a BST
            isBST[0] = true;

            // update max BST size accordingly
            if ((1 + leftTreeSize + rightTreeSize) > maxBSTSize[0])
            {
                maxBSTSize[0] = (1 + leftTreeSize + rightTreeSize);
            }

            return (1 + leftTreeSize + rightTreeSize);
        }

        // if this tree is not BST, we don't really use the value returned by it. Return -1.
        isBST[0] = false;
        return -1;
    }

    public void findLargestBST(int[] maxBSTSize)
    {
        int[] min = new int[1];
        int[] max = new int[1];

        boolean[] isBST = new boolean[1];

        findSizeOfLargestBST(root, min, max, isBST, maxBSTSize);
    }


    public static void main(String[] args)
    {
        SizeLargestBST solution = new SizeLargestBST();

        /*
                                10
                          6             12
                      7      4       9       14
                                          13    16
        */
        solution.createTree();

        int[] maxBSTSize = new int[1];

        solution.findLargestBST(maxBSTSize);

        System.out.println(maxBSTSize[0]);
    }
}
