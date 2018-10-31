package binarytree.PathSumtoTarget;

//we need compare cur level with deepestlevel, a preorder traversal
//可以分解成找左边和最深，左边可以通过true false来解决，最深就要通过比较
public class DeepestLeftLeaf {
        //level is not specific to left subtree

        public int deepestLevel = 0;
        public int deepLeftNode;//have to keep a global variable, because we want to go through all nodes

        public int deepLeft(Node root) {
            find(root, 0, false);
            return deepLeftNode;
        }
    //preorder + 不需要考虑backtracking，因为使用了global variable

        public void find(Node root, int level, boolean left) {
            if (root != null) {
                //same as ++level, level is passed to right subtree

                if (left && deepestLevel < level) {// check if it a left child and
                    // current level is greater than deepest level
                    deepLeftNode = root.data; // update the deepest left node
                    deepestLevel = level;   // update the deepest level
                }
                find(root.left, ++level, true);
                find(root.right, level, false);
            }
        }

        public static void main(String args[]) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.left.left.right = new Node(8);

            DeepestLeftLeaf dp = new DeepestLeftLeaf();
            System.out.println("Deapest Left child is: " + dp.deepLeft(root));

        }
    }
