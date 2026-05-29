/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    public int goodNodes(TreeNode root, int maxsofar){
        if (root==null){
            return 0;
        }

        int left = goodNodes(root.left, Math.max(maxsofar, root.val));
        int right = goodNodes(root.right, Math.max(maxsofar, root.val));

        if (root.val>=maxsofar){
            return left+right+1;
        }

        return left + right;
    }
}
