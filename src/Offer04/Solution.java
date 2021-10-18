package Offer04;

/**
 * @ClassName Solution
 * @Author dy
 * @Date 2021/8/3 22:47
 * @Version 1.0
 **/

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length-1;
        while (i<=matrix.length-1 && j >= 0){
            if (matrix[i][j] == target){
                return true;
            }else if (matrix[i][j] > target){
                j--;
            }else if (matrix[i][j]<target){
                i++;
            }
        }
        return false;
    }
}
