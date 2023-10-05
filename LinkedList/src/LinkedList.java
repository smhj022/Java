import java.lang.reflect.Type;

public class LinkedList {


    private Node head;
    private Node tail;
    private int length;

    public class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;

    }

    // Method to print all the element of linked list.
    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // Method to append elem in linked list.
    public void appendElem(int value){
        Node newNode = new Node(value);

        if (this.length == 0){
            this.head = newNode;
            this.tail = newNode;
        } else {

            tail.next = newNode;
            this.tail = newNode;
        }
        length ++;
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

}
