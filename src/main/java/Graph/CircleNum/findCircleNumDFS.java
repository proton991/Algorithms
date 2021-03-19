package Graph.CircleNum;


public class findCircleNumDFS {
    boolean[] visited;
    int[][] graph;
    public int findCircleNum(int[][] M) {
        int circleNum = 0;
        int n = M.length;
        this.graph = M;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                circleNum++;
            }
        }
        return circleNum;
    }

    public void dfs(int i) {
        int[] adj = graph[i];
        visited[i] = true;
        for (int j = 0; j < adj.length; j++) {
            if (j != i && graph[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j);
            }
        }
    }
}
