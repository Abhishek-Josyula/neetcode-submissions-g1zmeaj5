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
        HashMap<Node, Node> map = new HashMap<>();
        if (head==null) return null;
        Node curr = head;
        while (curr!=null){
            Node t = new Node(curr.val);
            map.put(curr, t);
            curr = curr.next;
        }

        curr = head;
        while (curr!=null){
            Node t = map.get(curr);
            t.next = map.get(curr.next);
            t.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}
