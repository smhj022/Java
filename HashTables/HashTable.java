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

    public Character firstNonRepeatingChar(String str){

        char[] charArray = str.toCharArray();

        HashMap<Character, Integer> charMap = new HashMap<>();

        for(char ch1 : charArray){
            charMap.put(ch1, charMap.getOrDefault(ch1, 0) + 1);
        }

        for (char ch2: charArray){
            if(charMap.get(ch2) == 1) return ch2;
        }

        return null;
    }

    public static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


    // Method to group Anagrams of an Arrays
    public List<List<String>> groupAnagrams(String[] strings){

        Map<String, List<String>> sortStringHM = new HashMap<>();

        for(String str: strings) {
            List<String> strList = new ArrayList<>();
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            if (sortStringHM.get(sortedString) == null) {
                strList.add(str);
            } else {
                strList = sortStringHM.get(sortString(str));
                strList.add(str);
            }
            sortStringHM.put(sortedString, strList);
        }

        List<List<String>> list = new ArrayList<>();
        for (List<String> values : sortStringHM.values()){
            list.add(values);
        }
        return list;
    }


    // Method to find the indexes of values of an array have sum equal to target
    public int[] twoSum(int[] myList, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < myList.length; i++) {
            int complement = target - myList[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(myList[i], i);
        }
        return new int[]{}; // Return default if no pair found
    }

    public int[] subarraySum(int[] nums, int target) {
        // Create a HashMap to store cumulative sum and index
        Map<Integer, Integer> sumIndex = new HashMap<>();
        // Initialize the HashMap with 0 sum and index -1
        sumIndex.put(0, -1);
        // Initialize the current sum to 0
        int currentSum = 0;

        // Iterate through the input array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the cumulative sum
            currentSum += nums[i];
            // Check if the required subarray sum exists
            if (sumIndex.containsKey(currentSum - target)) {
                // Return the start and end indices of the subarray
                return new int[]{sumIndex.get(currentSum - target) + 1, i};
            }
            // Store the current sum and its index in the HashMap
            sumIndex.put(currentSum, i);
        }

        // Return an empty array if no subarray is found
        return new int[]{};
    }

    // Added method to find the pairs form the integer list having sum equal to target
    public List<int[]> findPairs(int[] arr1, int[] arr2, int target){

        HashSet<Integer> arr1HS = new HashSet<>();

        List<int[]> result = new ArrayList<>();


        for (int num1 : arr1) {
            arr1HS.add(num1);
        }

        for (int num2 : arr2) {
            if(arr1HS.contains(target-num2)){
                result.add(new int[]{target-num2, num2});
            }
        }

        return result;
    }

}
