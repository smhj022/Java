package Trees;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {


        BinarySearchTree myBST = new BinarySearchTree();


        myBST.insert(1);
        myBST.insert(2);

        System.out.println(myBST.heightBT(myBST.root));


    }
}
