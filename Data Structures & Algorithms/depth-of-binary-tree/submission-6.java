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

class Tup{
    TreeNode curr;
    int currd;

    Tup(TreeNode curr, int d){
        this.curr = curr;
        this.currd = d; 
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        int maxd = -1;
        Tup rooot = new Tup(root, 1);
        Stack<Tup> s = new Stack<>();
        s.push(rooot);

        while (s.size()!=0){
            Tup currN = s.pop();
            maxd = Math.max(maxd, currN.currd);

            if (currN.curr.left!=null){
                Tup t = new Tup(currN.curr.left, currN.currd + 1);
                s.push(t);
            }

            if (currN.curr.right!=null){
                Tup t = new Tup(currN.curr.right, currN.currd + 1);
                s.push(t);
            }
        }

        return maxd;
    }
}
