package binarytree.BasicTreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// need to use a stack
public class InOrderTraversal {
    public List<Integer> inOrder(Node root) {
        // iterative use stack
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        //check node!= null because stack is empty in the begining
        while (node != null || !stack.isEmpty()) {
            while (node != null) { //go to left until reach null
                stack.push(node);
                node = node.left;
            }

            //root，只在到root的时候加入到过list里
            Node cur = stack.pop();
            res.add(cur.data);

            //go to right
            node = cur.right;

        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.right = new Node(8);

        InOrderTraversal i = new InOrderTraversal();
        i.inOrder(root);

    }
}


class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
