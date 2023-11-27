package HashTables;

import java.util.*;

public class main {
    public static void main(String[] args) {

        HashTable myHashTable = new HashTable();
//
//        myHashTable.set("nails", 100);
//        myHashTable.set("tile", 50);
//        myHashTable.set("lumber", 80);
//
//        myHashTable.set("bolts", 200);
//        myHashTable.set("screws", 140);
//
//        myHashTable.printTable();
//
//        int[] nums = {2, 2,2};
//
//        System.out.println(myHashTable.findDuplicates(nums));

//        System.out.println(myHashTable.firstNonRepeatingChar("aabbcc"));

        System.out.println(myHashTable.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

    }

}
