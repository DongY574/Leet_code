package Exer494;

/**
 * @ClassName Solution
 * @Author dy
 * @Date 2021/8/26 10:55
 * @Version 1.0
 **/

class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        //思路，转换为01背包问题，求nums中数字和为某一值的所有组合个数
        //如何转换?
        //将nums看为两部分，a与b，正数都归类为a，负数都归类为b
        //于是乎a+b=target，a-b = sum(sum为nums中所有数的和)
        //于是乎a = (sum + target)/2
        //因此，确定了nums中所有数字和为a的组合，就相当于确定了哪些数字是正数，那么剩下的数字就都为负数
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //这里是重点，需要加abs
        if (Math.abs(target) > sum || (target + sum) % 2 == 1) {//当都看为正数的sum还比target小，或target+sum不能被2整除，直接返回0
            return 0;                               //这里因为a是一个整数，且a=(target+sum)/2，因为a是整数，故而(target+sum)/2必须能被二整除
        } else {
            int[][] sum1 = getSum(nums, (target + sum) / 2);

            return sum1[sum1.length - 1][sum1[0].length - 1];
        }
    }

    public int[][] getSum(int[] n, int t) {
        int[] nums = new int[n.length + 1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = n[i - 1];
        }

        int[][] arr = new int[nums.length][t + 1];

        arr[0][0] = 1;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (nums[i] > j) {
                    arr[i][j] = arr[i - 1][j];
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - nums[i]];
                }
            }
        }
        return arr;
    }
}
