package other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zc
 */
public class DfsAndBfs {

    public static void main(String[] args) {
        DfsAndBfs dfsAndBfs = new DfsAndBfs();
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(dfsAndBfs.maxLen(a));
    }

    /**
     * leetcode :200
     * ��һ��01������ͬ�ĵ���ĸ�����
     * 0������1�������������1���ڣ���ô������1����ͬһ����������ֻ������������Ϊ���ڡ�
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
        //����������޸�ԭ���飬����һ����ά����marked�����ʹ�����1
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
     * ��󳤶ȣ�ֻ����������ĵط���
     */
    public int maxLen(int[][] a) {
        if (a == null || a.length == 0 || a[0] == null || a[0].length == 0) {
            return 0;
        }
        boolean[][] marked = new boolean[a.length][a[0].length];
        int max = 0;
        int cur = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                cur = dfs(a, i, j, marked);
                if (cur > max) {
                    max = cur;
                }
            }
        }
        return max;
    }

    public int dfs(int[][] a, int i, int j, boolean[][] marked) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || marked[i][j] == true) {
            return 0;
        }
        marked[i][j] = true;
        int a1 = 1, a2 = 1, a3 = 1, a4 = 1;
        if (i + 1 < a.length && a[i + 1][j] > a[i][j]) {
            a1 += dfs(a, i + 1, j, marked);
        }
        if (i - 1 >= 0 && a[i - 1][j] > a[i][j]) {
            a2 += dfs(a, i - 1, j, marked);
        }
        if (j + 1 < a[0].length && a[i][j + 1] > a[i][j]) {
            a3 += dfs(a, i, j + 1, marked);
        }
        if (j - 1 >= 0 && a[i][j - 1] > a[i][j]) {
            a4 += dfs(a, i, j - 1, marked);
        }
        marked[i][j] = false;
        return Math.max(a1, Math.max(a2, Math.max(a3, a4)));
    }

    /**
     * leetcode:695. �����������
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
                if (marked[i][j] == false && a[i][j] == 1) {
                    int current = dfsMaxArea(a, marked, i, j);
                    if (current > maxArea) {
                        maxArea = current;
                    }
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
     * �ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ����������������ƶ�һ�����ӡ����һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ�
     * leet:79
     * <p>
     * ��������ľ��������һ�� bfce ·����
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
                if (a[i][j] == path.charAt(0) && marked[i][j] == false) {
                    if (pathDfs(a, i, j, path, 0, marked)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean pathDfs(char[][] a, int i, int j, String word, int index, boolean[][] marked) {
        if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || marked[i][j] || word.charAt(index) != a[i][j]) {
            return false;
        }
        //�ߵ���˵��word.charAt(index) == a[i][j]����
        if (index == word.length() - 1) {
            return true;
        }
        marked[i][j] = true;
        if (pathDfs(a, i - 1, j, word, index + 1, marked)) {
            return true;
        }
        if (pathDfs(a, i + 1, j, word, index + 1, marked)) {
            return true;
        }
        if (pathDfs(a, i, j - 1, word, index + 1, marked)) {
            return true;
        }
        if (pathDfs(a, i, j + 1, word, index + 1, marked)) {
            return true;
        }
        //ע�����
        marked[i][j] = false;
        return false;
    }

    /**
     * bfs��������
     * leetcode:1091. �����ƾ����е����·��,https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
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
        // ֱ����grid[i][j]��¼����㵽���������·�������������� ���Ҳ�г���1
        grid[0][0] = 1;
        queue.add(new Point(0, 0));
        // �����·�� ʹ��BFS
        while (!queue.isEmpty() && grid[row - 1][col - 1] == 0) {
            Point pre = queue.poll();
            // ��ǰ���·������
            int preLength = grid[pre.x][pre.y];
            for (int i = 0; i < directions.length; i++) {
                int newX = pre.x + directions[i][0];
                int newY = pre.y + directions[i][1];
                if (inGrid(newX, newY) && grid[newX][newY] == 0) {
                    queue.add(new Point(newX, newY));
                    // ��һ�����·������Ҫ+1
                    grid[newX][newY] = preLength + 1;
                }
            }
        }
        // �������յ��ֵ����0��˵��û�е���
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
