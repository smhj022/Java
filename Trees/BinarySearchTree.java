package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    class Node{

        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public void getRootLeft(){
        System.out.println(root.left.value);
    }

    public void getRootRight(){
        System.out.println(root.right.value);
    }

    public boolean insert(int value){

        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;

        while(true){

            if (newNode.value == temp.value) return false;

            if (newNode.value < temp.value){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;

            } else {
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value){

        if (root == null) return false;

        Node temp = root;

        while(temp != null){
            if (value < temp.value){
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }


    private boolean rContains(Node currentNode, int value){

        if(currentNode == null) return false;
        if(currentNode.value == value) return true;

        if (currentNode.value < value){
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public boolean rContains(int value){
        return rContains(root, value);
    }

    private Node rInsert(Node currentNode, int value){

        if(currentNode == null) return new Node(value);

        if (value < currentNode.value){
            currentNode.left =  rInsert(currentNode.left, value);
        } else if (value > currentNode.value){
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void rInsert(int value){
        if(root == null) root = new Node(value);
        rInsert(root, value);
    }

    public int minValue(Node currentNode){
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    private Node deleteNode(Node currentNode, int value){

        if( currentNode == null) return null;

        if (value < currentNode.value){
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else{
            // leaf node
            if(currentNode.left == null && currentNode.right == null){
                return null;
            // open from right
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            // open from left
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            // node on left and right
            } else {
                // minimum value on right subTree.
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }
        return currentNode;



    }

    public void deleteNode(int value){
        deleteNode(root, value);
    }



    // Tree Traversal using Breadth First search
    public ArrayList<Integer> BFS(){

        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();

        ArrayList<Integer> results= new ArrayList<>();

        queue.add(currentNode);

        while(!queue.isEmpty()){

            currentNode = queue.remove();
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);

            results.add(currentNode.value);
        }
        return results;
    }

    // Tree traversal Depth First Search

    //PreOrder
    private ArrayList<Integer> DFSPreOrder(Node node, ArrayList<Integer> results){
        if (node != null) {
            results.add(node.value);
            DFSPreOrder(node.left, results);
            DFSPreOrder(node.right, results);
        }
        return results;
    }

    public ArrayList<Integer> DFSPreOrder(){
        return DFSPreOrder(root, new ArrayList<Integer>());
    }

    private ArrayList<Integer> DFSPostOrder(Node node, ArrayList<Integer> results){
        if (node != null) {

            DFSPostOrder(node.left, results);
            DFSPostOrder(node.right, results);
            results.add(node.value);
        }
        return results;
    }

    public ArrayList<Integer> DFSPostOrder(){
        return DFSPostOrder(root, new ArrayList<Integer>());
    }
 }
