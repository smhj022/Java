package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DynamicProgramming{
    
    // fibonacci using Top Down dynamic programming approach;
    public int fibonacciTD(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fibonacciTDHelper(n, dp);
    }

    public int fibonacciTDHelper(int n, int[] dp){

        if(n <= 1) return n;

        if(dp[n] == -1){
            dp[n] = fibonacciTDHelper(n-1, dp) + fibonacciTDHelper(n-2, dp);
        }

        return dp[n];
    }

    // fibonacci using Bottom up dynamic programming approach;

    public int fibonacciBU(int n){
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //You are given an array A of N integers and three integers B, C, and D.
    //You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.
    // Scalar Question.
    public int maxValueSum(ArrayList<Integer> A, int B, int C, int D){

        int[] preMax = new int[A.size()];

        preMax[0] = A.get(0) * B;
        int p = 0;

        for(int i = 1; i < A.size(); i++){
            preMax[i] = Math.max(preMax[i-1], A.get(i)*B);
        }

        int[] preMax2 = new int[A.size()];
        preMax2[0] = preMax[0] + A.get(0)*C;

        for(int j = 1; j < A.size(); j++){
            preMax2[j] = Math.max(preMax2[j-1], preMax[j] + A.get(j)*C);
        }

        int[] preMax3 = new int[A.size()];
        preMax3[0] = preMax2[0] + A.get(0)*D;

        for(int k = 1; k < A.size(); k++){
            preMax3[k] = Math.max(preMax3[k-1], preMax2[k] + A.get(k)*D);
        }

        return preMax3[preMax3.length-1];
    }


    // Total ways to reach from bottom right from top left in a matrix;

    public int TWR(int m, int n){

        Integer[][] dp = new Integer[m][n];

        return TWRHelper(m-1,n-1,dp);
    }

    public int TWRHelper(int i, int j, Integer[][] dp){

        if(i == 0 || j == 0){
            return 1;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        dp[i][j] = TWRHelper(i, j-1,dp)+TWRHelper(i-1,j, dp);

        return dp[i][j];
    }

    // total ways to reach the bottom right from top left of a matrix with obstacles
    public int TWRWithOps(Integer[][] mat){

        int i = mat.length-1;
        int j = mat[0].length-1;
        System.out.println(i);
        System.out.println(j);

        mat[0][0] = 1;

        return TWRWithOpsHelper(i,j,mat);
    }

    public int TWRWithOpsHelper(int i, int j, Integer[][] mat){

        if(i < 0 || j < 0) return 0;

        if(mat[i][j] != null && mat[i][j] == -1) return 0;

        if(mat[i][j] != null){
            return mat[i][j];
        }

        mat[i][j] = TWRWithOpsHelper(i, j-1, mat) + TWRWithOpsHelper(i-1, j, mat);

        return mat[i][j];
    }


    // 0/1 Knapsack Problem:

    public int knapsack(int[] value, int[] weight, int w){

        int n = value.length;

        int[][] dp = new int[n+1][w+1];

        for(int i = 0; i <= n ; i++){

            for(int j = 0; j <= w ; j++){

                if(i == 0 || j== 0){
                    dp[i][j] = 0;
                }

                else if(weight[i-1] <= j){
                    dp[i][j] = Math.max(value[i-1] + dp[i-1][j-weight[i-1]] , dp[i-1][j]);
                }

                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for(int[] a : dp){
            System.out.println(Arrays.toString(a));
        }

        return dp[n][w];
    }

    public int unboundedKnapsack(int[] value, int[] weight, int capacity){

        int[] dp =  new int[capacity+1];

        for(int i = 1; i <= capacity; i++){
            int currMax = 0;
            for(int j = 0; j < weight.length; j++){
                if(weight[j] <= i)
                    currMax = Math.max(currMax, value[j] + dp[i-weight[j]]);
            }
            dp[i] = currMax;
        }

        System.out.println(Arrays.toString(dp));

        return dp[capacity];
    }


    public int unboundedKnapsackRecursive(int[] value, int[] weight, int capacity, Integer[] dp){

        if(capacity <= 0){
            return 0;
        }

        if(dp[capacity] != null){
            return dp[capacity];
        }

        int max = 0;

        for(int i = 0; i < weight.length; i++){
            if(capacity < weight[i]) continue;
            max= Math.max(max, unboundedKnapsackRecursive(value, weight, capacity-weight[i], dp) + value[i]);
        }
        
        dp[capacity] = max;
        return dp[capacity];
    }

    // LeetCode Hard Problem 44:  Wild Card Match
    public boolean isMatch(String s, String p) {

        int i = p.length();
        int j = s.length();

        Boolean[][] dp = new Boolean[i][j];

        char[] pCharArray = p.toCharArray();
        char[] sCharArray = s.toCharArray();

        return WCM(pCharArray, sCharArray, i-1, j-1, dp);
    }

    public boolean WCM(char[] pCharArray, char[] sCharArray, int i, int j, Boolean[][] dp){

        if(i < 0 && j < 0){
            return true;
        }

        if( i < 0 || j < 0){
            if(i >= 0 && checkStar(pCharArray, i)) return true;
            return false;
        }

        if(dp[i][j] != null) return dp[i][j];

        if(pCharArray[i] == sCharArray[j] || pCharArray[i] == '?' ){
            dp[i][j] = WCM(pCharArray, sCharArray, i-1, j-1, dp);
        }

        else if(pCharArray[i] == '*'){
            dp[i][j] = WCM(pCharArray, sCharArray, i-1, j, dp) || WCM(pCharArray, sCharArray, i, j-1, dp);
        }

        else if (pCharArray[i] != sCharArray[j]){
            dp[i][j] = false;
        }

        return dp[i][j];
    }

    public boolean checkStar(char[] pCharArray, int i){

        for(int k = i; k >= 0; k--){
            if(pCharArray[k] != '*') return false;
        }
        return true;
    }


    // Problem : Matrix Chain Multiplication: For given N matrix you have to find the minimum
    // cost to multiply all of them

    // Input A = {3,5,7,4} -> shows three Matrix M1(3*5) M2(5*7) M3(7*4)

    public int matrixChainMultiplyCost(int[] A){

        Integer[][] dp = new Integer[A.length][A.length];

        return mcm(A, 1, A.length-1, dp);
    }

    public int mcm(int[] A, int i, int j, Integer[][] dp){

        if( i == j) return 0;

        if(dp[i][j] != null) return dp[i][j];

        int cost = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++){
            int l = mcm(A, i, k , dp);
            int r = mcm(A, k+1, j, dp);
            int c = A[i-1] * A[k] * A[j];
            cost = Math.min(cost, l+c+r);
        }
        dp[i][j] = cost;

        return cost;
    }

    public int numTrees(int n) {

        int[] catalan = new int[n+1];

        catalan[0] = 1;
        catalan[1] = 1;

        for(int i = 2 ; i <= n; i++){
            int cat = 0;
            for( int j = 0 ; j < i ; j++){
                cat += catalan[j]*catalan[i-1-j];
            }
            catalan[i] = cat;
        }
        return catalan[n];
    }


    // Leetcode Problem : 322 -> Coin Change

    // Top-Down Approach
    public int coinChangeTD(int[] coins, int amount) {

        Integer[] dp = new Integer[amount+1];

        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != -1) {
                    min = Math.min(min, 1 + dp[i - coin]);
                }
            }

            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return dp[amount];
    }


    // Coin Change : Bottom Up Approach
    public int coinChangeBU(int[] coins, int amount) {

        Integer[] dp = new Integer[amount+1];

        return helper(coins, amount, dp);
    }

    public int helper(int[] coins, int amount, Integer[] dp){

        if(amount < 0) return -1;

        if(amount == 0) return 0;

        if(dp[amount] != null) return dp[amount];

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = helper(coins, amount - coin, dp);
            if (result >= 0)
                min = Math.min(min, 1 + result);
        }

        dp[amount] = min == Integer.MAX_VALUE ? -1 : min;

        return dp[amount];
    }

}
