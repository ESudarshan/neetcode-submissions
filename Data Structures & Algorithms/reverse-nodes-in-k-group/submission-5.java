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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1, head);
        ListNode groupPrev = dummy;
        ListNode groupNext = null; 
        while(true) {
            ListNode kth = getKth(groupPrev, k);
            if(kth == null) {
                break;
            }
            groupNext = kth.next;
            
            ListNode curr = groupPrev.next;
            ListNode prev = groupNext;
            while(curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev =  temp;
        }
        return dummy.next;

    }

    public ListNode getKth(ListNode curr, int k) {
        int i = 0;
        while (curr != null) {
            curr = curr.next;
            i++;
            if(i == k) {
                break;
            }
        }
        return curr;
    }
}
