/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        List<Node> list = new ArrayList<>();
        Node curr = head;
        while(curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        Node newHead = null;
        Node prev = null;
        Map<Node, Node> map = new HashMap<>();
        for(int i=0; i<list.size(); i++) {
            Node og = list.get(i);
            curr = new Node(og.val);
            if(prev != null) {
                prev.next = curr;
            } else {
                newHead = curr;
            }
            map.put(og, curr);
            prev = curr;
        }

        Node ogCurr = head;
        curr = newHead;
        while(ogCurr != null) {
            Node random = map.get(ogCurr.random);
            curr.random = random;
            ogCurr = ogCurr.next;
            curr = curr.next;
        }

        return newHead;
    }
}
