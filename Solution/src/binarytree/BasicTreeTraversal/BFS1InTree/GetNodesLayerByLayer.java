package binarytree.BasicTreeTraversal.BFS1InTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GetNodesLayerByLayer {
    static int height = 0;
    public List<List<Integer>> layerByLayer(Node root) {
        // Write your solution here.
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //Type还是Queue
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {// go through each layer
                Node node = queue.poll();//poll each node and add left then right
                //for loop is not necessary for levelorder traversal
                //just adding elements to list
                list.add(node.data);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(list);
            height++;
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

        GetNodesLayerByLayer i = new GetNodesLayerByLayer();
        i.layerByLayer(root);
        System.out.println(height);
    }
}
