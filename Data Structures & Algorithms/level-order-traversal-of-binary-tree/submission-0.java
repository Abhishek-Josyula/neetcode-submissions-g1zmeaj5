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
    TreeNode t;
    int level;

    Tup(TreeNode t, int level){
        this.t = t;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return new ArrayList<List<Integer>>();
        }
        Deque<Tup> q = new ArrayDeque<>();
        Tup r = new Tup(root, 1);
        q.offerLast(r);

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int maxl=1;

        while(q.size()>0){
            Tup curr = q.pollFirst();
            List<Integer> l = map.getOrDefault(curr.level, new ArrayList<Integer>());
            l.add(curr.t.val);
            map.put(curr.level, l);

            if (curr.t.left!=null){
                Tup ln = new Tup(curr.t.left, curr.level + 1);
                q.offerLast(ln);
            }

            if (curr.t.right!=null){
                Tup rn = new Tup(curr.t.right, curr.level + 1);
                q.offerLast(rn);
            }

            maxl = Math.max(maxl, curr.level + 1);
        }

        List<List<Integer>> ret = new ArrayList<>();
        for (int i=1; i<maxl; i++){
            ret.add(map.get(i));
        }

        return ret;
    }
}
