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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prev = dummyHead;
        ListNode curr = head;
    
        for(int i=1; i<=n; i++) {
            curr = curr.next;
        }

        while(curr != null) {
            prev = prev.next;
            curr = curr.next;
        }
        
        prev.next = prev.next.next;

        return dummyHead.next;
    }

}
