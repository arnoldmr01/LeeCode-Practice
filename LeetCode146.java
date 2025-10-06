/*
The reason why we use Map + double linked list is that:
1. Map provides O(1) access time to get item by key

IMPORTANT!!!
2. Double linked list provides O(1) time to remove and add node because 
it doesn't require to traverse the list to find the previous node and next node.

Thus, the tips are to use Map to get the node, then due to double linked list, we can remove and add the node in O(1) time.

*/

class LRUCache {
    public static class Node{
        int key, val;
        Node pre, next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node dummy;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.dummy = new Node(0, 0);
        head.next = dummy;
        dummy.pre = head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if (n == null) return -1;
        moveToHead(n);
        return n.val;
        
    }
    
    public void put(int key, int val) {
        if (map.containsKey(key)){
            Node n = map.get(key);
            n.val = val;
            moveToHead(n);
            return;
        }

        Node newNode = new Node(key, val);
        map.put(key, newNode);
        addAfterHead(newNode);
        if (map.size() > capacity){
            Node lru = popTail();
            map.remove(lru.key);
        }

    }

    private void remove(Node n){
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }

    private void addAfterHead(Node n){
        n.next = head.next;
        n.pre = head;
        head.next.pre = n;
        head.next = n;
    }

    private void moveToHead(Node n) {
        remove(n);
        addAfterHead(n);
    }

    private Node popTail() { // remove LRU
        Node lru = dummy.pre;
        remove(lru);
        return lru;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */