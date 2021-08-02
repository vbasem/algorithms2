package main.dynamic;

public class StepsCalculator {

  public static void main(String[] args) {
	  StepsCalculator calc = new StepsCalculator();

    System.out.println("calc.calculate() = " + calc.calculate(100));
  }

  public int calculate(int steps) {
  	int[] mem= new int[steps];

    return doCalculate(0, steps, mem);
  }

  public int doCalculate(int current, int steps, int[] mem) {
    if (current > steps) {
      return 0;
    }

    if (current == steps) {
      return 1;
    }
    if (mem[current] == 0) {
        int s =	doCalculate(current + 1, steps, mem) + doCalculate(current + 2, steps, mem);
        mem[current] = s;
	}

    return mem[current];
  }
}
