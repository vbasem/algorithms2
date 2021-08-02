package sumoftwointegers;

public class SumOfTwoIntegers {

  public static void main(String[] args) {
    System.out.println("new SumOfTwoIntegers().sumBitWise(3,5) = " + new SumOfTwoIntegers().sumBitWise(1,2));
    System.out.println("new SumOfTwoIntegers().sumBitWise(3,5) = " + new SumOfTwoIntegers().sumBitWise(3,5));
  }
    public int sumBitWise(int a, int b) {

      while (b != 0)  {


          int carry = a & b;
          a = a ^ b;
          System.out.println("a after: " +  Integer.toBinaryString(a));

          b = carry << 1;
          System.out.println("b after: " +  Integer.toBinaryString(b));

      }
        return a;

    }
}
