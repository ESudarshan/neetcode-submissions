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
    public void reorderList(ListNode head) {        
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null; 
        
        ListNode prev = null;
        ListNode curr = second;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode first = head;
        second = prev;

        ListNode i = first;
        while(i != null) {
            i = i.next;
        }
        
        i = second;
        while(i != null) {
            i = i.next;
        }


        while(second != null) {
            ListNode tempF = first.next;
            ListNode tempS = second.next;
            first.next = second;
            second.next = tempF;
            first = tempF;
            second = tempS;
        } 

    }
}
