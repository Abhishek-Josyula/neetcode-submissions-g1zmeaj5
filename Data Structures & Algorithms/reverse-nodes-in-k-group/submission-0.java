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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        ListNode prevGroupTail = null;

        while (curr!=null){
            int i = 1;
            ListNode fg = curr;
            ListNode lg = curr;
            while(i<k && lg != null){
                lg = lg.next;
                i+=1;
            }

            if (lg==null){
                if (prevGroupTail != null) {
                    prevGroupTail.next = curr;
                }
                break;
            }

            prev = null;
            curr = fg;
            next = fg.next;
            while (curr!=lg && curr !=null){
                curr.next = prev;
                prev = curr;
                curr = next;
                next = next.next;
            }

            
            if (dummy==null){
                curr.next = prev;
                fg.next = next;
                curr = next;
                dummy=new ListNode(0, lg);
            } else {
                curr.next = prev;
                fg.next = next;
                curr = next;
                prevGroupTail.next = lg;    
            }
            
            prevGroupTail = fg;
        }
        return dummy.next;
    }
}
