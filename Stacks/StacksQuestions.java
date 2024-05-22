package Stacks;

import java.util.Arrays;
import java.util.Stack;

/*

1) Question:

Stack: Parentheses Balanced ( ** Interview Question)
Check to see if a string of parentheses is balanced or not.

By "balanced," we mean that for every open parenthesis, there is a matching closing
 parenthesis in the correct order. For example, the string "((()))" has three pairs
 of balanced parentheses, so it is a balanced string. On the other hand, the string
 "(()))" has an imbalance, as the last two parentheses do not match, so it is not
 balanced.  Also, the string ")(" is not balanced because the close parenthesis
 needs to follow the open parenthesis.

 */


class Parentheses {
    public boolean isBalancedParentheses(String testSt) {

        Stack<Character> stack = new Stack<>();
        int parentheseScore = 0;

        for (char currParentheses : testSt.toCharArray()) {
            if (currParentheses == '(') {
                parentheseScore += 1;
            } else {
                parentheseScore -= 1;
            }
            if (parentheseScore < 0) return false;
        }
        return parentheseScore == 0;

    }
}


/*
Question 2: Sorted the stack
*/


class StackSorting{

    public void sortStack(Stack<Integer> stack) {

        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {

            int currElem = stack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > currElem) {
                stack.push(tempStack.pop());
            }
            tempStack.push(currElem);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

}


class Questions{

    // Given an array of positive integers, for every given element i find the nearest elem
    //on left which is smaller than A[i];

    public int[] nextMinimumOnLeft(int[] nums){

        Stack<Integer> stack = new Stack<>();

        int[] res = new int[nums.length];

        for(int i = 0 ; i < nums.length; i++){

            if(stack.isEmpty()){
                res[i] = -1;
            } else {

                while(!stack.isEmpty() && stack.peek() >= nums[i]){
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }
            }
            stack.push(nums[i]);
        }

        return res;
    }

    //LeetCode : 1475. Final Prices With a Special Discount in a Shop
    public int[] finalPrices(int[] prices) {

        Stack<Integer> stack = new Stack<>();

        for (int i = prices.length-1; i >= 0; i--){

            int elem = prices[i];

            if(stack.isEmpty()){
                stack.push(prices[i]);
            } else {

                while (!stack.isEmpty() && stack.peek() >= prices[i]) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    prices[i] -= stack.peek();
                }

                stack.push(elem);
            }
        }
        return prices;
    }

    // Hard Problem:
    //LeetCode : 84. Largest Rectangle in Histogram

    public int largestRectangularArea(int[] heights){

        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();

        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        for(int i = 0; i < heights.length; i++){

            if(stack.isEmpty()) {
                left[i] = 0;
            } else{
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()) left[i] = 0;
                else left[i] = stack.peek()+1;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            stack.pop();
        }

        for(int i = heights.length - 1; i >= 0 ; i--){

            if(stack.isEmpty()){
                right[i] = heights.length -1;
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()) right[i] = heights.length -1;
                else right[i] = stack.peek()-1;
            }
            stack.push(i);
        }

        for(int i = 0; i < left.length; i++){
            int area = (right[i] - left[i] + 1) * heights[i];
            if(maxArea < area) maxArea = area;
        }

        return maxArea;
    }

    // Hard Problem 224: basic calculator :
    public int calculate(String s) {

        int number = 0;
        int result = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == ' ') continue;

            if (c == '+') {
                result += sign * number;
                sign = 1;
                number = 0;
            } else if (c == '-') {
                result += sign * number;
                sign = -1;
                number = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                result *= stack.pop();
                result += stack.pop();
                sign = 1;
                number = 0;
            } else {
                number = number * 10 + Character.getNumericValue(c);
            }
        }

        result += sign*number;

        return result;
    }



    // LeetCode problem 71 : Simplify Path (difficulty medium);
    public String simplifyPath(String path){

        Stack<String> stack = new Stack<>();

        for(String name: path.split("/")){
            if(name.isEmpty()) continue;

            if(name.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }

            else if(name.equals(".")) continue;

            else{
                stack.push(name);
            }
        }

        if(stack.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();

        for(String s: stack){
            sb.append("/");
            sb.append(s);

        }

        return sb.toString();
    }

}
public class StacksQuestions{
    public static void main(String[] args) {

        Questions ques = new Questions();

        int[] arr = new int[]{2,1,3,5,4,3,4,6};

        System.out.println(Arrays.toString(ques.nextMinimumOnLeft(arr)));

}