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
    boolean p;
    boolean q;
    TreeNode lca;
}

class Solution {
    HashMap<TreeNode, boolean[]> ret;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return lcasolver(root, p, q).lca;
    }

    public Tup lcasolver(TreeNode root, TreeNode p, TreeNode q){
        if (root==null){
            Tup t1 = new Tup();
            t1.p = false;
            t1.q = false;
            t1.lca = null;
            return t1;
        }

        boolean pr = false;
        boolean qr = false;

        if (root.val == p.val){
            pr = true;
        }

        if (root.val == q.val){
            qr = true;
        }

        Tup left = lcasolver(root.left, p, q);
        Tup right = lcasolver(root.right, p, q);
        TreeNode lca = null;

        if (left!=null){
            pr = pr || left.p;
            qr = qr || left.q;
        }

        if (right!=null){
            pr = pr || right.p;
            qr = qr || right.q;
        }

        if (pr && qr &&  left.lca==null &&  right.lca == null){
            lca = root;
        } else if (left!= null && left.lca != null) {
            lca = left.lca;
        } else {
            if (right!=null){
                lca = right.lca;
            }
        }
        Tup t = new Tup();
        t.p = pr; 
        t.q = qr;
        t.lca = lca;
        return t;
    }
}
