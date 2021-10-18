package Offer17;

import org.junit.Test;

/**
 * @ClassName Solution
 * @Author dy
 * @Date 2021/9/1 12:14
 * @Version 1.0
 **/

public class Solution {
    @Test
    public void test(){
        printNumbers(1);
    }
    public int[] printNumbers(int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            str = str + "9";
        }
        int num = Integer.parseInt(str);
        int[] res = new int[num];
        for (int i = 1; i <= num; i++) {
            res[i - 1] = i;
        }

        return res;
    }
}
