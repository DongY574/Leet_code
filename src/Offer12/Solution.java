package Offer12;

import org.junit.Test;

/**
 * @ClassName Solution
 * @Author dy
 * @Date 2021/8/9 22:57
 * @Version 1.0
 **/

public class Solution {
    String word = "AAA";

    @Test
    public void test(){
        char[][] board = {
                {'A','A'}
        };
        boolean[][] isVisited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.println(dFS(board, new Point(i, j), isVisited, 0));
            }
        }
    }

    public boolean dFS(char[][] board, Point start, boolean[][] isVisited, int strIndex) {

        if (start.x > board.length - 1 || start.x < 0 || start.y > board[0].length - 1 || start.y < 0) {
            return false;
        }

        if (board[start.x][start.y] != word.charAt(strIndex)) {
            return false;
        }

        if (isVisited[start.x][start.y]) {
            return false;
        }

        if (strIndex == word.length() - 1) {
            return true;
        }

        isVisited[start.x][start.y] = true;

        boolean res = dFS(board, new Point(start.x, start.y+1), isVisited, strIndex+1)
                || dFS(board, new Point(start.x+1, start.y), isVisited, strIndex+1)
                || dFS(board, new Point(start.x, start.y-1), isVisited, strIndex+1)
                || dFS(board, new Point(start.x-1, start.y), isVisited, strIndex+1);

        if (!res){
            isVisited[start.x][start.y] = false;
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