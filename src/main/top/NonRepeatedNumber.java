package main.top;

public class NonRepeatedNumber {

  public static void main(String[] args) {
    System.out.println(
        "new NonRepeatedNumber().solveUnique(new int[]{1,2,1,2,3}) = "
            + new NonRepeatedNumber().solveUnique(new int[] {1, 2, 1, 2, 3}));
  }

  public int solveUnique(int[] data) {
      int a= 0;
      for (int i = 0; i < data.length; i++) {
          a = a ^ data[i];
      }

      return a;
  }
}
