package BinarySearchTree.ReconstructBST;

import java.util.Stack;
//Exam­ple: int[] pre­Order = { 20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40 };
//use stack
/*
Following is a stack based iterative solution that works in O(n) time.

1. Create an empty stack.

2. Make the first value as root. Push it to the stack.

3. Keep on popping while the stack is not empty and the next value is greater than stack’s top value. Make this value as the right child of the last popped node. Push the new node to the stack.

4. If the next value is less than the stack’s top value, make this value as the left child of the stack’s top node. Push the new node to the stack.

5. Repeat steps 2 and 3 until there are items remaining in pre[].
左子树：如果元素比stack顶端的更小就直接连到左边，push到stack
右子树：元素比stack顶端更大，取stack pop 到不大位置，然后连到取到的值的右边，push到stack上，注意stack不能为空
 */
public class ReconstructBSTWithPreorderII {
    public Node constructTree(int[] preorder) {
        Stack<Node> s = new Stack<Node>();
        Node root = new Node(preorder[0]);
        s.add(root);

        for (int i = 1; i < preorder.length; i++) {
            Node x = null;
            //pop的时候stack不能为空
            while (!s.isEmpty() && preorder[i] > s.peek().data) {
                x = s.pop();
                //x就是当前的root
            }
            //从stack取到了值，说明要去到右变了
            if (x != null) {
                x.right = new Node(preorder[i]);
                s.push(x.right);
            } else {
                //没有更大的就说明preorder[i]比s.peek小，是left child
                s.peek().left = new Node(preorder[i]);
                s.push(s.peek().left);
            }
        }
        return root;
    }

    public void displayTree(Node root) {
        if (root != null) {
            displayTree(root.left);
            System.out.print(" " + root.data);
            displayTree(root.right);
        }
    }

    public static void main(String args[]) {
        ReconstructBSTWithPreorderII p = new ReconstructBSTWithPreorderII();
        int[] preOrder = {10,5,2,7,15,12,20 };
        Node root = p.constructTree(preOrder);
        System.out.println("Inorder Traversal of Constructed Tree : ");
        p.displayTree(root);
    }
}
