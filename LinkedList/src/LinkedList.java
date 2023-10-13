import java.util.HashSet;
import java.util.Set;
import java.lang.Math;
public class LinkedList {

    // Variable head of Node type
    private Node head;

    // Variable tail of Node type
    private Node tail;

    // Variable for length of LL
    private int length;


    // Class for Node
    public class Node {
        int value;
        Node next;

        //Node constructor
        Node(int value) {
            this.value = value;
        }
    }


    // Constructor to start the LL
    public LinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;

    }

    // Method to print all the element of linked list.
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    // Method to append elem in linked list.
    public void appendElem(int value) {
        Node newNode = new Node(value);

        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            tail.next = newNode;
            this.tail = newNode;
        }
        length++;
    }

    public Node removeLast() {

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

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        return temp;
    }

    // function to add element at the start
    public void prependElem(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    //Method to remove the first element of the linked list
    public Node removeFirst() {

        Node temp;

        if (length == 0) {
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

    public Node getNodeByIndex(int index) {
        if (index >= length || index < 0) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean setValueByIndex(int index, int value) {
        if (index >= length || index < 0) return false;
        Node temp = head;
        for (int i = 0; i < length; i++) {
            if (i == index) {
                temp.value = value;
            }
            temp = temp.next;
        }
        return true;
    }

    ;


    // Method to insert element at a particular index position
    public boolean insertElem(int index, int value) {

        if (index < 0 || index > length) {
            return false;
        } else if (index == 0) {
            prependElem(value);
        } else if (index == length) {
            appendElem(value);
        } else {
            Node newNode = new Node(value);
            Node temp = getNodeByIndex(index - 1);

            newNode.next = temp.next;
            temp.next = newNode;
            length++;

        }
        return true;
    }

    public Node removeElemByIndex(int index) {

        Node removedElem;

        if (index < 0 || index >= length) {
            return null;
        } else if (index == 0) {
            removedElem = removeFirst();
        } else if (index == length - 1) {
            removedElem = removeLast();
        } else {
            Node temp = getNodeByIndex(index - 1);
            removedElem = temp.next;
            temp.next = removedElem.next;
            removedElem.next = null;
            length--;
        }
        return removedElem;
    }

//    public void reverse(){
//        Node temp = head;
//        head = tail;
//        tail = temp;
//
//        Node after = temp.next;
//        Node before = null;
//
//        for(int i=0; i<length;i++){
//            after=temp.next;
//            temp.next = before;
//            before = temp;
//            temp = after;
//        }
//    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node before = null;
        Node after = temp.next;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

    }

    // Refer Question 1.
    public Node findMiddleNode() {

        Node slow = head;
        Node fast = head;

        if (head == tail || head == null) {
            return null;
        } else {
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
        }

        return slow;
    }


    // Question2: method to find if a linked list has a loop or not
    public boolean hasLoop() {

        if (head == null || head == tail) {
            return false;
        }

        Node slow = null;
        Node fast = head;


        while (fast != slow && fast != null && fast.next != null) {
            if (slow == null) {
                slow = head;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == slow;
    }

    // Question 3: Method to find Kth node from the end of the linked list.
    public Node findKthFromEnd(int k) {

        if (head == null) return null;

        Node before = head;
        Node after = head;

        for (int i = 1; i < k; i++) {
            if (after.next == null) return null;
            after = after.next;
        }

        while (after != tail) {
            after = after.next;
            before = before.next;
        }
        return before;
    }


    public void partitionList(int x) {

        if (head == null) return;

        Node less_head = null;
        Node more_head = null;
        Node current = head;
        Node less_temp = head;
        Node more_temp = head;


        while (current != null) {
            if (current.value < x) {

                if (less_head == null) {
                    less_head = current;
                    less_temp = current;
                } else {
                    less_temp.next = current;
                    less_temp = less_temp.next;
                }
            } else {
                if (more_head == null) {
                    more_head = current;
                    more_temp = current;
                } else {
                    more_temp.next = current;
                    more_temp = more_temp.next;
                }
            }
            current = current.next;
        }

        if (less_head == null || more_head == null) return;

        head = less_head;
        less_temp.next = more_head;
        more_temp.next = null;
    }


    public void removeDuplicates() {

        // using Hashset
        Set<Integer> set = new HashSet<Integer>();
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (set.contains(current.value)) {
                previous.next = current.next;
            } else {
                set.add(current.value);
                previous = current;
            }
            current = current.next;
        }

    }

    public int binaryToDecimal() {

        if (head == null) return 0;
        Node temp1 = head;
        int sum = 0;
        int itr = length - 1;

        while (temp1 != null) {
            sum += temp1.value * (int) Math.pow(2, itr);
            itr--;
            temp1 = temp1.next;
        }
        return sum;
    }

//

    public void reverseBetween(int startIndex, int endIndex) {

        // Empty linked list
        if (head == null) return;

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;


        for (int i = 0; i < (endIndex - startIndex); i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
            printList();
        }

        head = dummyNode.next;
    }

    public Node removeKthFormEnd(int k) {

        if (head == null) return null;

        int size=0;
        Node temp = head;

        while(temp != null){
            size++;
            temp = temp.next;
        }

        if (size == k){
            return removeFirst();
        }

        int previousNodeIndex = size - k;

        temp = head;

        for(int i = 1; i < previousNodeIndex; i++){
            temp=temp.next;
        }

        Node removedNode = temp.next;
        temp.next = temp.next.next;

        return removedNode;
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
