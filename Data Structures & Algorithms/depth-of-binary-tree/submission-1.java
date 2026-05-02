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

record Pair<T1, T2>(T1 first, T2 second) {}

class Solution {
    public int maxDepth(TreeNode root) {
        int maxh = 0;
        if (root==null) return maxh;

        ArrayList<Pair<TreeNode, Integer>> dfs = new ArrayList<>();
        dfs.add(new Pair<TreeNode, Integer>(root, 1));
        while (dfs.size()!=0){
            Pair<TreeNode, Integer> curr = dfs.remove(dfs.size()-1);
            maxh = Math.max(maxh, curr.second);

            if (curr.first.left!=null){
                Pair<TreeNode, Integer> l = new Pair<>(curr.first.left, curr.second+1);
                dfs.add(l);
            }

            if (curr.first.right!=null){
                Pair<TreeNode, Integer> r = new Pair<>(curr.first.right, curr.second+1);
                dfs.add(r);
            }
        }

        return maxh;
    }
}
