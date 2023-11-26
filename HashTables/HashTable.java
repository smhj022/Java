package HashTables;

import java.util.*;

public class HashTable {

    private int size = 7;
    private Node[] dataMap;

    public HashTable(){
        dataMap = new Node[size];
    }

    public class Node{
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int hash(String key){
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int asciiValue : keyChars) {
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void printTable() {

        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("   {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    public void set(String key, int value){

         int index = hash(key);
         Node newNode = new Node(key, value);

         if (dataMap[index] == null){
             dataMap[index] = newNode;
         } else {
             Node temp = dataMap[index];
             while (temp.next != null){
                 temp = temp.next;
             }
             temp.next = newNode;
         }
    }

    public int get(String key){

        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null){
            if (Objects.equals(temp.key, key)) return temp.value;
            temp = temp.next;
        }
        return -1;
    }

    public ArrayList<String> keys() {
        ArrayList<String> allKeys = new ArrayList<>();

        for (Node node : dataMap) {
            Node temp = node;
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    public static boolean itemInCommon(int[] array1, int[] array2){

        HashMap<Integer, Boolean> myHashMap = new HashMap<>();

        for(int i : array1){
            myHashMap.put(i,true);
        }

        for(int j : array2){
            if (myHashMap.get(j) != null) return true;
        }

        return false;
    }


    public List<Integer> findDuplicates(int[] nums){

        HashMap<Integer, Integer> numCount = new HashMap<>();

        List<Integer> dublicates = new ArrayList<>();

        for(int num: nums){
            if(numCount.get(num) != null){
                int count = numCount.get(num);
                if (count == 1){
                    dublicates.add(num);
                }
                numCount.put(num, ++count);
                System.out.println(numCount);
            } else{
                numCount.put(num, 1);
            }
        }
        return dublicates;
    }
}