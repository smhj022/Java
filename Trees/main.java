package Trees;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {


        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(10);
        myBST.insert(7);
        myBST.insert(15);
        myBST.insert(6);
        myBST.insert(8);
        myBST.insert(3);
        myBST.insert(11);
        myBST.insert(16);
        myBST.insert(12);

        System.out.println(myBST.allPaths(myBST.root));
        System.out.println(myBST.rootToLeafSum(myBST.root));

        System.out.println(myBST.findVal(myBST.root, 7));

        System.out.println(myBST.findPath(myBST.root, 12));

    }
}
