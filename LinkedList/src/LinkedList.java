import javax.swing.*;
import java.lang.reflect.Type;

public class LinkedList {

    // Variable head of Node type
    private Node head;

    // Variable tail of Node type
    private Node tail;

    // Variable for length of LL
    private int length;


    // Class for Node
    public class Node{
        int value;
        Node next;

        //Node constructor
        Node(int value){
            this.value = value;
        }
    }


    // Constructor to start the LL
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

    public Node removeLast(){

        Node temp = head;
        Node pre = head;

        if (length == 0) { //or head == null
            return null;
        } else if (length == 1) {
            head = null;
            tail = null;
            length--;
            return temp;
        }

        while (temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        return temp;
    }

    // function to add element at the start
    public void prependElem(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    //Method to remove the first element of the linked list
    public Node removeFirst(){

        Node temp;

        if (length == 0){
            return null;
        } else if (length == 1) {
            temp = head;
            head = null;
            tail = null;
        } else {
            temp = head;
            head = null;
            head = temp.next;
        }
        length--;
        return temp;
    }

    public Node getNodeByIndex(int index){
        if (index >= length || index < 0) return null;
        Node temp = head;
        for (int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean setValueByIndex(int index, int value){
        if (index >= length || index < 0) return false;
        Node temp = head;
        for (int i=0; i<length; i++){
            if (i == index){
                temp.value = value;
            }
            temp = temp.next;
        }
        return true;
    };


    // Method to insert element at a particular index position
    public boolean insertElem(int index, int value){

        if (index < 0 || index > length){
            return false;
        } else if (index == 0) {
            prependElem(value);
        } else {
            Node newNode = new Node(value);
            Node temp = getNodeByIndex(index - 1);

            newNode.next = temp.next;
            temp.next = newNode;
            length++;

        }
        return true;
    }


    // Method to get Head of the LL
    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    // Method to get Tail of a LL
    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    // Method to get Length of LL
    public void getLength() {
        System.out.println("Length: " + length);
    }

}
