package binarytree.LCA;

//三段区间，-> p -> q ->

public class LCABST {
    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root.data > Math.max(p, q)) {
            //两个都比root小
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.data < Math.min(p, q)) {
            //两个都比root大
            return lowestCommonAncestor(root.right, p, q);
        } else {
            //root在p和q中间，p和q在root两边
            return root;
        }
    }
}
