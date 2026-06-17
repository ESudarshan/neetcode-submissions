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
    
        int i = 1;
        while(curr != null) {
            if(i > n) {
                prev = prev.next;
            }
            curr = curr.next;
            i++;
        }
        
        prev.next = prev.next.next;

        return dummyHead.next;
    }

}
