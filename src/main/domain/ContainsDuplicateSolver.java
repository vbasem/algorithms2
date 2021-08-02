package main.domain;

import java.util.HashSet;

public class ContainsDuplicateSolver {

    public void test() {
        int[] veryLargeArray = new int[Integer.MAX_VALUE/2000000];

        for (int i = 0; i < veryLargeArray.length; i++) {
            veryLargeArray[i]=i;
        }
        veryLargeArray[veryLargeArray.length - 1] = 1;

        boolean solve = this.solve2(veryLargeArray);
        System.out.println(solve);
    }

    public boolean solve(int[] numbs) {
       for (int i = 0; i < numbs.length; i = i +1) {
            int currentNumber = numbs[i];
            for (int j = i +1; j < numbs.length; j++) {
                if (numbs[j] == currentNumber) {
                    return true;
                }
            }
       }
        return  false;
    }

    public boolean solve2(int[] numbs) {

        HashSet<Integer> seenNumbers = new HashSet<>();
        for (int i = 0; i < numbs.length; i = i +1) {
            if (seenNumbers.contains(numbs[i])) {
                return true;
            } else {
                seenNumbers.add(numbs[i]);
            }
        }
        return  false;
    }
}
