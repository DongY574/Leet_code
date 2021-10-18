package Offer13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Author dy
 * @Date 2021/8/12 0:04
 * @Version 1.0
 **/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(2, 3, 1));
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] isVisited = new boolean[m][n];
        Queue<Point> queue = new LinkedList<>();
        int res = 1;
        int[] dx = {0, 1};
        int[] dy = {1, 0};

        isVisited[0][0] = true;
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point u = queue.poll();
            for (int i = 0; i < 2; i++) {

                int tx = u.x + dx[i];
                int ty = u.y + dy[i];

                if (tx < 0 || tx >= m || ty < 0 || ty >= n || isVisited[tx][ty] || (tx / 10 + tx % 10 + ty / 10 + ty % 10) > k) {
                    continue;
                }
                queue.add(new Point(tx, ty));
                res++;
                isVisited[tx][ty] = true;
            }
        }
        return res;
    }
}

class Point {
    int x;
    int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
