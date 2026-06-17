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
        int count = 0;
        ListNode curr = head;
        while(curr != null) {
            count++;
            curr = curr.next;
        }

        int index = count - n;

        if(index == 0) {
            return head.next;
        }

        curr = head;
        int i = 0; 
        while(curr.next != null) {
            if(i + 1  == index) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
            i++;
        }

        return head;
    }
}
