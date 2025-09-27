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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode head2 = head.next;
        ListNode p1 = head, p2 = head2;
        while (p2.next != null) {
            p1.next = p2.next; 
            p1 = p1.next;
            if (p1.next != null) {
                p2.next = p1.next; 
                p2 = p2.next;
            } else break;
        }
        p1.next = head2;
        p2.next = null;
        return head;        
    }
}