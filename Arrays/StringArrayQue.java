package Arrays;

import java.util.Arrays;

public class StringArrayQue {

    public static void main(String[] args) {
//        System.out.println(reverseString("suyash"));
        int[] arr1 = {1,2};
        rotate(arr1, 4);
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
        // check if elem is available in arr1
        if(p1 < n1){
            while(p1 < n1){
                result[r1++] = arr1[p1++];
            }
        }
        // check if elem is available in arr2
        if(p2 < n2){
            while(p2 < n2){
                result[r1++] = arr2[p2++];
            }
        }

        return result;
    }

    public static void rotate(int[] nums, int k) {

        k = k % nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int[] arr, int start, int end){

        while(end >= start){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            end--;
            start++;
        }
    }


    // Kadane's Algorithm -> The idea of Kadane’s algorithm is to maintain a variable
    // max_ending_here that stores the maximum sum contiguous subArray ending at current
    // index and a variable max_so_far stores the maximum sum of contiguous
    // subArray found so far, Everytime there is a positive-sum value in max_ending_here
    // compare it with max_so_far and update max_so_far if it is greater than max_so_far.
    public static int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int currSum = nums[0];

        if (currSum < 0){
            currSum = 0;
        }

        for(int i = 1; i < nums.length; i++){

            currSum = currSum + nums[i];

            if (currSum > maxSum) {
                maxSum = currSum;
            }
            if (currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }
}


