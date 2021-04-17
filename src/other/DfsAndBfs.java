package other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zc
 */
public class DfsAndBfs {

    /**
     * leetcode :200
     * 给一个01矩阵，求不同的岛屿的个数。
     * 0代表海，1代表岛，如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
     *
     * @param a
     * @return
     */
    public int islandSum(int[][] a) {
        if (a == null || a.length == 0 || a[0] == null || a[0].length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    dfs(a, i, j);
                    sum++;
                }
            }
        }
        return sum;
    }

    public void dfs(int[][] a, int i, int j) {
        //如果不允许修改原数组，申请一个二维数组marked，访问过的置1
        a[i][j] = 0;
        if (i - 1 >= 0 && a[i - 1][j] == 1) {
            dfs(a, i - 1, j);
        }
        if (i + 1 < a.length && a[i + 1][j] == 1) {
            dfs(a, i + 1, j);
        }
        if (j - 1 >= 0 && a[i][j - 1] == 1) {
            dfs(a, i, j - 1);
        }
        if (j + 1 < a[0].length && a[i][j + 1] == 1) {
            dfs(a, i, j + 1);
        }
    }

    /**
     * leetcode:695. 岛屿的最大面积
     * https://leetcode-cn.com/problems/max-area-of-island/description/
     */
    public int maxArea(int[][] a) {
        if (a == null || a.length == 0 || a[0] == null || a[0].length == 0) {
            return -1;
        }
        int maxArea = 0;
        boolean[][] marked = new boolean[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                int current = dfsMaxArea(a, marked, i, j);
                if (current > maxArea) {
                    maxArea = current;
                }
            }
        }
        return maxArea;
    }

    int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int dfsMaxArea(int[][] a, boolean[][] marked, int i, int j) {
        if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || marked[i][j] || a[i][j] == 0) {
            return 0;
        }
        marked[i][j] = true;
        int num = 1;
        for (int d = 0; d < direction.length; d++) {
            num += dfsMaxArea(a, marked, i + direction[d][0], j + direction[d][1]);
        }
        return num;
    }

    /**
     * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向上下左右移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
     * leet:79
     * <p>
     * 例如下面的矩阵包含了一条 bfce 路径。
     * https://github.com/CyC2018/CS-Notes/blob/master/notes/12.%20%E7%9F%A9%E9%98%B5%E4%B8%AD%E7%9A%84%E8%B7%AF%E5%BE%84.md
     */
    public boolean hasPath(char[][] a, String path) {
        if (a == null || a.length == 0 || a[0] == null || a[0].length == 0) {
            return false;
        }
        if (path == null || path.length() == 0) {
            return false;
        }
        boolean[][] marked = new boolean[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (pathDfs(a, i, j, path, 0, marked)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean pathDfs(char[][] a, int i, int j, String word, int index, boolean[][] marked) {
        if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || marked[i][j]) {
            return false;
        }
        if (index == word.length()-1 && word.charAt(index) == a[i][j]) {
            return true;
        }
        if (word.charAt(index) != a[i][j]) {
            return false;
        }
        marked[i][j] = true;
        if (pathDfs(a, i-1, j, word, index+1, marked)) {
            return true;
        }
        if (pathDfs(a, i+1, j, word, index+1, marked)) {
            return true;
        }
        if (pathDfs(a, i, j-1, word, index+1, marked)) {
            return true;
        }
        if (pathDfs(a, i, j+1, word, index+1, marked)) {
            return true;
        }
        //注意回溯
        marked[i][j] = false;
        return false;
    }

    /**
     * bfs经典问题
     * leetcode:1091. 二进制矩阵中的最短路径,https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
     */
    private static int[][] directions = {{0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
    private int row, col;

    public int shortestPathBinaryMatrix(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }
        Queue<Point> queue = new LinkedList<>();
        // 直接用grid[i][j]记录从起点到这个点的最短路径长。按照题意 起点也有长度1
        grid[0][0] = 1;
        queue.add(new Point(0, 0));
        // 求最短路径 使用BFS
        while (!queue.isEmpty() && grid[row - 1][col - 1] == 0) {
            Point pre = queue.poll();
            // 当前点的路径长度
            int preLength = grid[pre.x][pre.y];
            for (int i = 0; i < directions.length; i++) {
                int newX = pre.x + directions[i][0];
                int newY = pre.y + directions[i][1];
                if (inGrid(newX, newY) && grid[newX][newY] == 0) {
                    queue.add(new Point(newX, newY));
                    // 下一个点的路径长度要+1
                    grid[newX][newY] = preLength + 1;
                }
            }
        }
        // 如果最后终点的值还是0，说明没有到达
        return grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1];
    }

    private boolean inGrid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
