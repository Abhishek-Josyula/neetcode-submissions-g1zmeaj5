class Node{
    int key;
    int val;
}

class LRUCache {

    HashMap<Integer, Node> map;
    ArrayDeque<Node> ll;
    int lrucap;
    public LRUCache(int capacity) {
        map = new HashMap();
        ll = new ArrayDeque();
        lrucap = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            ll.remove(map.get(key));
            ll.addLast(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node n = map.get(key);
            n.val = value;
            ll.remove(n);
            ll.addLast(n);
            return;
        }

        if (ll.size()==lrucap){
            Node n = ll.pollFirst();
            map.remove(n.key);
        }

        Node newN = new Node();
        newN.key = key;
        newN.val = value;
        ll.addLast(newN);//
        map.put(key, newN);
    }
}
