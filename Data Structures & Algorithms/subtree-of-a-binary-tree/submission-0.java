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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);
        boolean same = isSameTree(root, subRoot);

        return left || right || same;
    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null){
            return true;
        }

        if (!(root!=null && subRoot !=null)){
            return false;
        }

        if (root.val == subRoot.val){
            return true && isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right); 
        } 

        return false;
    }
}
