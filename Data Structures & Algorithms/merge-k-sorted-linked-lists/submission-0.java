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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        for(int i=1; i<n; i++) {
            lists[i] = merge(lists[i], lists[i-1]);
        }
        return n == 0 ? null : lists[n-1];
    }

    ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(-1, null);
        ListNode og = head;
        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                head.next = head1;
                head1 = head1.next;
            } else {
                head.next = head2;
                head2 = head2.next;
            }
            head = head.next;
        }

        if(head1 != null) {
            head.next = head1;
        } else {
            head.next = head2;
        }

        return og.next;
    }
}
