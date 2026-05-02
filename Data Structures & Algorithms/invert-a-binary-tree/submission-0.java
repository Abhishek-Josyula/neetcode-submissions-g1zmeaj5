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
    public TreeNode invertTree(TreeNode root) {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        if (root==null) return root;

        while(nodes.size()!=0){
            TreeNode currnode = nodes.remove(nodes.size()-1);

            if (currnode.left!=null){
                nodes.add(currnode.left);
            }
            if (currnode.right!=null){
                nodes.add(currnode.right);
            }

            TreeNode temp = currnode.left;
            currnode.left = currnode.right;
            currnode.right = temp;
        }

        return root;
    }
}
