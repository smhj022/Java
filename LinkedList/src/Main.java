// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LinkedList LL = new LinkedList(1);
//
//        // Method to append elem in LL
        LL.appendElem(2);
        LL.appendElem(3);
        LL.printList();
        LL.getLength();
        LL.getHead();

        System.out.println("After remove");

        System.out.println("removed element " + LL.removeFirst().value);

        LL.getHead();
        LL.printList();
        LL.getLength();

    }
}
