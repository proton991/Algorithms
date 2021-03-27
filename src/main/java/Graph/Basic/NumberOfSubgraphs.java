package Graph.Basic;

public class NumberOfSubgraphs {
    private Graph _g;
    public int countConnectedComponents(Graph graph) {
        this._g = graph;
        boolean[] visited = new boolean[_g.vertices];
        int count = 0;
        int index;
        while((index = checkGraphIsVisited(visited))!=-1){
            dfs(index, visited);
            count++;
        }
        return count;
    }

    public int checkGraphIsVisited(boolean[] visited){

        for (int i = 0; i <visited.length ; i++) {
            if(!visited[i])
                return i;
        }
        return -1;
    }

    public void dfs(int start, boolean[] visited) {
        visited[start] = true;
        for (int i = 0; i < _g.adjList[start].size(); i++) {
            int destination = _g.adjList[start].get(i);
            if (!visited[destination])
                dfs(destination, visited);
        }
    }


    public static void main(String[] args) {
        NumberOfSubgraphs numberOfSubgraphs = new NumberOfSubgraphs();

        Graph graph = new Graph(4);
        System.out.println("Number of Subgraphs: " + numberOfSubgraphs.countConnectedComponents(graph));
        graph.addEdge(0, 1);
        System.out.println("Number of Subgraphs: " + numberOfSubgraphs.countConnectedComponents(graph));
        graph.addEdge(2, 3);
        System.out.println("Number of Subgraphs: " + numberOfSubgraphs.countConnectedComponents(graph));
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        System.out.println("Number of Subgraphs: " + numberOfSubgraphs.countConnectedComponents(graph));
    }
}
