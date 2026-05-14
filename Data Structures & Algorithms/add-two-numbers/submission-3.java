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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode((l1.val+l2.val)%10);
        int carry = (l1.val+l2.val)/10;
        ListNode curr = head;
        l1=l1.next;
        l2=l2.next;
        while(l1!=null || l2!=null){
            if (l1==null || l2 == null){
                ListNode l = l1 == null ? l2 : l1;
                ListNode t = new ListNode((l.val+carry)%10);
                curr.next = t;
                curr = curr.next;
                carry = (l.val+carry)/10;
                if (l1!=null) l1=l1.next;
                if (l2!=null) l2=l2.next;
                continue;
            }

            ListNode t = new ListNode((l1.val+l2.val+carry)%10);
            curr.next = t;
            curr = t;
            carry = (l1.val+l2.val+carry)/10;
            l1=l1.next;
            l2=l2.next;

        }
        if (carry!=0){
            ListNode t = new ListNode(carry);
            curr.next = t;
        }
        return head;
    }
}
