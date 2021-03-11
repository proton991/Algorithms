package Graph.NumberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: 99615
 * @Date: 2021/1/27 10:50
 * @Description:
 */
public class NoOfIslandsBFS {

    public int Solution(char[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int num = 0;
        int R = grid.length;
        int C = grid[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == '1') {
                    num++;
                    grid[r][c] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(r * C + c);
                    while (!queue.isEmpty()) {
                        int code = queue.poll();
                        int row = code / C;
                        int col = code % C;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            grid[row-1][col] = '0';
                            queue.add((row-1)*C+col);
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            grid[row][col-1] = '0';
                            queue.add(row*C+col-1);
                        }
                        if (row + 1 < R && grid[row+1][col] == '1') {
                            grid[row+1][col] = '0';
                            queue.add((row+1)*C+col);
                        }
                        if (col + 1 < C && grid[row][col+1] == '1') {
                            grid[row][col+1] = '0';
                            queue.add(row*C+col+1);
                        }
                    }
                }
            }
        }
        return num;
    }
}
