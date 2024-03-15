package Trees;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {


        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(6);
        myBST.insert(9);
        myBST.insert(3);
        myBST.insert(10);
        myBST.insert(4);
        myBST.insert(5);
        myBST.insert(8);
        myBST.insert(7);

        System.out.println(myBST.root.left.value);

        System.out.println(myBST.leftSubTreeTravesal(myBST.root, new ArrayList<Integer>()));

    }
}
