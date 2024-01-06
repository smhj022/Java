package HashTables;

import java.util.*;


public class main {
    public static void main(String[] args) {
        HashTable myHashTable = new HashTable(7);

        myHashTable.set("grapes", 10000);
        myHashTable.printTable();
    }
}
