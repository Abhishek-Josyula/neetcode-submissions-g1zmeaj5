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
    public void reorderList(ListNode head) {
        ListNode end = head;
        int count = 0;
        while(end!=null) {
            count++;
            end = end.next;
        }
        int s1 = (int)Math.ceil((double)count/2);
        ListNode s = head;
        ListNode prev = null;
        while (s1>0){
            prev = s;
            s = s.next;
            s1--;
        }
        prev.next=null;

        prev = null;
        ListNode curr = s;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;            
        }

        s = prev;

        ListNode first = head;
        ListNode second = s;
        while(second!=null){
            ListNode t1 = first.next;
            ListNode t2 = second.next;
            first.next = second;
            if (t1==null) break;
            first = t1;
            second.next = first;
            second = t2;
        }

    }
}
