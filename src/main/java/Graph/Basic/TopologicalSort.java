package Graph.Basic;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) {
            adjList[source].addFirst(destination);
        }
        public void topologicalSortBFS() {
            int[] inDegree = new int[this.vertices];
            for (int i = 0; i < this.vertices; i++) {
                List<Integer> adj = this.adjList[i];
                for (int neighbour : adj) {
                    inDegree[neighbour]++;
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                System.out.print(vertex+ " ");
                for (int neighbour : this.adjList[vertex]) {
                    inDegree[neighbour]--;
                    if (inDegree[neighbour] == 0) {
                        queue.add(neighbour);
                    }
                }
            }
        }
        public void topologicalSortDFS() {
            boolean[] visited = new boolean[vertices];
            Stack<Integer> stack = new Stack<>();
            //visit from each node if not already visited
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    topologicalSortUtil(i, visited, stack);
                }
            }
            System.out.println("Topological Sort: ");
            int size = stack.size();
            for (int i = 0; i <size ; i++) {
                System.out.print(stack.pop() + " ");
            }
        }

        public void topologicalSortUtil(int start, boolean[] visited, Stack<Integer> stack) {
            visited[start] = true;
            for (int i = 0; i < adjList[start].size(); i++) {
                int vertex = adjList[start].get(i);
                if (!visited[vertex])
                    topologicalSortUtil(vertex, visited, stack);
            }
            stack.push(start);
        }
    }

    public static void main(String[] args) {
        int vertices = 8;
        Graph graph = new Graph(vertices);
        graph.addEdge(7, 6);
        graph.addEdge(7, 5);
        graph.addEdge(6, 4);
        graph.addEdge(6, 3);
        graph.addEdge(5, 4);
        graph.addEdge(5, 2);
        graph.addEdge(3, 1);
        graph.addEdge(2, 1);
        graph.addEdge(1, 0);
        System.out.println("using dfs:");
        graph.topologicalSortDFS();
        System.out.println("\nusing bfs:");
        graph.topologicalSortBFS();
    }
}