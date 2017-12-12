package BFS;

//assume the given graph is not null


import java.util.*;

public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        // write your solution here
        //assume the graph is not null

        //use 1 and 0 to denote two groups
//the map maintains for each group which group it belongs to
        HashMap<GraphNode, Integer> visited= new HashMap<>();//store group no. of the node
        for(GraphNode node : graph){
            if(!BFS(node, visited)){//BFS on each node
                return false;
            }
        }

        return true;
    }

    private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited){
        // without this line, {0->1;1->0} will get reset by visited.put(node, 0);
        if(visited.containsKey(node)){//don't repeatedly visit a node
            return true;
        }

        //start BFS from the node, since node hasn't been visited, assign it to any group
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);//first node
        visited.put(node, 0);

        while(!queue.isEmpty()){
            GraphNode cur = queue.poll();
            //get the group assigned for cur node
            int curGroup = visited.get(cur);
            //the group assinged for neighbour of cur node
            int neiGroup = curGroup == 0? 1 : 0;
            for(GraphNode nei : cur.neighbors){//traverse neighbours
                //if neighbour hasn't been visited, just put it in the queue and assign the correct group
                if(!visited.containsKey(nei)){//use visited.containsKey
                    visited.put(nei, neiGroup);
                    queue.offer(nei);
                }else if(visited.get(nei) == visited.get(cur)){
                    //if neighbour has been visited and group doesn match the desired one, return false
                    return false;
                }
            }
        }
        return true;
    }
}

class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<>();
    }
}