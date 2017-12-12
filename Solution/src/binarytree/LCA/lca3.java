package binarytree.LCA;

public class lca3 {
    boolean v1;
    boolean v2;
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode one, TreeNode two) {
        // linked list is a special kind of tree
        if(root == null || one == null || two == null){
            return root;
        }
        v1 = false;
        v2 = false;
        TreeNode node = lca(root, one, two);
        if(v1 && v2){
            return node;
        }
        return null;
    }

    private TreeNode lca(TreeNode root, TreeNode one, TreeNode two){
        if(root == null){
            return null;
        }
        TreeNode left = lca(root.left, one, two);
        TreeNode right = lca(root.right, one, two);

        if(root.data == one.data){
            v1 = true;
            return root;
        }

        if(root.data == two.data){
            v2 = true;
            return root;
        }

        if(left != null & right != null){
            return root;
        }

        return left == null? right : left;
    }
}
