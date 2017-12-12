package BinarySearchTree;
/*
题解 - 递归
二叉树的题使用递归自然是最好理解的，代码也简洁易懂，缺点就是递归调用时栈空间容易溢出，故实际实现中一般使用迭代替代递归，性能更佳嘛。不过迭代的缺点就是代码量稍(很)大，逻辑也可能不是那么好懂。

既然确定使用递归，那么接下来就应该考虑具体的实现问题了。在递归的具体实现中，主要考虑如下两点：

基本条件/终止条件 - 返回值需斟酌。
递归步/条件递归 - 能使原始问题收敛。
首先来找找递归步，根据二叉查找树的定义，若插入节点的值若大于当前节点的值，则继续与当前节点的右子树的值进行比较；反之则继续与当前节点的左子树的值进行比较。题目的要求是返回最终二叉搜索树的根节点，从以上递归步的描述中似乎还难以对应到实际代码，这时不妨分析下终止条件。

有了递归步，终止条件也就水到渠成了，若当前节点为空时，即返回结果。问题是——返回什么结果？当前节点为空时，说明应该将「插入节点」插入到上一个遍历节点的左子节点或右子节点。对应到程序代码中即为root->right = node或者root->left = node. 也就是说递归步使用root->right/left = func(...)即可。

 */

/*
题解 - 迭代
看过了以上递归版的题解，对于这个题来说，将递归转化为迭代的思路也是非常清晰易懂的。迭代比较当前节点的值和插入节点的值，到了二叉树的最后一层时选择是链接至左子结点还是右子节点。
 在NULL == tempNode->right或者NULL == tempNode->left时需要在链接完node后立即返回root，避免死循环。
 */
public class InsertNodeInABinarySearchTree {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (root.key > node.key) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }

    public TreeNode insertNode2(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) return node;
        if (node == null) return root;

        TreeNode rootcopy = root;
        while (root != null) {
            if (root.key <= node.key && root.right == null) {
                root.right = node;
                break;
            }
            else if (root.key > node.key && root.left == null) {
                root.left = node;
                break;
            } else if(root.key <= node.key) {
                //右移
                root = root.right;
            } else {
                //左移
                root = root.left;
            }
        }
        return rootcopy;
    }
}
