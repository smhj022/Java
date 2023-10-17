// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LinkedList LL = new LinkedList(-9);
        LL.appendElem(3);
//        LL.appendElem(6);

        LinkedList LL2 = new LinkedList(5);
        LL2.appendElem(7);
//        LL2.appendElem();
//        LL.appendElem(4);
//        LL.appendElem(5);
//        LL.appendElem(6)

        LL.mergeLinkedList(LL, LL2);
    }
}
