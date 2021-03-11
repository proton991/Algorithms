package Graph.CourseTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 99615
 * @Date: 2021/1/27 11:57
 * @Description:
 */
public class findOrder {

    List<List<Integer>> edges = new ArrayList<>();
    int[] ans;
    int k;
    int[] visited;
    boolean valid;

    public int[] Solution(int numCourses, int[][] prerequisites) {
        k = numCourses - 1;
        ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        valid = true;
        for (int[] pre : prerequisites) {
            edges.get(pre[1]).add(pre[0]);
        }

        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid)
            return new int[0];
        else
            return ans;
    }

    void dfs(int i) {
        visited[i] = 1;
        for (int c : edges.get(i)) {
            if (visited[c] == 0) {
                dfs(c);
                if (!valid)
                    return;
            } else if (visited[c] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
        ans[k--] = i;
    }
}
