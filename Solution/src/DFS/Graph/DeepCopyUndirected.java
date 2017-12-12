package DFS.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeepCopyUndirected {
    public List<GraphNode> copy(List<GraphNode> graph) {

        if(graph == null){
            return null;
        }

        // Hashmap store node and it's copy
        // DFS each node to create copy of all neighbour nodes
        //add neighbour nodes to copy
        HashMap<GraphNode, GraphNode> map = new HashMap<>();
        for(GraphNode node : graph){
            if(!map.containsKey(node)){
                map.put(node, new GraphNode(node.key));
                DFS(node, map);
            }
        }
        return new ArrayList<GraphNode>(map.values());//
    }

    private void DFS(GraphNode node, HashMap<GraphNode, GraphNode> map){
        GraphNode copy = map.get(node);
        for(GraphNode neighbor : node.neighbors){//go through all neighbors of the node
            if(!map.containsKey(neighbor)){ // if neighbours are not in the map
                map.put(neighbor, new GraphNode(neighbor.key));
                DFS(neighbor, map);
            }

            copy.neighbors.add(map.get(neighbor)); //add neighbours
        }
    }
}


 class GraphNode {
   public int key;
   public List<GraphNode> neighbors;
   public GraphNode(int key) {
     this.key = key;
     this.neighbors = new ArrayList<GraphNode>();
   }
 }

