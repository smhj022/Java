package Trees;


import java.util.*;

public class BinarySearchTree {
    Node root;

    public static class Node {

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

    // function to insert the node in a binary search tree.
    // this function ensure that there will be no duplicates
    public boolean insertBT(int value) {

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


    // Iterative function to check if the given value is available in the binary search Tree.
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

    // Iterative function to check if the given value is available in the binary search Tree.
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

    // Iterative Method to insert the value in a binary search tree.
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


    // function to find the minimum value of the given tree.
    public int leftMinValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    // function to delete a node from a binary search Tree.
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
                // left most minimum value on right subTree.
                int subTreeMin = leftMinValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }
        return currentNode;


    }
    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    //****************************************************************************************************//
    //**************************************TREE TRAVERSAL************************************************//
    //****************************************************************************************************//

    // 1) Breadth First Search (Level Order Traversal)
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

    // 2) Depth First Search

    // i) PreOrder -> NLR
    // ii) PostOrder -> LRN
    // iii) InOrder -> LNR
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

    private ArrayList<Integer> DFSInOrder(Node node, ArrayList<Integer> results) {
        if (node != null) {
            DFSInOrder(node.left, results);
            DFSInOrder(node.right, results);
            results.add(node.value);
        }
        return results;
    }

    public ArrayList<Integer> DFSInOrder() {
        return DFSInOrder(root, new ArrayList<Integer>());
    }

    //*******************************************************************************************************//
    //********************************** Basics of Binary Tree **********************************************//
    //*******************************************************************************************************//


    //maximum height of binary tree -> height at root node is ZERO
    //maximum height of binary tree -> height at root node is ZERO
    // Size of Binary Tree -> Total number of nodes in a Binary Tree.
    public int sizeBT(Node node){
        if(node == null) return 0;
        return sizeBT(node.left) + sizeBT(node.right) + 1;
    }

    // Max value in the binary tree
    public int maxNodeValue(Node node){
        if (node == null) return Integer.MIN_VALUE;
        return Math.max(node.value, Math.max(maxNodeValue(node.left), maxNodeValue(node.right)));
    }

    //******************************************************************************************************//
    //****************************Questions Based on Breath First Search***********************************//
    //*****************************************************************************************************//

    // Right side view of a BST.

    // Recursive Approach: Need to find the last element form all the level of the Tree using Queue
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

    // Iterative Approach : find the left view of Binary search Tree. using HashMap
    public List<Integer> leftSideView(Node node){

        List<Integer> result = new ArrayList<>();
        if (node == null) return result;
        leftViewUtil(result, root, 0);
        return result;
    }

    public void leftViewUtil(List<Integer> res, Node node, int level){
        if(node == null) return;
        if(res.size() == level){
            res.add(level, node.value);
        }
        leftViewUtil(res, node.left, level+1);
        leftViewUtil(res, node.right, level+1);
    }

    // TopView : TopView of a binary Tree:
    // Using the concept of horizontal distance from the center.


    // class that create the pair of node and its horizontal distance from the center.
    static class PairHD{

        // horizontal distance of Node from the center
        int hd;
        Node node;

        public PairHD(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    // Top View of Tree Map
    public List<Integer> topView(){
        Queue<PairHD> queue = new LinkedList<>();

        // Using tree Map, because it is already sorted
        Map<Integer, Integer> map = new TreeMap<>();

        queue.add(new PairHD(0, root));

        while (!queue.isEmpty()) {

            // Remove Pair from the queue
            PairHD currentPair = queue.poll();

            // checking if the pair is already in the map or not
            if(!map.containsKey(currentPair.hd)){
                map.put(currentPair.hd, currentPair.node.value);
            }

            if (currentPair.node.left != null) {
                queue.add(new PairHD(currentPair.hd - 1, currentPair.node.left));
            }

            if (currentPair.node.right != null) {
                queue.add(new PairHD(currentPair.hd + 1, currentPair.node.right));
            }
        }

        List<Integer> topView = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            topView.add(entry.getValue());
        }

        return topView;
    }


    // Bottom view of tree map
    public List<Integer> bottomView() {
        Queue<PairHD> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        queue.add(new PairHD(0, root));

        while (!queue.isEmpty()) {

            // Remove pair from the queue
            PairHD currentPair = queue.poll();

            // Update the value of key i.e. hd
            map.put(currentPair.hd, currentPair.node.value);

            if (currentPair.node.left != null) {
                queue.add(new PairHD(currentPair.hd - 1, currentPair.node.left));
            }

            if (currentPair.node.right != null) {
                queue.add(new PairHD(currentPair.hd + 1, currentPair.node.right));
            }
        }

        List<Integer> topView = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            topView.add(entry.getValue());
        }

        return topView;
    }

    public int findNodeLevelFromRoot(Node node, int val){

        if(node == null) return -1;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;

        while (!queue.isEmpty()){

            int size = queue.size();

            while (size > 0){
                Node currNode = queue.poll();

                if(currNode.value == val){
                    return level;
                }

                if(currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if(currNode.right != null) {
                    queue.offer(currNode.right);
                }
                size--;
            }
            level++;

        }
        //  not found;
        return -1;
    }

    // Recursive approach to find the Leaf node of a Binary Tree.

    public List<Integer> leafNode(Node node, List<Integer> leafNodeList){

        if(node == null) return leafNodeList;

        if(node.left == null && node.right == null)
            leafNodeList.add(node.value);

        leafNode(node.left, leafNodeList);
        leafNode(node.right, leafNodeList);

        return leafNodeList;
    }

    public List<Integer> leafNode(Node node){
        List<Integer> leafNodeList = new ArrayList<>();
        return leafNode(node, leafNodeList);
    }

    // *************************************************************************************************//

    static class ParentChildPair {

        Node child;
        Node parent;

        ParentChildPair(Node child, Node parent){
            this.child = child;
            this.parent = parent;
        }
    }

    // flatten a Binary tree ( In Order traversal) without extra space
    Node prev = null;
    Node head = null;
    public void convertToDLL(Node root) {

        if (root == null) return;

        convertToDLL(root.left);

        if (prev == null) head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertToDLL(root.right);
    }

    public void printDLL(){
        Node temp = head;
        while (temp.right != null){
            System.out.println(temp.value);
            temp = temp.right;
        }
    }

    // Diameter of a Binary tree : The diameter of a binary tree is the length of the longest
    // path between any two nodes in a tree. This path may or may not pass through the root.

    int diameter;
    public int diameterOfBinaryTree(Node root){
        diameter = 0;
        height(root);
        return diameter;
    }
    // diameter is updating in each recursion call.
    public int height(Node node){

        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        diameter = Math.max(diameter, leftHeight+rightHeight);

        return 1 + Math.max(leftHeight , rightHeight);
    }


    // Cousins in the binary Tree
    public boolean isCousins(Node root, int x, int y) {

        Queue<ParentChildPair> queue = new LinkedList<>();

        queue.offer(new ParentChildPair(root, null));

        int level = 0;

        while(!queue.isEmpty()){

            int size = queue.size();
            ParentChildPair x_pair = null;
            ParentChildPair y_pair = null;

            for(int i = 0; i < size; i++){

                ParentChildPair curr = queue.poll();

                if(curr.child.value == x) x_pair=curr;
                else if(curr.child.value == y) y_pair=curr;

                if(curr.child.left != null) queue.offer(new ParentChildPair(curr.child.left, curr.child));
                if(curr.child.right != null) queue.offer(new ParentChildPair(curr.child.right, curr.child));
            }

            if( x_pair != null && y_pair != null){
                if(x_pair.parent != y_pair.parent){
                    return true;
                }
                else return false;
            } else if ( x_pair != null || y_pair != null){
                return false;
            }
        }
        return false;
    }

    // function to check if the tree is subtree of another tree
    public boolean isSubtree(Node root, Node subRoot) {

        if(root == null) return false;

        return isIdentical(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // function if two BT are identical or not
    public boolean isIdentical(Node node1, Node node2){

        if(node1 == null && node2 == null ) return true;

        if(node1 == null || node2 == null) return false;

        if(node1.value != node2.value) return false;

        return isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
    }



    // Root to leaf sum

    ArrayList<Integer> result = new ArrayList<>();

    public List<Integer> rootToLeafSum(Node root){
        if (root == null) return null;
        rootToLeafSumUtil(root, 0);
        return result;
    };

    public void rootToLeafSumUtil(Node node, int val){

        if(node == null) return;

        if(node.left == null && node.right == null) {
            result.add(val+node.value);
            return;
        }
        val += node.value;
        rootToLeafSumUtil(node.left, val);
        rootToLeafSumUtil(node.right, val);
    }

    // find all the paths of a Binary Tree
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPaths(Node root){

        List<Integer> currPath = new ArrayList<>();

        paths(root, currPath);
        return res;
    }

    public void paths(Node node, List<Integer> currentPath){

        if(node == null) return;

        currentPath.add(node.value);

        if(node.left == null && node.right == null){
            res.add(new ArrayList<>(currentPath));
        }

        paths(node.left, currentPath);
        paths(node.right, currentPath);
        currentPath.remove(currentPath.size()-1);
    }

    // find if the value present in the binary tree or not;

    public boolean findVal(Node node, int val){

        if(node == null) return false;

        if(node.value == val) return true;

        return findVal(node.left, val) || findVal(node.right, val);
    }

    // find the path of given value from the root;
    List<Integer> pathRes = new ArrayList<>();

    public List<Integer> findPath(Node root, int val){
        findPathUtil(root, val);
        return pathRes;
    }
    public boolean findPathUtil(Node node, int val){

        if(node == null) return false;

        pathRes.add(node.value);

        if(node.value == val) {
            return true;
        }
        if( findPathUtil(node.left, val) || findPathUtil(node.right, val)){
            return true;
        }

        pathRes.remove(pathRes.size() -1);
        return false;
    }

    // Find all the nodes which are k distance from the root

    public List<Integer> nodeAtDisKFromRoot(Node root, int k){
        List<Integer> res = new ArrayList<>();
        nodeAtDisKFromRootUtil(root, k, res);
        return res;
    }

    public void nodeAtDisKFromRootUtil(Node node, int k, List<Integer> res){

        if( node == null) return;

        if(k == 0) {
            res.add(node.value);
        }

        nodeAtDisKFromRootUtil(node.left, k-1, res);
        nodeAtDisKFromRootUtil(node.right, k-1, res);
    }


    int dis = 0;

    public Integer disFromRoot(Node node, int val){
        disFromRootUtil(node, val);
        return dis;
    }

    public boolean disFromRootUtil(Node node, int val){

        if(node == null) return false;
        dis += 1;

        if(node.value == val) {
            return true;
        }
        if(disFromRootUtil(node.left, val) || disFromRootUtil(node.right, val)){
            return true;
        }

        dis -= 1;
        return false;
    }


    public List<Integer> kDisFromNode(Node node, int k){

        List<Integer> res = new ArrayList<>(nodeAtDisKFromRoot(node, k));

        // find if given node is which side fo the root
        boolean left = findVal(root.left, node.value);
        boolean right = findVal(root.right, node.value);

        // distance of node from root
        List<Integer> path = findPath(root, node.value);
        int disFromRoot = path.size() - 1;

        int kFromRoot = k - disFromRoot;

        if(kFromRoot == 0){
            res.add(root.value);
        }

        else if(left){
            if(kFromRoot > 0) res.addAll(nodeAtDisKFromRoot(root.right, kFromRoot-1));
            else res.addAll(nodeAtDisKFromRoot(root.left, Math.abs(kFromRoot)-1));
        }

        else if(right){
            if(kFromRoot > 0) res.addAll(nodeAtDisKFromRoot(root.left, kFromRoot-1));
            else res.addAll(nodeAtDisKFromRoot(root.right, Math.abs(kFromRoot)-1));
        }

        return res;
    }


    //find if the Binary Tree can be divided not two half having equal sum

    // find sum of all the node of a binary tree

    public int nodeSum(Node node){

        if(node == null) return 0;

        return node.value + nodeSum(node.left) + nodeSum(node.right);
    }

    // Function to check if a Binary Tree can be divided into Two half,
    // meaning the sum of all the  nodes is of both the half should be equal
    public boolean intoHalf(Node root){

        int sum =  nodeSum(root);

        // if the sum of all the nodes is odd, the tree cant be divided into half.
        // returing half,
        if(sum%2 != 0) return false;

        subTreeTargetSum(root, sum/2);
        return found;
    }


    // Function to find the subTree having sum of all the nodes of subtree is equal to
    // given target sum.
    int currSum=0;
    boolean found = false;
    public int subTreeTargetSum(Node node, int targetSum){

        if (node == null) return 0;

        int leftSum = subTreeTargetSum(node.left, targetSum);
        int rightSum = subTreeTargetSum(node.right, targetSum);

        currSum = node.value + leftSum + rightSum;

        if(targetSum == currSum){
            found = true;
        }
        return currSum;
    }

    // function to find the distance between the node of a Binary Search Tree.
    public int disBetweenNodeBST(Node node, int v1, int v2){

        while(node!=null){

            if(node.value > v1 && node.value > v2){
                node = node.left;
            }
            else if(node.value < v1 && node.value < v2){
                node = node.right;
            }
            else {
                break;
            }
        }
        return findNodeLevelFromRoot(node, v1) + findNodeLevelFromRoot(node, v2);
    }




    Node rootNode = null;
    public Node sortedArrayToBST(final int[] A) {
        sortedToBBST(A, 0, A.length-1);
        return rootNode;
    }

    public Node sortedToBBST(int[] A, int start, int end){

        if(start > end) return null;

        int mid = (start + end) / 2;

        Node currNode = new Node(A[mid]);

        if (rootNode == null){
            rootNode = currNode;
        }

        currNode.left = sortedToBBST(A, start, mid-1);
        currNode.right = sortedToBBST(A, mid+1, end);

        return currNode;
    }


    // Morris InOrder Traversal (without recursion)
    // space complexity -> O(1)

    public List<Integer> morrisInorder(Node root){

        List<Integer> result = new ArrayList<>();

        Node curr = root;

        while (curr != null){

            if(curr.left == null){
                result.add(curr.value);
                curr = curr.right;
            } else {

                Node leftChild = curr.left;

                while (leftChild.right != null){
                    leftChild = leftChild.right;
                }

                leftChild.right = curr;
                Node temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }

        return result;
    }


    // Boundary Traversal of binary Tree

    public int[] boundaryTraversal(Node root){

        List<Integer> leftSide = new ArrayList<>();
        List<Integer> rightSide = new ArrayList<>();
        List<Integer> bottomLevel = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0 ; i < size; i++){

                Node currNode = queue.poll();

                if(i == 0){
                    leftSide.add(currNode.value);
                }

                if (i == (size - 1)){
                    rightSide.add(currNode.value);
                }

                if(currNode.left != null) queue.offer(currNode.left);
                if(currNode.right != null) queue.offer(currNode.right);
            }

        }

        System.out.println(leftSide);
        System.out.println(rightSide);
        bottomLevel = lastLevelBT(root, bottomLevel);
        System.out.println(bottomLevel);

        ArrayList<Integer> result = new ArrayList<>();

        // Add all elements from A
        for (int num : leftSide) {
            if (!result.contains(num)) {
                result.add(num);
            }
        }
        // Add all elements from C
        for (int num : bottomLevel) {
            if (!result.contains(num)) {
                result.add(num);
            }
        }

        // Add all elements from B
        for (int num : rightSide) {
            if (!result.contains(num)) {
                result.add(num);
            }
        }




        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }

        return output;



    }

    public List<Integer> lastLevelBT(Node node, List<Integer> bottomLevel) {
        if (node == null) return bottomLevel;

        lastLevelBT(node.left, bottomLevel);

        if (node.left == null && node.right == null) {
            bottomLevel.add(node.value);
        }
        lastLevelBT(node.right, bottomLevel);

        return bottomLevel;
    }

    int maxSum;
    public int maxPathSum(Node root){
        maxSum = Integer.MIN_VALUE;
        sumAtNode(root);
        return maxSum;
    }

    public int sumAtNode(Node node){

        if(node == null) return 0;

        int leftSum = sumAtNode(node.left);
        int rightSum = sumAtNode(node.right);

        int currSum = node.value + leftSum + rightSum;

        if (currSum> maxSum){
            maxSum = currSum;
        }

        return node.value + Math.max(leftSum, rightSum);

    }



}
