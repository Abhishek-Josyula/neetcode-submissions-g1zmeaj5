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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = maxdia(root);

        return ans[1];
    }

    public int[] maxdia(TreeNode root){
        if (root==null){
            return null;
        }

        // maxh, max dia
        int[] ret = new int[2];

        int[] left = maxdia(root.left);
        int[] right = maxdia(root.right);

        if (left!=null && right==null){
            ret[0] = left[0]+1;
            ret[1] = Math.max(1+left[0], left[1]);
        }

        if (right!=null && left==null){
            ret[0] = right[0]+1;
            ret[1] = Math.max(1+right[0], right[1]);
        }

        if (right!=null && left!=null){
            ret[0] = Math.max(left[0], right[0]) + 1;
            ret[1] = Math.max(left[0] + right[0] + 2, Math.max(left[1], right[1]));
        }

        return ret;
    }
}
