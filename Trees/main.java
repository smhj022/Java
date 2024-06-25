package Trees;

import java.util.*;


public class main {
    public static void main(String[] args) {

        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insertBT(10);
        myBST.insertBT(7);
        myBST.insertBT(15);
        myBST.insertBT(6);
        myBST.insertBT(8);
        myBST.insertBT(3);
        myBST.insertBT(11);
        myBST.insertBT(13);
        myBST.insertBT(14);
        myBST.insertBT(16);
        myBST.insertBT(12);

        System.out.println(myBST.depth(myBST.root.left));
    }

}
