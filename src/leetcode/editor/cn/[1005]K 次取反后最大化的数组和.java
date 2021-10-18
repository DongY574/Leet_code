package leetcode.editor.cn;//给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选
//择同一个索引 i。） 
//
// 以这种方式修改数组后，返回数组可能的最大和。 
//
// 
//
// 示例 1： 
//
// 输入：A = [4,2,3], K = 1
//输出：5
//解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
// 
//
// 示例 2： 
//
// 输入：A = [3,-1,0,2], K = 3
//输出：6
//解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
// 
//
// 示例 3： 
//
// 输入：A = [2,-3,-1,5,-4], K = 2
//输出：13
//解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 1 <= K <= 10000 
// -100 <= A[i] <= 100 
// 
// Related Topics 贪心 数组 排序 👍 107 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //贪心，每次转变一最小的负数变为正数
    //多次局部最优--->整体最优
    //思路


    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);                            //1.首先对原数组进行排序
        int mark = Arrays.binarySearch(nums, 0);
        mark = mark < 0 ? (-mark - 1) : mark;         //2.找到负数的个数

        int i = 0;
        while (k > 0 && i < mark) {                   //3.从最小开始，转变负数为正数
            nums[i] = -nums[i];
            k--;
            i++;
        }

        Arrays.sort(nums);                            //4.符号转变完后，重新排序
        int sum = Arrays.stream(nums).sum();

        if (k % 2 == 1) return sum - 2 * nums[0];     //5.如果k没用完(负数个数>k)，那么将最小正数nums[0]转变符号求和
        return sum;                                   //6.k用完，或k%2==0直接返回
    }
}
//leetcode submit region end(Prohibit modification and deletion)
