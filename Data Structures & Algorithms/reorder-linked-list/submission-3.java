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
/*
        Map<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        ListNode curr = head;
        while(curr != null) {
            map.put(index, curr);
            index++;
            curr = curr.next;
        }
        int n = index;

        curr = head;
        for(int i=1; i<n; i++) {
            int idx = i/2;
            if(i % 2 == 1) {
                idx = n - (idx + 1);
            } 
            curr.next = map.get(idx);
            curr = curr.next;
            curr.next = null;
        }
*/        
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        int n=list.size();
        int l=0;
        int r=n-1;

        while(l < r) {
            list.get(l).next = list.get(r);
            l++;
            if(l >= r) {
                break;
            }
            list.get(r).next = list.get(l);
            r--;
        }
        list.get(l).next = null;

    }
}
