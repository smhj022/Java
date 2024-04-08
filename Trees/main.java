package Trees;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {


        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(10);
        myBST.insert(7);
        myBST.insert(12);
        myBST.insert(6);
        myBST.insert(8);
        myBST.insert(11);
        myBST.insert(13);

        System.out.println(myBST.rootToLeafSum(myBST.root));



    }
}
