package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class StringQue {

    public static void main(String[] args) {
        System.out.println(reverseString("suyash"));

        int[] arr1 = {1,3,5,7,11,13,15 };
        int[] arr2 = {2,4,6,8,9,10};
        System.out.println(Arrays.toString(mergeTwoSortedArray(arr1, arr2)));
    }


    public static String reverseString(String str){

        if(str == null){
            return "Invalid Input";
        }

        char[] charArray = str.toCharArray();

        int first = 0;
        int last = charArray.length -1;

        while(last > first){
            char temp = charArray[first];
            charArray[first] =charArray[last];
            charArray[last] = temp;
            last--;
            first++;
        }

        return String.valueOf(charArray);
    }


    public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2){

        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] result = new int[n1 + n2];

        int p1 = 0;
        int p2 = 0;
        int r1 = 0;

        while (p1 < n1 && p2 < n2){

            if (arr1[p1] < arr2[p2]){
                result[r1++] = arr1[p1++];
            } else {
                result[r1++] = arr2[p2++];
            }
        }

        System.out.println(p1 + " " + p2 + " " + r1);

        if(p1 < n1){

            while(p1 < n1){
                result[r1++] = arr1[p1++];
            }
        }

        if(p2 < n2){

            while(p2 < n2){
                result[r1++] = arr2[p2++];
            }
        }

        return result;
    }
}
