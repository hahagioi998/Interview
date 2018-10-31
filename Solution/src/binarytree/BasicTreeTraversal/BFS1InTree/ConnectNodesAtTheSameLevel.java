package binarytree.BasicTreeTraversal.BFS1InTree;

import java.util.LinkedList;
import java.util.Queue;

/*
Input Tree
       A
      / \
     B   C
    / \   \
   D   E   F


Output Tree
       A--->NULL
      / \
     B-->C-->NULL
    / \   \
   D-->E-->F-->NULL
 */

//不需要特别连到null，没有就是null了
public class ConnectNodesAtTheSameLevel{
    public static void connect(Node root) {
        if (root == null) {
            return;
        }

        //在A的时候
        Node firstNode = root;
        Node prevNode = null;

        while (firstNode != null) {
            root = firstNode;
            //真正的initialize
            firstNode = null;
            prevNode = null;

            while (root != null) {
                if (root.left != null) {
                    //最左端
                    if (firstNode == null) {
                        firstNode = root.left;
                    }
                    //最左端
                    if (prevNode != null) {
                        prevNode.next = root.left;
                    }
                    prevNode = root.left;
                }

                if (root.right != null) {
                    //
                    if (firstNode == null) {
                        firstNode = root.right;
                    }
                    if (prevNode != null) {
                        prevNode.next = root.right;
                    }
                    prevNode = root.right;
                }

                root = root.next;
            }
        }
    }

    static void connect2(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        // null marker to represent end of current level
        q.add(null);

        // Do Level order of tree using NULL markers
        while (!q.isEmpty()) {
            //拿出一个来
          //the remove() method throws an exception, while the poll() method returns null.
            Node p = q.peek();
            //Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
            q.remove();
            if (p != null) {

                // next element in queue represents next
                // node at current Level
                //q.peek() will return null if queue is empty
                //看下一个
                p.next = q.peek();

                // push left and right children of current
                // node
                if (p.left != null)
                    q.add(p.left);
                if (p.right != null)
                    q.add(p.right);
            }

            // if queue is not empty！ push NULL to mark
            // nodes at this level are visited
            //因为之前就加过null了，没有这一步的话下一层的最后和下一层的第一就会连起来
            else if (!q.isEmpty())
                q.add(null);
        }
    }

    public Node provideSiblings(Node root) {
//        http://algorithms.tutorialhorizon.com/provide-the-next-siblings-pointers-in-a-given-binary-tree/
        if (root != null) {

            if (root.left != null) { // check if left node is not null
                // make the left node's sibling points to the right node of root
                root.left.next = root.right;
            }
            if (root.right != null) {
                if (root.next != null)// check if root has any sibling
                    // make the right node's sibling points root's next siblings
                    // left node
                    root.right.next = root.next.left;
            }
            provideSiblings(root.left);
            provideSiblings(root.right);
            return root;

        }
        return null;
    }

    /* Driver program to test above functions*/
    public static void main(String args[])
    {
      
        /* Constructed binary tree is
                  10
                /   \
              8      2
            /         \
          3            90
        */
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(90);

        // Populates next pointer in all nodes
        connect2(root);

        // Let us check the values of next pointers
        System.out.println("Following are populated next pointers in \n" +
                "the tree (-1 is printed if there is no next)");
        System.out.println("next of "+ root.data +" is "+
                ((root.next != null) ? root.next.data : -1));
        System.out.println("next of "+ root.left.data+" is "+
                ((root.left.next != null) ? root.left.next.data : -1));
        System.out.println("next of "+ root.right.data+" is "+
                ((root.right.next != null) ? root.right.next.data : -1));
        System.out.println("next of "+  root.left.left.data+" is "+
                ((root.left.left.next != null) ? root.left.left.next.data : -1));
        System.out.println("next of "+  root.right.right.data+" is "+
                ((root.right.right.next != null) ? root.right.right.next.data : -1));
    }
}
