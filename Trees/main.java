package Trees;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {


        BinarySearchTree myBST = new BinarySearchTree();


        myBST.insert(3);
        myBST.insert(2);
        myBST.insert(4);
        myBST.insert(1);
        myBST.insert(5);

        System.out.println(myBST.isCousins(myBST.root, 1, 5));


    }
}
