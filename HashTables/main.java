package HashTables;

import java.util.*;


public class main {
    public static void main(String[] args) {
//        HashTable myHashTable = new HashTable(7);
//
//        int[] arr = {2,6,2,7,6,5,4};
//        System.out.println(myHashTable.firstRecurringInteger(arr));


        String[] str = {"eat","tea","tan","ate","nat","bat"};

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String s : str){

            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedS = new String(arr);

            if(map.get(sortedS) != null ){
                ArrayList<String> sAdded= map.get(sortedS);
                sAdded.add(s);
                map.put(sortedS, sAdded);
            }
            else {
                map.put(sortedS, new ArrayList<>() {{
                    add(s);
                }});
            }
        }

        List<List<String>> result = new ArrayList<>();

        map.forEach((k,v) -> result.add(v));

        System.out.println(result);


    }
}
