package binarytree;

import java.util.HashMap;

/*

Given a binary tree, find all duplicate subtrees. For each duplicate subtrees, we only need to return the root TreeNode of any one of them. Two trees are duplicate if they have the same structure with same TreeNode values.
 */
public class FindAllDuplicatesSubtrees {
    //一看到duplicates就应该想到hashmap
    static HashMap<String, Integer> m;

    static String inorder(TreeNode TreeNode)
    {
        if (TreeNode == null)
            return "";

        String str = "(";
        str += inorder(TreeNode.left);
        str += Integer.toString(TreeNode.key);
        str += inorder(TreeNode.right);
        str += ")";

        // Subtree already present (Note that we use
        // HashMap instead of HashSet
        // because we want to print multiple duplicates
        // only once, consider example of 4 in above
        // subtree, it should be printed only once.
        if (m.get(str) != null && m.get(str)==1 )
            System.out.print( TreeNode.key + " ");

        if (m.containsKey(str))
            m.put(str, m.get(str) + 1);
        else
            m.put(str, 1);


        return str;
    }

    // Wrapper over inorder()
    static void printAllDups(TreeNode root)
    {
        m = new HashMap<>();
        inorder(root);
    }
    // Driver code
    public static void main(String args[])
    {
        TreeNode root = null;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        printAllDups(root);
    }
}
