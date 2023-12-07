package HashTables;

import java.util.*;


public class main {
    public static void main(String[] args) {

        HashTable myHashTable = new HashTable();

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = myHashTable.findPairs(arr1, arr2, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }
    }

}
