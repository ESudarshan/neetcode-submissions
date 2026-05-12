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
/*        
        int n = 0;
        ListNode curr = head;
        while(curr != null) {
            n++;
            curr = curr.next;
        }
        System.out.println(n);

        int rep = n/k;
        int i = 0;
        ListNode currHead = head;
        ListNode prevHead = null;
        ListNode newHead = null;
        while(i < rep) {
            ListNode prev = null;
            curr = currHead;
            int j = 0;
            while(j < k) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
                j++;
            }
            if(newHead == null) {
                newHead = prev;
            }
            if(prevHead != null) {
                prevHead.next = prev;
            }
            prevHead = currHead;
            currHead = curr;
            i++;
        }
        prevHead.next = currHead;
        return newHead;
*/

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
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
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
