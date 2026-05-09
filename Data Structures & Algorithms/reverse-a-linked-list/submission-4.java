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
    public ListNode reverseList(ListNode head) {
/*        
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while(curr != null) {
            stack.push(curr);
            curr = curr.next; 
        }
        if(stack.size() <= 1) {
            return head;
        }
         
        head = stack.pop();
        curr = head;
        while(!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }
        curr.next = null;
        return head;
*/

//        return reverse(head);

        ListNode prev = null;
        ListNode curr = head;
        ListNode temp;
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode reverse(ListNode current) {
        if(current == null || current.next == null) {
            return current;
        }
        ListNode rem = reverse(current.next);
        current.next.next = current;
        current.next = null;
        return rem;
    }

}
