package Stacks;

public class Main {
    public static void main(String[] args) {

//        Stack stack = new Stack(3);
//        System.out.println(stack.pop().value); // 1
//        System.out.println(stack.pop().value); // 2
//        System.out.println(stack.pop().value); // 3
//        System.out.println(stack.pop()); // null
//
//        stack.printStack();


        StacksUsingArray stack = new StacksUsingArray();

        stack.push(3);
        stack.push(2);
        stack.push(1);

        stack.printStack();

        stack.pop();
        stack.printStack();








    }
}
