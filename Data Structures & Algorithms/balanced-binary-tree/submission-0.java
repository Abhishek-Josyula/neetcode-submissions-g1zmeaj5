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
    public boolean isBalanced(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(null, 0);
        return isbal(root, map);
    }

    public boolean isbal(TreeNode node, HashMap<TreeNode, Integer> map){
        if (node == null){
            return true;
        }

        boolean balLeft = isbal(node.left, map);
        boolean balRight = isbal(node.right, map);

        int lefth = map.get(node.left);
        int righth = map.get(node.right);
        map.put(node, Math.max(lefth, righth) + 1);

        if (Math.abs(lefth-righth)>1) return false;

        return balLeft && balRight;
    }
}
