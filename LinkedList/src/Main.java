package LinkedList.src;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList<Number> LL = new LinkedList<Number>(1);
        LL.appendElem(2);
//        LL.appendElem(3);
//        LL.appendElem(4);
//        LL.appendElem(5);
//        LL.appendElem(6);
//        LL.appendElem(7);


        LL.rotate(LL.head,1);


    }
}
