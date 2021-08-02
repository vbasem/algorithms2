package main.domain;

public class Factorial {

    public static void main(String[] args ) {
        int data = 5;
        int result = new Factorial().solve(data);
        assert result == (5*4*3*2*1) : "facotrial wasnt correct";
    }

    private int solve(int number) {
        return this.calculate(number, 1);
    }

    private int calculate(int number, int accumulator) {
        if (number == 0) {
            return accumulator;
        }

        return calculate(number-1, accumulator * number);
    }
}
