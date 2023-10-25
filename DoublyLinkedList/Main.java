package DoublyLinkedList;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList DLL = new DoublyLinkedList(0);
        DLL.append(1);
        DLL.append(2);
        DLL.append(3);

        DLL.remove(4);
        DLL.printList();
    }
}
