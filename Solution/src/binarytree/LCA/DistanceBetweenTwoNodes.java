package binarytree.LCA;
//We first find LCA of two TreeNodes. Then we find distance from LCA to two TreeNodes.

//Distance(X, Y) = Distance(root, X) +Distance(root, Y) — 2*(Distance(root to LCA(X,Y)
class DistanceBetweenTwoTreeNodes {
    public int findDistance(TreeNode root, int n1, int n2) {
        int x = Pathlength(root, n1) - 1;
        int y = Pathlength(root, n2) - 1;
        int lcaData = findLCA(root, n1, n2).data;
        int lcaDistance = Pathlength(root, lcaData) - 1;
        return (x + y) - 2 * lcaDistance;
    }

    public int Pathlength(TreeNode root, int n1) {
        if (root != null) {
            int x = 0;
            if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0
                || (x = Pathlength(root.right, n1)) > 0) {
                // System.out.println(root.data);
                return x + 1;
            }
            return 0;
        }
        return 0;
    }

    //preorder + backtracking，backtracking的时候要考虑三种情况
    public TreeNode findLCA(TreeNode root, int n1, int n2) {
        if (root != null) {
            if (root.data == n1 || root.data == n2) {
                return root;
            }
            TreeNode left = findLCA(root.left, n1, n2);
            TreeNode right = findLCA(root.right, n1, n2);

            if (left != null && right != null) {
                return root;
            }
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
        }
        return null;
    }

    public static void main(String[] args) throws java.lang.Exception {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);
        root.left.right.right = new TreeNode(45);
        DistanceBetweenTwoTreeNodes i = new DistanceBetweenTwoTreeNodes();
        System.out.println("Distance between 45 and 20 is : "
                + i.findDistance(root, 45, 20));
    }
}
