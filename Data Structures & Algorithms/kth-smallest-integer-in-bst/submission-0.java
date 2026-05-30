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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<Integer>();
        kthsolver(root, k, arr);
        return arr.get(arr.size()-1);
    }

    public void kthsolver(TreeNode root, int k, List<Integer> arr){
        if (root==null){
            return;
        }

        kthsolver(root.left, k, arr);
        if (arr.size()==k){
            return;
        }
        arr.add(root.val);
        if (arr.size()==k){
            return;
        }
        kthsolver(root.right, k, arr);


    }
}
