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
    public boolean hasCycle(ListNode head) {

        if(head == null) {
            return false;
        }
        ListNode t = head;
        ListNode r = head;
        while(r != null && r.next != null) {
            t = t.next;
            r = r.next.next;
            if(t == r) {
                return true;
            }
        }
        return false;

    }
}
