package HashTables;

import java.util.*;


public class main {
    public static void main(String[] args) {
        HashTable myHashTable = new HashTable(7);

        int[] arr = {2,6,2,7,6,5,4};
        System.out.println(myHashTable.firstRecurringInteger(arr));


    }
}
