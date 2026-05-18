/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;

        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, (a,b)->Integer.compare(a.val, b.val));

        for (int i=0; i<lists.length; i++){
            q.add(lists[i]);
        }

        ListNode start = q.poll();
        if (start.next!=null) q.add(start.next);
        ListNode curr = start;
        while(q.size()!=0){
            ListNode t = q.poll();
            if (t.next!=null) q.add(t.next);
            curr.next = t;
            curr = t;
        }

        return start;
    }
}
