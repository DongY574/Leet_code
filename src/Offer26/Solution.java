package Offer26;

import org.junit.Test;

/**
 * @ClassName Solution
 * @Author dy
 * @Date 2021/9/2 17:19
 * @Version 1.0
 **/

public class Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return match(A, B) || match(A.left, B) || match(A.right, B);
    }

    @Test
    public void test() {
        TreeNode A = new TreeNode(2);
        A.left = new TreeNode(3);
        A.right = new TreeNode(2);
        A.left.left = new TreeNode(1);

        TreeNode B = new TreeNode(3);
        B.right = new TreeNode(2);
        B.right.left = new TreeNode(2);
    }

    public boolean match(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null || A.val != B.val) {
            return false;
        }

        return match(A.left, B.left) && match(A.right, B.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}