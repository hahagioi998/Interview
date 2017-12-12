package LinkedList;

import java.util.HashMap;

public class LRUCache {
    private class Node{
        Node prev;
        Node next;
        int key;
        int value;

        //node必须有前后指针
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
    //创建两个node
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        //把tail和head在一开始连起来
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        //找不到
        if( !hs.containsKey(key)) {
            return -1;
        }

        // remove current
        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current to tail
        move_to_tail(current);

        return hs.get(key).value;
    }

    public void set(int key, int value) {
        // this internal `get` method will update the key's position in the linked list.
        if (get(key) != -1) {
            hs.get(key).value = value;
            return;
        }
        //满了
        if (hs.size() == capacity) {
            //拿掉最开头的lru
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        //创建一个新的node
        Node insert = new Node(key, value);
        hs.put(key, insert);
        move_to_tail(insert);
    }

    private void move_to_tail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}
