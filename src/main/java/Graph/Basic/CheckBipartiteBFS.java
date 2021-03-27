package Graph.Basic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBipartiteBFS {
    enum Color {
        WHITE, RED, GREEN
    }

    public boolean isBipartite(Graph graph) {

        //check if graph is empty
        if (graph.vertices == 0)
            return true;

        //initialize colors for all vertices
        Color[] colors = new Color[graph.vertices];
        //color all the vertices with white color
        Arrays.fill(colors, Color.WHITE);

        Queue<Integer> queue = new LinkedList<>();
        //start coloring vertices , this code will handle the disconnected graph as well
        //color the first vertex with RED
        for (int source = 0; source < graph.vertices; source++) {

            if (colors[source] == Color.WHITE) {
                colors[source] = Color.RED;

                //add it to queue for BFS

                queue.add(source);

                while (!queue.isEmpty()) {
                    int v = queue.remove();
                    for (int i = 0; i < graph.adjList[v].size(); i++) {
                        int dest = graph.adjList[v].get(i);

                        if (colors[dest] == Color.WHITE) {
                            //color is with the alternate color of vertex v

                            if (colors[v] == Color.RED) {
                                //if source is in red, make vertex dest green
                                colors[dest] = Color.GREEN;
                            } else if (colors[v] == Color.GREEN) {
                                //if source is in red, make vertex dest green
                                colors[dest] = Color.RED;
                            }
                            //add vertex dest to queue
                            queue.add(dest);
                        } else if (colors[v] == colors[dest]) {
                            //means vertex v and dest are in same color, so graph is not bipartite
                            return false;
                        }
                    }
                }
            }
        }
        // if here means graph is successfully colored in 2 color, red and green
        //graph is bipartite
        return true;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        CheckBipartiteBFS checkBipartiteBFS = new CheckBipartiteBFS();
        boolean result = checkBipartiteBFS.isBipartite(graph);
        System.out.println("Graph is Bipartite: " + result);
        System.out.println("--------------------------");

        Graph graph1 = new Graph(4);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 1);

        result = checkBipartiteBFS.isBipartite(graph1);
        System.out.println("Graph is Bipartite: " + result);
        System.out.println("--------------------------");
    }
}
