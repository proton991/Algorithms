package Graph.NumberOfIslands;

/**
 * @Auther: 99615
 * @Date: 2021/1/27 11:13
 * @Description:
 */
public class NoOfIslandsDFS {
    int R, C;
    public int Solution(char[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int num = 0;
        R = grid.length;
        C = grid[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == '1') {
                    num++;
                    dfs(grid, r, c);
                }
            }
        }
        return num;
    }
    public void dfs(char[][] grid, int r, int c) {
        if (r<0||r>=R||c<0||c>=C||grid[r][c]=='0')
            return;
        grid[r][c] = '0';
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
}
