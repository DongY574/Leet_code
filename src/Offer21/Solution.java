package Offer21;

import org.junit.Test;

/**
 * @ClassName Solution
 * @Author dy
 * @Date 2021/9/1 19:31
 * @Version 1.0
 **/

public class Solution {
    @Test
    public void test(){
        int[] nums = {};
        System.out.println(nums == null);
        //partition(nums, 0, nums.length-1);
    }
    public void partition(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            nums[left] = nums[right];

            while (left < right && nums[left] % 2 != 0) {
                left++;
            }

            nums[right] = nums[left];
        }

        nums[left] = temp;
    }
}
