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
/*
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
            if(set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
*/
        if(head == null) {
            return false;
        }
        ListNode t = head;
        ListNode r = head.next;
        while(t != null && r != null) {
            if(t == r) {
                return true;
            }
            if(r.next == null) {
                return false;
            }
            t = t.next;
            r = r.next.next;
        }
        return false;

    }
}
