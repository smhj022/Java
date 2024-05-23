package Queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueueQuestions {


    //Question : Find the nth number that can be constructed using only with digits 1 & 2.

    public int nthDigit(int n){

        Queue<Integer> queue = new LinkedList<>() {};

        int iter = 1;

        queue.add(1);
        queue.add(2);

        while(iter < n){
            int curr = queue.poll();
            queue.add(curr*10 + 1);
            queue.add(curr*10 + 2);
            iter++;
        }
        return queue.peek();
    }


    public int nthPerfect(int n){


        Queue<Integer> queue = new LinkedList<>() {};

        ArrayList<Integer> result = new ArrayList<>();

        queue.add(1);
        queue.add(2);
        int iter = 0;

        while(iter < n){
            int curr = queue.poll();
            result.add(curr);
            queue.add(curr*10 + 1);
            queue.add(curr*10 + 2);
            iter++;
        }

        int i = 1;
        for(int num : result) {
            int x = Integer.toString(num).length();
            System.out.println(i++ + " " +  (int)( num*Math.pow(10,x) + reverse(num)));
        }
        return queue.peek();
    }

    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) return 0;
            reversed = reversed * 10 + digit;
        }
        return reversed;
    }
}
