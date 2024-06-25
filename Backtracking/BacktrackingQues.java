package Backtracking;
import java.util.*;


public class BacktrackingQues {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }


    // All the subset without duplicates
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
        ArrayList<Integer> curr = new ArrayList<>();
        helperSubsets(A, result, curr, 0);
        return result;
    }

    public void helperSubsets(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result,ArrayList<Integer> curr, int index){

        result.add(new ArrayList<>(curr));

        for(int i = index; i < A.size(); i++){
            curr.add(A.get(i));
            helperSubsets(A, result, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }


    // All the subset of an array contains duplicates
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
        ArrayList<Integer> curr = new ArrayList<>();
        helperSubsetsWithDup(A, result,curr, 0);
        return result;
    }


    public void helperSubsetsWithDup(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result,ArrayList<Integer> curr, int index){

        if(!result.contains(curr)){
            result.add(new ArrayList<>(curr));
        }

        for(int i = index; i < A.size(); i++){
            curr.add(A.get(i));
            helperSubsetsWithDup(A, result, curr, i+1);
            curr.remove(curr.size()-1);

        }
    }


    // Given an array nums of distinct integers, return all the
    // possible permutations. You can return the answer in any order.

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> allPermutations = new ArrayList<>();

        helperPermute(nums, allPermutations, new ArrayList<>());

        return allPermutations;
    }

    public void helperPermute(int[] nums, List<List<Integer>> allPermutations, List<Integer> curr){

        if(nums.length == curr.size()){
            allPermutations.add(new ArrayList<>(curr));
            return;
        }

        for(int num : nums){
            if(curr.contains(num)){
                continue;
            }
            curr.add(num);
            helperPermute(nums, allPermutations, curr);
            curr.remove(curr.size()-1);
        }
    }


    // Given an array nums of integers can have duplicates, return all the
    // possible permutations. You can return the answer in any order.

    public List<List<Integer>> permuteWithDup(int[] nums) {

        List<List<Integer>> allPermutations = new ArrayList<>();

        boolean[] used = new boolean[5];

        helperPermuteWithDup(nums, allPermutations, new ArrayList<>(), used);

        return allPermutations;
    }

    public void helperPermuteWithDup(int[] nums, List<List<Integer>> result, List<Integer> curr, boolean[] used){

        if(nums.length == curr.size() && !result.contains(curr)){
            result.add(new ArrayList<>(curr));
        }

        for(int i = 0; i< nums.length; i++){

            if(used[i]) continue;

            used[i] = true;
            curr.add(nums[i]);
            helperPermuteWithDup(nums, result, curr, used);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }

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

        res[numberSize - N] = 0;
        nDigitNumberUtil(N-1, res);
        res[numberSize - N] = 1;
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


    public void swap(char[] arr, int a, int b){
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    String maxVal;

    public String maxInteger(String num, int k) {

        maxVal = num;

        maxIntegerUtil(num,k,0);

        return maxVal;
    }

    public void maxIntegerUtil(String num, int k, int index){

        if( k==0 || index == num.length()){
            return;
        }

        char max = getMax(num, index);

        for(int i = index; i < num.length(); i++){

            if(num.charAt(i) > num.charAt(index) && num.charAt(i) == max){
                num = swap(num, i, index);

                if (num.compareTo(maxVal) > 0) {
                    maxVal = num;
                }

                maxIntegerUtil(num, k-1, index+1);
                num = swap(num, i, index);
            }
        }
    }

    public static char getMax(String str, int index){

        char[] strArray = str.toCharArray();

        char max = str.charAt(index);

        for(int i = index + 1; i < strArray.length; i++){
            if(max < strArray[i]){
                max = strArray[i];
            }
        }
        return max;
    }

    public String swap(String  str, int a, int b){

        char[] strArray = str.toCharArray();

        char temp = strArray[a];
        strArray[a] = strArray[b];
        strArray[b] = temp;

        return String.valueOf(strArray);
    }




    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append('(');
        generateParenthesisUtil(n, result, sb, 1, 0);

        return result;

    }


    // LeetCode Question 22: Generate Parentheses.
    public void generateParenthesisUtil(int n, List<String> result, StringBuilder curr, int left, int right){

        if(curr.length() == n*2){
            result.add(curr.toString());
            return;
        }

        if(left < n){
            curr.append("(");
            left++;
            generateParenthesisUtil(n,result,curr,left,right);
            curr.deleteCharAt(curr.length()-1);
            left--;
        }
        if (left > right){
            curr.append(")");
            right++;
            generateParenthesisUtil(n,result,curr,left, right);
            curr.deleteCharAt(curr.length()-1);
            right--;
        }

    }

    // N Queen

    public void NQueen(int n){
        int[][] A = new int[n][n];
        NQueenUtils(n,A,0);
    }

    public void NQueenUtils(int n, int[][] A, int row){

        if(row == n){

            return;
        }

        for(int column = 0; column<n; column++){
            if(checkSafety(row, column, A,n)){
                A[row][column] = 1;
                NQueenUtils(n,A, row+1);
                A[row][column] = 0;
            }
        }


    }

    public boolean checkSafety(int row, int column, int[][] A, int n){

        for(int i = row -1; i >= 0 ; i--){
            if(A[i][column] == 1){
                return false;
            }
        }

        int i = row-1;
        int j = column+1;

        while(i >= 0 && j < n){
            if (A[i][j] == 1)
                return false;
            i--;
            j++;
        }

        i = row-1;
        j = column-1;

        while(j >= 0 && i>=0){
            if (A[i][j] == 1)
                return false;
            i--;
            j--;
        }

        return true;
    }

    HashMap<Character, String> map;

    public ArrayList<String> letterCombinations(String A) {

        map = new HashMap<>();

        map.put('0', "0");
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        ArrayList<String> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        helper(A,result,sb,0);

        return result;
    }

    public void helper(String A, ArrayList<String> result, StringBuilder sb, int index){

        if(sb.length() == A.length()){
            result.add(sb.toString());
            return;
        }

        String s = map.get(A.charAt(index));

        for(int i = 0 ; i < s.length(); i++){
            sb.append(s.charAt(i));
            helper(A,result, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    // Rat in the maze problem

    String direction = "DLRU";
    int[] di = { 1, 0, 0, -1 };
    int[] dj = { 0, -1, 1, 0 };

    public List<String> mazePath(int[][] maze){
        List<String> paths = new ArrayList<>();
        int n = maze.length;
        StringBuilder path = new StringBuilder();
        findMazePath(maze, 0, 0, n, path, paths);
        return paths;
    }

    public void findMazePath(int[][] maze, int i, int j, int n, StringBuilder path, List<String> paths){

        if(i == n-1 && j == n-1){
            paths.add(path.toString());
            return;
        }
        maze[i][j] = 0;

        for(int k=0; k < 4; k++){

            int nexti = i +  di[k];
            int nextj = j + dj[k];

            if(isValidMazeBlock(maze, nexti, nextj, n)){
                path.append(direction.charAt(k));
                findMazePath(maze, nexti, nextj, n, path, paths);
                path.deleteCharAt(path.length()-1);
            }
        }
        maze[i][j] = 1;
    }

    public boolean isValidMazeBlock(int[][] maze, int i, int j, int n){
        return i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1;
    }


    boolean isFound;
    public boolean wordSearch(char[][] board, String word){

        int row = board.length;
        int col = board[0].length;

        int[][] block = new int[row][col];

        isFound = false;

        List<List<Integer>> initial = findInitial(board, word.charAt(0), row,col);

        for(List<Integer> indices : initial){
            checkWord(board, word, block, 0, indices.get(0), indices.get(1), row, col);
            if(isFound) return true;
        }
        return isFound;
    }

    public void checkWord(char[][] board, String word, int[][] block, int index, int i, int j, int row, int col) {
        if (index == word.length()) {
            isFound = true;
            return;
        }

        if(isValidWS(i,j,row,col, block) && board[i][j] == word.charAt(index)){
            block[i][j] = 1;

            for (int k = 0; k < 4; k++) {
                int nexti = i + di[k];
                int nextj = j + dj[k];
                checkWord(board, word, block, index + 1, nexti, nextj, row, col);
                if (isFound) return; // return immediately if word is found

            }

            block[i][j] = 0;

        }
    }

    public List<List<Integer>> findInitial(char[][] board, char c, int row, int col){

        List<List<Integer>> initialIndices = new ArrayList<>();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == c){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    initialIndices.add(temp);
                }
            }
        }
        return initialIndices;
    }

    public boolean isValidWS(int i, int j, int row, int col, int[][] block) {
        return i >= 0 && i < row && j >= 0 && j < col && block[i][j] == 0;
    }


    public List<TreeNode> generateTrees(int n) {

        List<TreeNode> result = new ArrayList<>();

        backtrack(n, result, null, 1);

        return result;

    }


    public void backtrack(int n, List<TreeNode> result, TreeNode curr, int index){

        if(countNodes(curr) == n){
            inorderRec(curr);
            result.add(deepCopyRec(curr));
            return;
        }


        for(int i = index; i <= n; i++){

            TreeNode node = new TreeNode(i);
            if(curr == null){
                curr = node;
            }

            if(curr.val < node.val){
                node.left = curr;
                curr = node;
            }

            if(curr.val > node.val){
                node.right = curr;
                curr = node;
            }

            backtrack(n, result, curr, i+1);
            curr = null;
        }
    }

    public int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public TreeNode deepCopyRec(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode newNode = new TreeNode(root.val);
        newNode.left = deepCopyRec(root.left);
        newNode.right = deepCopyRec(root.right);

        return newNode;
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val + " ");
            inorderRec(root.right);
        }
    }

}


