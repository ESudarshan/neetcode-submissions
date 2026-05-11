
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
/*        
        BigInteger sum = BigInteger.ZERO;
        BigInteger m = BigInteger.ONE;
        while(l1 != null) {
            sum = sum.add(BigInteger.valueOf(l1.val).multiply(m));
            m = m.multiply(BigInteger.valueOf(10)); 
            l1 = l1.next;
        }
        System.out.println(sum);
        m = 1;
        while(l2 != null) {
            sum += l2.val * m;
            m *= 10;
            l2 = l2.next;
        }
        System.out.println(sum);
        ListNode head = new ListNode(0);
        ListNode prev = null;
        while(sum != 0) {
            long d = sum%10;
            ListNode curr = new ListNode((int)d);
            if(prev == null) {
                head = curr;
            } else {
                prev.next = curr;
            }
            prev = curr;
            sum = sum/10;
        }
        return head;
*/        

        ListNode head = new ListNode(0);
        ListNode prev = null;
        int c = 0;
        while(l1 != null || l2 != null) {
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
        if(c != 0) {
            prev.next = new ListNode(c); 
        }
        return head;

    }
}
