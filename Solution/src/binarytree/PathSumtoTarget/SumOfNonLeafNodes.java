package binarytree.PathSumtoTarget;

public class SumOfNonLeafNodes {
    public int sumNumbers(Node root) {
        int[] sum = new int[]{0};
        dfs(root, sum);
        return sum[0];
    }

    private void dfs(Node root, int sum[]){
        //需要这个因为只有一个孩子的情况
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            return;
        }
        sum[0] += root.data;


        dfs(root.left, sum);
        dfs(root.right, sum);
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
        SumOfNonLeafNodes res = new SumOfNonLeafNodes();

        System.out.println("Sum of root to leaf numbers: " + res.sumNumbers(root));
    }
}
