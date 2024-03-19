package Trees;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    class Node {

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void getRootLeft() {
        System.out.println(root.left.value);
    }

    public void getRootRight() {
        System.out.println(root.right.value);
    }

    public boolean insert(int value) {

        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;

        while (true) {

            if (newNode.value == temp.value) return false;

            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;

            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {

        if (root == null) return false;

        Node temp = root;

        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }


    private boolean rContains(Node currentNode, int value) {

        if (currentNode == null) return false;
        if (currentNode.value == value) return true;

        if (currentNode.value < value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private Node rInsert(Node currentNode, int value) {

        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }

    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }


//    public boolean removeNode(int value){
//
//        if(root == null) return false;
//
//        Node currentNode = root;
//        Node parentNode = null;
//
//        while(currentNode != null){
//
//            if (currentNode.value < value){
//                parentNode = currentNode;
//                currentNode = currentNode.left;
//            } else if (currentNode.value > value) {
//                parentNode = currentNode;
//                currentNode = currentNode.right;
//            }else if (parentNode !=null ){
//                if(currentNode.left == null && currentNode.right ==null ){
//                    currentNode = null;
//                } else if (currentNode.right == null) {
//                    parentNode = currentNode.left;
//                } else if (currentNode.left == null) {
//                    parentNode = currentNode.right;
//                }
//                return true;
//            }
//        }
//
//
//    }

    private Node deleteNode(Node currentNode, int value) {

        if (currentNode == null) return null;

        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            // leaf node
            if (currentNode.left == null && currentNode.right == null) {
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

    public void deleteNode(int value) {
        deleteNode(root, value);
    }


    // Tree Traversal using Breadth First search
    public ArrayList<Integer> BFS() {

        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();

        ArrayList<Integer> results = new ArrayList<>();

        queue.add(currentNode);

        while (!queue.isEmpty()) {

            currentNode = queue.remove();
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);

            results.add(currentNode.value);
        }
        return results;
    }

    // Tree traversal Depth First Search

    //PreOrder
    private ArrayList<Integer> DFSPreOrder(Node node, ArrayList<Integer> results) {
        if (node != null) {
            results.add(node.value);
            DFSPreOrder(node.left, results);
            DFSPreOrder(node.right, results);
        }
        return results;
    }

    public ArrayList<Integer> DFSPreOrder() {
        return DFSPreOrder(root, new ArrayList<Integer>());
    }


    //PostOrder
    private ArrayList<Integer> DFSPostOrder(Node node, ArrayList<Integer> results) {
        if (node != null) {
            DFSPostOrder(node.left, results);
            DFSPostOrder(node.right, results);
            results.add(node.value);
        }
        return results;
    }

    public ArrayList<Integer> DFSPostOrder() {
        return DFSPostOrder(root, new ArrayList<Integer>());
    }

    public boolean getPath(Node node, ArrayList<Integer> arr, int val){

        if(node == null){
            return false;
        }

        arr.add(node.value);

        if(node.value == val) return true;

        if(getPath(node.left, arr, val) || getPath(node.right, arr, val)){
            return true;
        }

        arr.remove(arr.size()-1);
        return false;
    }


    public ArrayList<Integer> findPathOfNode(int val){
        ArrayList<Integer> arr = new ArrayList<>();
        getPath(root, arr, val);
        return arr;
    }


    public List<Integer> leftSubTreeTravesal(Node node, List<Integer> arr){

        if(node != null){
            arr.add(node.value);
            leftSubTreeTravesal(node.left, arr);
            leftSubTreeTravesal(node.right, arr);

            if (node.right == null && node.left != null) {
                arr.add(null);
            }
        }
        return arr;
    }

    // Questions Based on Breath First Search

    // Question 1: Right side view of a BST.

    //Need to find the last element form all the level of the Tree
    public List<Integer> rightSideView(Node root) {

        Queue<Node> queue = new LinkedList<>();
        List<Integer> results = new ArrayList<>();
        Node temp = root;
        queue.add(temp);

        if(root == null){
            return results;
        }

        while(!queue.isEmpty()){
            int n = queue.size();

            // Traversing on each level of the tree to find the last node
            // of the tree at each level
            while(n>0){
                temp  = queue.remove();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                n--;
            }
            results.add(temp.value);
        }
        return results;
    }

    //maximum height of binary tree

    public int heightBT(Node node){
        if(node == null) return 0;
        return Math.max(heightBT(node.left), heightBT(node.right)) + 1;
    }


    // Size of Binary Tree (Number of nodes)
    public int sizeBT(Node node){
        if(node == null) return 0;
        return sizeBT(node.left) + sizeBT(node.right) + 1;
    }

    // Max value in the binary tree

    public int maxNodeValue(Node node){
        if (node == null) return Integer.MIN_VALUE;
        return Math.max(node.value, Math.max(maxNodeValue(node.left), maxNodeValue(node.right)));
    }


}
