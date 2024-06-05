package Backtracking;

import java.nio.file.NotLinkException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BacktrackingQues {

    // Print all N digit numbers that can be formed by either 1 or 2 or both
    // in increasing order

    int numberSize;

    public void nDigitNumber(int N){
        numberSize = N;
        int[] res = new int[N];
        nDigitNumberUtil(N, res);
    }

    public void nDigitNumberUtil(int N, int[] res){

        if(N == 0) {
            System.out.println(Arrays.toString(res));
            return;
        }

        res[numberSize - N] = 1;
        nDigitNumberUtil(N-1, res);
        res[numberSize - N] = 2;
        nDigitNumberUtil(N-1, res);
    }


    // Given N array elements count number of subsets with sum=k

    int kSum;
    int count;
    public int countSumK(int[] arr, int k){
        kSum = k;
        return countSumKUtil(arr, 0, 0);
    }

    public int countSumKUtil(int[] arr, int sum, int i){

        if(i == arr.length){
            if(sum == kSum) return 1;
            return 0;
        }
        return countSumKUtil(arr, sum + arr[i], i+1) + countSumKUtil(arr, sum, i+1);
    }


    // Permutation of String

    List<String> stringPermutation;

    public List<String> allPermutation(String str){

        stringPermutation = new ArrayList<>();

        if(str.isEmpty()) return stringPermutation;

        allPermutationUtil(str,"");

        return stringPermutation;
    }

    public void allPermutationUtil(String input,String output){

        if(input.isEmpty()){
            stringPermutation.add(output);
        }

        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < input.length(); i++){

            if(!set.contains(input.charAt(i))) {
                String newIP = input.substring(0, i) + input.substring(i + 1);
                String newOP = output + input.charAt(i);
                set.add(input.charAt(i));
                allPermutationUtil(newIP, newOP);
            }
        }
    }

    // Given an array nums of distinct integers, return all the
    // possible permutations. You can return the answer in any order.

    List<List<Integer>> allPermute;

    public List<List<Integer>> permute(int[] nums) {

        allPermute = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        premuteUtil(nums,curr);

        return allPermute;

    }

    public void premuteUtil(int[] nums, List<Integer> curr){

        if(curr.size() == nums.length){
            allPermute.add(new ArrayList<>(curr));
        }

        for(int i = 0; i < nums.length; i++){

            if(!curr.contains(nums[i])){
                curr.add(nums[i]);
                premuteUtil(nums, curr);
                curr.remove(curr.size() - 1);
            }
        }

    }
}


