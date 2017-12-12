package binarytree.LCA;
//What does Dis­tance means : It means num­ber of edges between two TreeNodes.
/*
This prob­lem is sim­i­lar to “Find Path From Root To Given TreeNode”
Make the fol­low­ing change into that
Instead of return­ing the boolean value return the inte­ger, TreeNodes in the path will return the num­ber = 1 + num­ber returned by per­vi­ous TreeNode in path .
The final return will give you the num­ber of TreeNodes between root and the given leaf TreeNode so the dis­tance will be (edges)= num­ber of TreeNodes –1
 */

//preorder + backtracking，backtracking的时候要考虑三种情况

class DistanceFromRootToTreeNode {
    public int Pathlength(TreeNode root, int n1) {
        if (root == null) {
            return 0;
        }

         if (root.data == n1) {
            return 1;
         }

        int left = Pathlength(root.left, n1);
        int right = Pathlength(root.right, n1);
//这样不对，因为left和right都有可能是0
//        return left == 0?  right + 1 : left + 1;
        if(left != 0 || right != 0){
            return left == 0? right + 1 : left + 1;
        }
        return 0;

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
        DistanceFromRootToTreeNode i = new DistanceFromRootToTreeNode();
        System.out.println("Distance from root to 45 is : "
                + (i.Pathlength(root, 45)-1));
    }
}
