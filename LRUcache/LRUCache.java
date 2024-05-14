package LRUcache;

import java.util.HashMap;

public class LRUCache {

    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> hm;

    static class Node{
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }



    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        if(hm.get(key) != null){
            //System.out.println(head.key + " " + tail.key);
            // delete node from hm and linked list
            Node temp = deleteNode(key);
            //System.out.println(head.key + " " + tail.key);
            // add node at last;
            addLast(temp);
            hm.put(key, temp);
            //System.out.println(head.key + " " + tail.key);
            return temp.val;
        }
        return -1;
    }

    public void put(int key, int value) {

        Node temp = new Node(key, value);

        if(hm == null || hm.size() < capacity){
            hm.put(key, temp);
            addLast(temp);
        }

        else if(hm.get(key) != null){
            deleteNode(key);
            hm.put(key, temp);
            addLast(temp);
        }

        else{
            hm.remove(head.key);
            removeFirst();
            hm.put(key, temp);
            addLast(temp);
        }
    }


    public Node deleteNode(int key){

        Node node = hm.get(key);

        if(head == tail){
            head = null;
            tail = null;
        }

        else if(node == tail){
            tail = tail.prev;
            node.prev.next = node.next;
        }
        else if(node == head){
            head = head.next;
            node.next.prev = node.prev;
        }
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        hm.remove(key);
        return node;
    }

    public void addLast(Node node){

        if(head == null){
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void removeFirst(){

        if(head == null) return;

        if(head == tail){
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }
    }


}
