package Backtracking;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        BacktrackingQues bq = new BacktrackingQues();

//        bq.nDigitNumber(3);
//
//        String binaryString = "10"; // Example binary string
//        int decimal = Integer.valueOf(binaryString, 2);
//        System.out.println("Decimal value: " + decimal);
//
//        int[][] maze = {{ 1, 0, 0, 0 },
//                        { 1, 1, 0, 1 },
//                        { 1, 1, 0, 0 },
//                        { 0, 1, 1, 1 }};
//
//        System.out.println(bq.mazePath(maze));

//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'F', 'E', 'E'}
//        };
//        String word = "ABCCED";
//
//        System.out.println(bq.wordSearch(board, word));

        System.out.println(bq.generateTrees(3));

    }
}


