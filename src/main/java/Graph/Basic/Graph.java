package Graph.Basic;


import java.util.ArrayList;
import java.util.List;

public class Graph {
    public int vertices;
    List<Integer>[] adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new List[vertices];
        for (int i = 0; i < this.vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination){
        //forward edge
        adjList[source].add(destination);
        //backward edge in undirected graph
        adjList[destination].add(source);
    }

    public void DFSRecursion(int start) {
        boolean[] visited = new boolean[this.vertices];
        DFSRecursion(start, visited);
    }

    public void DFSRecursion(int start, boolean[] visited) {
        visited[start] = true;
        List<Integer> adj = adjList[start];
        System.out.print(start + " ");
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[adj.get(i)]) {
                DFSRecursion(adj.get(i), visited);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.DFSRecursion(0);
    }


}
