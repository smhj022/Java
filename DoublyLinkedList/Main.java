package DoublyLinkedList;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList DLL = new DoublyLinkedList(7);
        DLL.append(5);
        DLL.append(9);
        DLL.append(12);

        DLL.insert(2,3);
        DLL.printList();
    }
}
