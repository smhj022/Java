// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LinkedList LL = new LinkedList(0);
        LL.appendElem(1);
        LL.appendElem(2);
        LL.appendElem(3);
        LL.appendElem(4);
        LL.appendElem(5);
        LL.appendElem(6);

        LL.printList();
        LL.getHead();
        LL.getTail();
        LL.getLength();

       int index = -1;

       System.out.println(LL.getNodeByIndex(index));


    }
}
