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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = null;
        ListNode temp = null;
        while(list1 != null || list2!=null){
            if (list1==null){
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
                continue;
            }

            if (list2==null){
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
                continue;
            }

            if (list1.val < list2.val){
                if (head==null){
                    head = list1;
                    temp = list1;
                    list1 = list1.next;
                    continue;
                }
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;

            } else{
                if (head==null){
                    head = list2;
                    temp = list2;
                    list2 = list2.next;
                    continue;
                }

                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        return head;
    }
}