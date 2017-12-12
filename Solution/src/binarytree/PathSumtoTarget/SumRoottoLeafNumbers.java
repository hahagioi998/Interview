package binarytree.PathSumtoTarget;
/*
For example,
  1
 / \
2  3

The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */
public class SumRoottoLeafNumbers {
    public int sumNumbers(Node root) {
        return dfs(root, 0);
    }

    private int dfs(Node root, int prev){
        //需要这个因为只有一个孩子的情况
        if(root == null) {
            return 0;
        }

        //这个乘以10非常关键
        int sum = root.data + prev * 10;
        if(root.left == null && root.right == null) {
            return sum;
        }

        return dfs(root.left, sum) + dfs(root.right, sum);
    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(10);
        root.left.right = new Node(12);
        root.left.right.left = new Node(6);
        root.right.right = new Node(8);
        root.right.right.left = new Node(5);
//        leftSum(root, root);
        SumRoottoLeafNumbers res = new SumRoottoLeafNumbers();

        System.out.println("Sum of root to leaf numbers: " + res.sumNumbers(root));
    }
}
