package LinkedList.src;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import LinkedList.src.LinkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList LL = new LinkedList(1);
        LL.appendElem(2);
        LL.appendElem(3);
        LL.appendElem(4);
        LL.appendElem(5);
        LL.appendElem(6);
        LL.appendElem(7);
        LL.appendElem(8);
        LL.appendElem(9);
        LL.appendElem(10);
        LL.appendElem(11);
        System.out.println(Arrays.toString(LL.splitListToParts(LL.head, 3)));
    }
}
