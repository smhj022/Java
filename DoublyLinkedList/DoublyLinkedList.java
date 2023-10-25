package DoublyLinkedList;

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
            System.out.println(temp.value);
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

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length){
            append(value);
            return true;
        }

        Node newNode = new Node(value);

        Node beforeNode = get(index-1);

        Node afterNode = beforeNode.next;

        beforeNode.next = newNode;
        newNode.next = afterNode;
        newNode.prev = beforeNode;
        afterNode.prev = newNode;

        return true;
    }
}
