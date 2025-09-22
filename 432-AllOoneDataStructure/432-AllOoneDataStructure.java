// Last updated: 22/09/2025, 16:17:32
import java.util.*;

class AllOne {
    private class Node {
        int count;
        Set<String> keys = new HashSet<>();
        Node prev, next;
        Node(int c) { count = c; }
    }

    private Node head, tail;
    private Map<String, Node> map;

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public void inc(String key) {
        Node node = map.get(key);
        if (node == null) {
            Node next = head.next;
            if (next.count != 1) {
                Node newNode = new Node(1);
                insertAfter(head, newNode);
                next = newNode;
            }
            next.keys.add(key);
            map.put(key, next);
        } else {
            Node next = node.next;
            if (next == tail || next.count != node.count + 1) {
                Node newNode = new Node(node.count + 1);
                insertAfter(node, newNode);
                next = newNode;
            }
            next.keys.add(key);
            map.put(key, next);
            node.keys.remove(key);
            if (node.keys.isEmpty()) remove(node);
        }
    }
    
    public void dec(String key) {
        Node node = map.get(key);
        if (node.count == 1) {
            map.remove(key);
            node.keys.remove(key);
            if (node.keys.isEmpty()) remove(node);
        } else {
            Node prev = node.prev;
            if (prev == head || prev.count != node.count - 1) {
                Node newNode = new Node(node.count - 1);
                insertAfter(prev, newNode);
                prev = newNode;
            }
            prev.keys.add(key);
            map.put(key, prev);
            node.keys.remove(key);
            if (node.keys.isEmpty()) remove(node);
        }
    }
    
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
    
    private void insertAfter(Node prev, Node node) {
        node.next = prev.next;
        node.prev = prev;
        prev.next.prev = node;
        prev.next = node;
    }
    
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
