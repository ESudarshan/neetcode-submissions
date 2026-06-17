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
        if(n == 0) {
           return null;
        }

        while(lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            int i=0;
            while(i < lists.length) {
                mergedLists.add(merge(lists[i], (i + 1) < lists.length ? lists[i+1] : null));
                i += 2;
            }
            lists = mergedLists.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(-1, null);
        
        ListNode curr = head;
        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        if(head1 != null) {
            curr.next = head1;
        } else {
            curr.next = head2;
        }

        return head.next;
    }
}
