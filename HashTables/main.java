package HashTables;

import java.util.*;


public class main {
    public static void main(String[] args) {

        HashTable myHashTable = new HashTable();
//        System.out.println(myHashTable.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println(Arrays.toString(myHashTable.twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(myHashTable.twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(myHashTable.twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(myHashTable.twoSum(new int[]{}, 0)));

    }


}
