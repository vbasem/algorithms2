package main.dynamic;

import java.util.HashMap;
import java.util.function.Function;

public class DynamicFibonacci {


  public static void main(String[] args) {
    FiboLambda fib = new DynamicFibonacci().fibo();

    System.out.println("fib = " + fib.fib(3));
    System.out.println("fib = " + fib.fib(40));
  }

  public FiboLambda fibo() {
    final HashMap<Integer, Integer> integerHashMap = new HashMap<>();



    return new FiboLambda() {
      int cache = 0;
      @Override
      public Integer fib(Integer number) {
                if (number < 2) {
            return number;
          }
          Integer left = integerHashMap.get(number - 1);

          if (left == null) {
            left = fib(number - 1);
            integerHashMap.put(number - 1, left);
          } else {
            cache++;
            System.out.println("cache: " +cache);
          }
          Integer right = integerHashMap.get(number - 2);
          if (right == null) {
            right = fib(number - 2);
            integerHashMap.put(number - 2, right);
          } else {
            cache++;
            System.out.println("cache: " +cache);
          }
          return left + right;
        }
      };
//    } =
//        number -> {
//          if (number < 2) {
//            return number;
//          }
//          Integer left = integerHashMap.get(number - 1);
//
//          if (left == null) {
//            left = ref.fib.fib(number - 1);
//            integerHashMap.put(number - 1, left);
//          } else {
//            ref.cache++;
//            System.out.println("cache: " +ref.cache);
//          }
//          Integer right = integerHashMap.get(number - 2);
//          if (right == null) {
//            right = ref.fib.fib(number - 2);
//            integerHashMap.put(number - 2, right);
//          } else {
//            ref.cache++;
//            System.out.println("cache: " +ref.cache);
//          }
//          return left + right;
//        };
  }
}

@FunctionalInterface
interface FiboLambda {
  Integer fib(Integer number);
}
