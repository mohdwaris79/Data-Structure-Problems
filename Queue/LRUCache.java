import java.util.*;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insertAtHead(node); 
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtHead(node);
        } else {
            if (map.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            insertAtHead(node);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

   
    public void printCache() {
        Node curr = head.next;
        System.out.print("Cache state: ");
        while (curr != tail) {
            System.out.print("(" + curr.key + "," + curr.value + ") ");
            curr = curr.next;
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        cache.printCache(); // Expected: (3,30) (2,20) (1,10)

        System.out.println("Get 2: " + cache.get(2)); // 20
        cache.printCache(); // Expected: (2,20) (3,30) (1,10)

        cache.put(4, 40); // evicts key 1
        cache.printCache(); // Expected: (4,40) (2,20) (3,30)

        System.out.println("Get 1: " + cache.get(1)); // -1 (not found)
        System.out.println("Get 3: " + cache.get(3)); // 30
        cache.printCache(); // Expected: (3,30) (4,40) (2,20)
    }
}
