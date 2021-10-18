package Offer28;

import org.junit.Test;

/**
 * @ClassName Solution
 * @Author dy
 * @Date 2021/9/3 10:19
 * @Version 1.0
 **/

public class Solution {

    @Test
    public void test() {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(2);
        A.left.right = new TreeNode(3);
        A.right.right = new TreeNode(3);

        TreeNode treeNode = mirrorTree(A);

        match(A,treeNode);

        System.out.println(isSymmetric(A));
        System.out.println(666);
    }

    public boolean isSymmetric(TreeNode root) {
        TreeNode mirror = mirrorTree(root);
        return match(root, mirror);

    }

    public boolean match(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }

        if (A == null || B == null){
            return false;
        }
        if (A.val != B.val) {
            return false;
        }

        return match(A.left, B.left) && match(A.right, B.right);

    }

    public TreeNode mirrorTree(TreeNode root) {
        TreeNode node = new TreeNode(0);
        if (root == null) {
            node = null;
            return node;
        }
        node.right = mirrorTree(root.left);
        node.left = mirrorTree(root.right);
        node.val = root.val;
        return node;
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
