package Trees;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {


        BinarySearchTree myBST1 = new BinarySearchTree();
        BinarySearchTree myBST2 = new BinarySearchTree();

        myBST1.insert(1);
        myBST1.insert(1);
        myBST2.insert(1);
//        myBST.insert(1);
//        myBST.insert(5);

        System.out.println(myBST1.isSubtree(myBST1.root, myBST2.root));



    }
}
