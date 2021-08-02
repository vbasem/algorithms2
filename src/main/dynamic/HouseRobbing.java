package main.dynamic;

import java.util.Arrays;

// [2,0,3,4]
public class HouseRobbing {

  public static void main(String[] args) {
    HouseRobbing houseRobbing = new HouseRobbing();

      int[] houses = {2, 8, 4, 5, 3, 7, 6};
      int rob = houseRobbing.rob(houses);
    System.out.println("rob = " + rob);

      int resultR = houseRobbing.robRecursive(houses);
    System.out.println("resultR = " + resultR);
  }

  public int rob(int[] houses) {
    int maxNumberOfSteals = houses.length > 4 ? 3 : houses.length / 2;
    int[][] solutionMatrix = new int[maxNumberOfSteals][houses.length];
    int max = 0;
    for (int i = 0; i < maxNumberOfSteals; i++) {
      for (int k = 0; k < houses.length; k++) {
        // fill first row with each house value
        if (i == 0) {
          solutionMatrix[i][k] = houses[k];
        } else if (k <= i) {
          solutionMatrix[i][k] = solutionMatrix[i - 1][k];
        } else {
          solutionMatrix[i][k] =
              Math.max(solutionMatrix[i - 1][k], houses[k] + solutionMatrix[i][k - (i + 1)]);
          max = Math.max(max, solutionMatrix[i][k]);
        }

        // if second steal , check for max previous stolen for this house vs. this houses value +
        // stolen at i, k -2 if k >1
      }
    }

    return max;
  }

  public int robRecursive(int[] houses) {
    int[] memo = new int[houses.length];
    Arrays.fill(memo, -1);

    return robR(houses, memo, houses.length - 1);
  }

    private int robR(int[] houses, int[] memo, int i) {
        if ( i  < 2) {
            return houses[i];
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int max = Math.max(robR(houses, memo, i - 2) + houses[i], robR(houses, memo, i -1));
        memo[i] = max;
        return max;
    }
}
