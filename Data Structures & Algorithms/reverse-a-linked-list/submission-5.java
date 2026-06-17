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
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }

    public ListNode reverse(ListNode current) {
        if(current == null || current.next == null) {
            return current;
        }
        ListNode reversed = reverse(current.next);
        current.next.next = current;
        current.next = null;
        return reversed;
    }
}
