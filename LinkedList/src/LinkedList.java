package LinkedList.src;

import java.util.*;
import java.lang.Math;

public class LinkedList<I extends Number> {

    // Variable head of Node type
    public Node head;

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
        Node(){}
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

        if (head == tail || head == null) return null;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
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

//    public Node reverseLL(Node LLHead){
//
//        Node reserveHead = head;
//
//        Node pre = null;
//        Node curr = head;
//
//        while(curr != null){
//
//            Node temp = curr.next;
//            curr.next = pre;
//            pre = curr;
//            curr = temp;
//        }
//
//        return pre;
//    }
//
//    public boolean isPalindrome(){
//
//        // divide the linked list half
//        // reverse the other half
//        // compare both half
//
//        Node middleNode = findMiddleNode();
//        Node secondHalfStart = reverseLL(middleNode);
//        Node firstHalfStart = head;
//
//        printList();
//
//
//        while (secondHalfStart != null){
//
//            if (firstHalfStart.value != secondHalfStart.value){
//                return false;
//            }
//            firstHalfStart=firstHalfStart.next;
//            secondHalfStart=secondHalfStart.next;
//        }
//        return true;
//    }

    public void removeElemByValue(int value){
        Node after = head.next;
        Node before = head;

        while(after != null){

            if (after.value == value){
                before.next = after.next;
            }
            else{
                before = before.next;
            }
            after = after.next;
        }

        if (head.value == value){
            head = head.next;
        }

    }


    // delete the duplicates from a sorted linked list.:q
    public void deleteDuplicates() {

        Node pre = head;
        Node curr = head.next;

        while(curr != null) {

            if (pre.value != curr.value) {
                pre = pre.next;
            } else {
                pre.next = curr.next;
            }
            curr = curr.next;

        }
    }


//    public void mergeLinkedList(LinkedList<Number> list1, LinkedList<Number> list2){
//
//        Node dummy = new Node(-1);
//
//
//        Node p1 = list1.head;
//        Node p2 = list2.head;
//        Node p3 = dummy;
//
//
//        while (p1!=null && p2!=null){
//
//            if(p1.value < p2.value){
//                p3.next = p1;
//                p1 = p1.next;
//            }else {
//                p3.next = p2;
//                p2 = p2.next;
//            }
//            p3 = p3.next;
//        }
//
//        while(p2 != null){
//            p3.next = p2;
//            p2 = p2.next;
//            p3 = p3.next;
//        }
//
//        while(p1 != null){
//            p3.next = p1;
//            p1 = p1.next;
//            p3 = p3.next;
//        }

//    }



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


    // separate  odd even linked list
    public Node oddEvenList(Node head){

        if(head == null) return null;

        Node p1 = head;
        Node p2 = head.next;
        Node dummyNode = new Node(0);

        dummyNode.next = p2;

        while(p2 != null && p2.next != null){
            p1.next = p1.next.next;
            p2.next = p2.next.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        p1.next = dummyNode.next;

        printList();

        return head;
    };

    public Node reverseBetween(Node head, int left, int right) {

        Stack<Integer> nodeVal = new Stack<>();

        Node temp = head;
        int posi = 1;

        while(temp != null) {

            if (posi >= left && posi <= right) {
                System.out.println(temp.value);
                nodeVal.push(temp.value);
            }
            temp = temp.next;
            posi++;
        }

        temp = head;
        posi = 1;

        while(temp != null){
            if(posi >= left && posi <= right){
                int val = nodeVal.pop();
                System.out.println(val);
                temp.value = val;
            }
            temp = temp.next;
            posi++;
        }

        return head;

    }


    public int numComponents(Node node, int[] nums){

        Node temp = node;

        HashSet<Integer> hs = new HashSet<>();

        int maxRes = nums.length;

        for(int num : nums){
            hs.add(num);
        }

        boolean connected = false;

        while(temp != null && temp.next != null){

            if(hs.contains(temp.value)){
                if(connected) {
                    maxRes--;
                } else {
                    connected = true;
                }
            } else {
                connected = false;
            }
            temp = temp.next;
        }

        return maxRes;
    }

    public Node removeNthFromEnd(Node A, int B) {

        Node dummy = new Node(-1);

        dummy.next = A;

        Node p1 = dummy;
        Node p2 = dummy;

        for(int i = 0; i <= B; i++){
            if(p1 == null){
                return dummy.next;
            }
            p1 = p1.next;
        }

        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;

        head = dummy.next;
        printList();

        return A;
    }

    public Node reverseListByK(Node head, int k){

        if(head == null || head.next == null) return head;

        Node p1 = null;
        Node p2 = head;
        Node p3 = head;

        int iter = 0;
        while(p2 != null && iter < k){
            Node temp = p2;
            p2 = p2.next;
            temp.next = p1;
            p1 = temp;
            iter--;
        }

        p3.next = reverseListByK(p2, k);

        return p1;
    }

    public Node reverseKNodes(Node node, int k){

        if(node == null || node.next == null) return node;

        Node p1 = node;
        Node p2 = null;
        Node p3 = node;

        while(p1 != null && k > 0){
            Node temp = p1;
            p1 = p1.next;
            temp.next = p2;
            p2 = temp;
            k--;
        }

        p3.next = p1;

        return p2;
    }

    // Question find the maximum Length of palindrome in a linked list

    public int countSimilar(Node h1, Node h2){

        int count = 0;

        while(h1 != null && h2 != null){
            if(h1.value != h2.value){
                return count;
            }
            count++;
            h1 = h1.next;
            h2 = h2.next;
        }

        return count;
    }
    public int maxPalindrome(Node node){

        if(node == null) return 0;
        if(node.next == null) return 1;

        Node curr = node;
        Node prev = null;

        int maxRes = 0;

        while(curr != null){

            maxRes = Math.max(maxRes, 2*countSimilar(curr, prev));
            maxRes = Math.max(maxRes, 2*countSimilar(curr.next, prev)+1);

            Node temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;

        }
        return maxRes;
    }


    public Node partition(Node A, int B) {
        Node dummy = new Node(-1);
        dummy.next = A;

        Node p1 = dummy;
        Node p2 = dummy;

        while (p1.next != null) {

            if (p1.next.value >= B) {
                break;
            }

            p1 = p1.next;
        }

        p2 = p1.next;

        while(p2 != null && p2.next != null){
            if(p2.next.value < B){
                Node temp = p2.next;
                p2.next = p2.next.next;

                temp.next = p1.next;
                p1.next = temp;
                p1 = temp;
            }
            p2 = p2.next;
        }

        return dummy.next;
    }


//    public Node[] splitListToParts(Node head, int k) {
//
//        Node temp = head;
//        int size = 0;
//
//        while(temp != null){
//            size++;
//            temp = temp.next;
//        }
//
//        Node res[] = new Node[k];
//
//        int nodeParPart = size/k;
//        int iter = 0;
//        temp = head;
//
//        if (k >= size){
//            while(temp != null){
//                Node curr = temp;
//                temp = temp.next;
//                curr.next = null;
//                res[iter++] = curr;
//            }
//        } else{
//
//            int diff = size - nodeParPart*k;
//
//            while(k>0){
//                int noOfNode;
//
//                if(diff > 0){
//                    noOfNode = nodeParPart+1;
//                    diff--;
//                } else{
//                    noOfNode = nodeParPart;
//                }
//
//                Node curr = temp;
//
//                while(noOfNode - 1 > 0){
//                    curr = curr.next;
//                    noOfNode--;
//                }
//
//                Node temp2 = curr.next;
//                curr.next = null;
//
//                res[iter] = temp;
//                temp = temp2;
//
//                iter++;
//                k--;
//            }
//
//
//        }
//        return res;
//    }


    public Node removeDuplicates(Node node){

        Node dummy = new Node(-1);
        dummy.next = node;
        Node p1 = dummy;
        Node p2 = dummy.next;

        HashSet<Integer> set = new HashSet<>();

        while(p2 != null && p2.next !=null){

            int val = p2.value;

            if(val != p2.next.value){
                p1 = p2;
                p2 = p2.next;
            } else{
                while(p2!=null &&p2.value == val){
                    p2 = p2.next;
                }
                p1.next = p2;
            }

        }

       return dummy.next;
    }

    public Node rotate(Node node, int k){

        Node temp = node;
        int nodeCount = 1;

        while(temp.next != null){
            temp = temp.next;
            nodeCount++;
        }

        System.out.println(nodeCount);

        temp.next = node;
        temp = node;

        int shift = nodeCount - k%nodeCount;


        while (shift - 1  > 0){
            temp = temp.next;
            shift--;
        }

        head = temp.next;
        temp.next = null;


        printList();
        return node;
    }

    public void check(){

        Node temp = head;
        int count = 2;

        while(count > 0){
            System.out.println(count + "," + temp.value);
            temp = temp.next;
            count--;
        }

    }
}
