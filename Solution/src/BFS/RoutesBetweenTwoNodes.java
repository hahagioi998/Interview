package BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class RoutesBetweenTwoNodes {
    /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */


      class DirectedGraphNode {
          int label;
          ArrayList<DirectedGraphNode> neighbors;
          DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
      };

    public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
                            DirectedGraphNode s, DirectedGraphNode t) {
        if (s == t)
            return true;

        HashSet<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();

        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (int i = 0; i < node.neighbors.size(); i++) {
                if (visited.contains(node.neighbors.get(i))) {
                    continue;
                }
                visited.add(node.neighbors.get(i));
                queue.offer(node.neighbors.get(i));
                if (node.neighbors.get(i) == t) {
                    return true;
                }
            }
        }

        return false;
    }
}
