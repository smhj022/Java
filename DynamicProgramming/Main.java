package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DynamicProgramming dp = new DynamicProgramming();

        String s = "abceb";
        String p = "a*b";

        System.out.println(dp.isMatch(s,p));

        System.out.println(dp.matrixChainMultiplyCost(new int[]{3,5,7,4}));

        dp.numTrees(6);
    }
}
