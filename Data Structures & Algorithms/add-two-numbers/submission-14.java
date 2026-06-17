
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

        ListNode head = null;
        ListNode prev = null;
        int c = 0;
        while(l1 != null || l2 != null || c != 0) {
            int l1d = l1 != null ? l1.val : 0;
            int l2d = l2 != null ? l2.val : 0;
            int sum = c + l1d + l2d;
            int d = sum % 10;
            c = sum / 10;
            ListNode curr = new ListNode(d); 
            if(prev == null) {
                head = curr;
            } else {
                prev.next = curr;
            }
            prev = curr; 
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return head;

    }
}
