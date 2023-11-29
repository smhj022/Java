package HashTables;

import java.util.*;


public class main {
    public static void main(String[] args) {

        HashTable myHashTable = new HashTable();


        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 1;
        System.out.println(Arrays.toString(myHashTable.subarraySum(nums1, target1)));

    }

}
