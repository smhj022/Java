package Trees;

public class main {
    public static void main(String[] args) {


        BinarySearchTree myBST = new BinarySearchTree();

        myBST.rInsert(2);
        myBST.rInsert(1);
        myBST.rInsert(3);

        System.out.println(myBST.root.value);
        System.out.println(myBST.root.left.value);
        System.out.println(myBST.root.right.value);

        myBST.deleteNode(2);

        System.out.println(myBST.root.value);
        System.out.println(myBST.root.left.value);
        System.out.println(myBST.root.right);




    }
}
