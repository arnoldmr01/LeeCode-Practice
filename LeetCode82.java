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

/*
Q1. Is the List sorted?
Q2. Can the list be empty?

*/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode cur = head;

        while(cur != null && cur.next != null){
            if (cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }

                prev.next = cur.next;
            }
            else{
                prev = prev.next;
            }

            cur = cur.next;
        }

        return dummy.next;
    }
}