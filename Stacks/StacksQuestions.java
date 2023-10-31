package Stacks;

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


public class StacksQuestions{
    public static void main(String[] args) {

        Parentheses parentheses = new Parentheses();

        System.out.println(parentheses.isBalancedParentheses("(()()()())"));

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(0);
        stack.push(1);
        stack.push(4);

        StackSorting sorting = new StackSorting();

        sorting.sortStack(stack);

        for (int i = stack.size()-1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }

    }
}