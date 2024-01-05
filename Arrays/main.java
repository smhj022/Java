package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {

        // Time complexity of different operation of an Array

        // Dynamic array
        ArrayList<String> arr = new ArrayList<String>() {
            {
                add("a");
                add("b");
                add("c");
            }
        };

        // lookup -> retrieving elem from a particular index
        System.out.println(arr.get(2)); // O(1)

        // push -> Adding element at last
        arr.add("d");  // O(1)

        // pop -> removing last element
        arr.remove(arr.size() -1); //O(1)

        // shift -> adding element at first
        arr.add(0, "x"); //O(N)

        // un shift -> removing element form first
        arr.remove(0); //O(N)


        // Static Array
        String staticArr[] = new String[4];


        // My array
        ArrayDS myArr = new ArrayDS();
        myArr.push(1);
        myArr.push("suyash");
        myArr.push("apurva");

        myArr.delete(1);
        System.out.println(myArr.getLength());
        System.out.println(myArr.getData());

    }



}
