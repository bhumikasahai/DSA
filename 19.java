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

    int lengthOfLL(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
             count ++;
             temp = temp.next;
        }
        return count;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = lengthOfLL(head);
        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while (temp != null) {
            if (count == n) {
                prev.next = temp.next;
                return dummy.next;
            }
            count --;
            prev = temp;
            temp = temp.next;
        }
        return dummy.next;
    }
}