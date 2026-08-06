import java.util.*;

public class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private Map<Integer, Node> cache;
    private int size;
    Node dummyHead;
    Node dummyTail;

    public LRUCache(int capacity) {
        this.dummyHead = new Node(-1, -1);
        this.dummyTail = new Node(-1, -1);
        this.cache = new HashMap<>();
        this.size = capacity;
    }

    private void addNode(Node node) {
        Node temp = dummyHead.next;
        node.next = temp;
        node.prev = dummyHead;
        dummyHead.next = node;
        temp.prev = node;
    }

    private void deleteNode(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;

        Node resNode = cache.get(key);
        deleteNode(resNode);
        addNode(resNode);
        return resNode.val;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key))
        {
            Node existingNode = cache.get(key);
            existingNode.val = value;
            deleteNode(existingNode);
            addNode(existingNode);
        } else {
            if(cache.size() == size)
            {
                Node lastNode = dummyTail.prev;
                cache.remove(lastNode.key);
                deleteNode(lastNode);
            }
            Node newEntry = new Node(key, value);
            cache.put(key, newEntry);
            addNode(newEntry);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */