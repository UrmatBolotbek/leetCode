import java.util.HashMap;
import java.util.Map;

/*** Last Reentry Used cache ***/
class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private Node oldest;
    private Node latest;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.oldest = new Node(0, 0);
        this.latest = new Node(0, 0);
        this.oldest.next = this.latest;
        this.latest.prev = this.oldest;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToTail(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToTail(node);
        } else {
            Node node = new Node(key, value);
            if (map.size() < capacity) {
                addToTail(node);
            } else {
                map.remove(oldest.key);
                removeHead();
                addToTail(node);
            }
            map.put(key, node);
        }
    }

    private void moveToTail(Node node) {
        if (node != latest) {
            if (node != oldest) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                latest.next = node;
                node.prev = latest;
                latest = node;
                latest.next = null;
            } else {
                Node prevHead = removeHead();
                latest.next = prevHead;
                prevHead.prev = latest;
                latest = prevHead;
            }
        }
    }

    private Node removeHead() {
        if (oldest == latest) {
            oldest = null;
            latest = null;
            return null;
        } else {
            Node prevHead = oldest;
            oldest = oldest.next;
            oldest.prev = null;
            prevHead.next = null;
            return prevHead;
        }
    }

    private void addToTail(Node node) {
        if (latest != null) {
            latest.next = node;
            node.prev = latest;
        } else {
            oldest = node;
        }
        latest = node;
    }

    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
}