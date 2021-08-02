package main.top;

import java.util.Arrays;
import java.util.Objects;

public class FizzBuzz {

  public static void main(String[] args) {

      FizzBuzz buzz = new FizzBuzz();

      String[] result = buzz.fizzBuzz(15);
      System.out.println("buzz.fizzBuzz(3) = " + Arrays.toString(result));
      assert Arrays.equals(result, new String[]{"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"});
  }

    public String[] fizzBuzz(int n) {
        var result = new String[n];

        for (int i = 1; i <= n; i++) {
            String temp = "";

            if (i %3 == 0) {
                temp = temp + "Fizz";
            }
            if (i % 5 == 0) {
                temp = temp + "Buzz";
            }

            if (i % 3 != 0 && i %5 != 0) {
                temp = temp + i;
            }

            result[i-1] = temp;

        }

        return result;

    }


}
