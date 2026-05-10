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
/*
        int count=0;
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            list.add(curr);
            count++;
            curr = curr.next;
        }
        int remove = count - n;
        if(remove == 0) {
            head = head.next;
        } else if(remove == count-1) {
            list.get(remove-1).next = null;
        } else {
            list.get(remove-1).next = list.get(remove+1);  
        }
        return head;
*/

        int count=0;
        ListNode curr = head;
        while(curr != null) {
            count++;
            curr = curr.next;
        }

        int pos = count - n + 1;
        curr = head;
        ListNode prev = null;
        count = 0;
        while(curr != null) {
            count++;
            if(count == pos) {
                if(prev != null) {
                    prev.next = curr.next;
                } else {
                    head = curr.next;
                }
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
