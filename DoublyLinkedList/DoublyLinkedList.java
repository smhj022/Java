package DoublyLinkedList;

import java.util.Optional;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
        }
    }

    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        newNode.next = null;
        newNode.prev = null;
        length++;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head: " +head.value);
    }

    public void getTail() {
        System.out.println("Tail: " +tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int value) {

        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;
    }

    public Node removeLast(){

        if (length == 0){
            return null;
        }

        Node temp = tail;

        if (head == tail){
            head = null;
            tail = null;
        } else{
            tail = temp.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    public void prepend(int value){

        Node newNode = new Node(value);

        if (head == null){
            head = newNode;
            tail = newNode;
        } else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){

        if(head == null){
            return null;
        }
        Node temp = head;
        if(head == tail){
            head = null;
            tail = null;
        } else{
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get(int index) {

        if (index < 0 || index > length) {
            return null;
        }

        Node temp = head;

        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value){

        Node getNode = get(index);

        if (getNode == null){
            return false;
        }

        getNode.value = value;
        return true;
    }

    public boolean insert(int index, int value){

        if (index < 0 || index > length) return false;

        // insert at start
        if (index == 0) {
            prepend(value);
            return true;
        }
        // insert at end
        else if (index == length){
            append(value);
            return true;
        }

        // insert node in between
        Node newNode = new Node(value);
        Node beforeNode = get(index - 1);
        Node afterNode = beforeNode.next;
        beforeNode.next = newNode;
        newNode.next = afterNode;
        newNode.prev = beforeNode;
        afterNode.prev = newNode;
        length++;
        return true;
    }

    public Node remove(int index){

        if(index < 0 || index >= length) return null;
        // remove form start
        if (index == 0) return removeFirst();
        // remove from end
        if (index == length-1) return removeLast();

        // remove nodes in between
        Node removedNode;
        Node beforeNode = get(index-1);
        removedNode = beforeNode.next;
        Node afterNode = removedNode.next;


        beforeNode.next = removedNode.next;
        afterNode.prev = removedNode.prev;
        removedNode.next = null;
        removedNode.prev = null;
        length--;
        return removedNode;
    }

    // Method to swap first and last node of an DLL
    public void swapFirstLast(){
        if(head==null || head==tail)return;

        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    // Method to reverse a DLL
    public void reverse(){

        if(head == null || head == tail) return;

        Node p1 = head;
        Node p2 = tail;

        int iter = 0;

        while(iter < length/2) {

            int temp = p1.value;
            p1.value = p2.value;
            p2.value = temp;

            p1 = p1.next;
            p2 = p2.prev;
            iter++;
        }
    }

    public void swapPairs(){

        if(head == null || head.next == null) return;

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        head.prev = dummyNode;
        head = dummyNode;

        Node p1 = head.next;
        Node p2 = head.next.next;

        while(p1 != null && p1.next != null){

            p2 = p1.next;

            p1.next = p2.next;
            p2.next = p1;
            if (p1.next != null){
                p1.next.prev = p1;
            }

            p2.prev = p1.prev;
            p1.prev.next = p2;
            p1.prev = p2;
            p1 = p1.next;
        }

        head = head.next;
        head.prev = null;
    }
}
