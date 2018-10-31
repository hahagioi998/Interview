package binarytree;

//关键是返回高，但通过高的值来做区别
//又要知道是不是balance，又要知道高度，采取了postorder traversal的策略
//backtracking 返回了量值
//通过对量值的判断来判断boolean的
public class IfBinaryTreeBalanced {
    public boolean isBalanced(TreeNode root) {
        // Write your solution here.
        if(root == null){
            return true;
        }

        return height(root) != -1;
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        if(leftHeight == -1){
            //直接返回-1了就说明不balance
            return -1;
        }

        int rightHeight = height(root.right);
        if(rightHeight == -1){
            return -1;
        }

        //if both substrees are balanced, but the difference of height is larger than 1
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
