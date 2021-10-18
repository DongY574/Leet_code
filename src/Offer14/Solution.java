package Offer14;

class Solution {

    public int cuttingRope(int n) {

        if (n == 2){
            return 1;
        }else if (n == 3){
            return 2;
        }else if (n == 4){
            return 4;
        }
        int[][] list = getList(n);
        return list[list.length-1][list[0].length-1];
    }

    /**
     * 获取动态规划表
     * 这个问题可以看成是完全背包的变种
     * @param target
     * @return int[][]
     **/

    public int[][] getList(int target) {

        int[][] arr = new int[target + 1][target + 1];//行代表的含义是我剪长度为i的一段绳子，列j含义是绳子长度

        for (int i = 0; i < arr[0].length; i++) {//当i=0，表示我不剪，那么乘积还是原来绳子的长度
            arr[0][i] = i;
        }


        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i > j) {
                    arr[i][j] = arr[i - 1][j];//当需要剪去的长度，大于目前绳子长度，沿用上次最大乘积
                } else {
                    int oldVal = arr[i-1][j];//如果我不剪这个长度的绳子，我乘积为上次最大乘积
                    int newVal = arr[i][j-i]*i;//如果我剪去了这个长度的绳子，我乘积为我剪去绳子的长度i*剩余绳子的最佳乘积arr[i][j-1]
                    //因为第一次剪去了i长度，第二次还能剪去i长度，为完全背包问题，故而为arr[i][j-1]
                    arr[i][j] = Math.max(newVal, oldVal);
                }
            }
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
