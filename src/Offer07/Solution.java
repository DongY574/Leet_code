package Offer07;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Author dy
 * @Date 2021/8/4 14:37
 * @Version 1.0
 **/

public class Solution {
    @Test
    public void test(){
        buildTree(new int[]{1,2,3}, new int[]{2,1,3});
    }
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i],i);
        }
        return myBuildTree(preorder, 0, inorder.length-1, 0);
    }

    public TreeNode myBuildTree(int[] preorder, int left, int right, int root) {
        if (left > right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        int i = inorderMap.get(preorder[root]);

        node.left = myBuildTree(preorder, left, i - 1, root + 1);
        node.right = myBuildTree(preorder, i + 1, right, root + i + 1 - left);
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