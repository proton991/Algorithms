package Graph.Basic;

import java.util.List;

public class CheckUndirectedDisconnectedGraph {
    public Graph g;
    public void isConnected(Graph graph){
        this.g = graph;
        int vertices = g.vertices;

        //created visited array
        boolean[] visited = new boolean[vertices];

        //start the DFS from vertex 0
        DFS(0, visited);

        //check if all the vertices are visited, if yes then graph is connected
        int count = 0;
        for (boolean b : visited) {
            if (!b)
                count++;
        }
        if(vertices==count){
            System.out.println("Given graph is connected");
        }else{
            System.out.println("Given graph is not connected");
        }
    }

    public void DFS(int source, boolean[] visited){

        //mark the vertex visited
        visited[source] = true;

        //travel the neighbors
        for (int i = 0; i <g.adjList[source].size() ; i++) {
            int neighbor = g.adjList[source].get(i);
            if(!visited[neighbor]){
                //make recursive call from neighbor
                DFS(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,3);
        graph.addEdge(3,2 );

        CheckUndirectedDisconnectedGraph c = new CheckUndirectedDisconnectedGraph();
        c.isConnected(graph);

        graph.addEdge(3, 4);
        c.isConnected(graph);
    }
}
