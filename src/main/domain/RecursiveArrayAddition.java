package main.domain;

public class RecursiveArrayAddition {

    public static void main(String[] args ) {
        int[] data = {1,3,4,5, 100};
        int result = new RecursiveArrayAddition().solve(data);
        assert result == 113 : "addition wasnt correct, got " + result;
    }

    private int solve(int[] data) {
        if (data.length == 0) {
            return 0;
        }

        return calculate(data, data[0], 1);
    }

    private int calculate(int[] data, int accumulator, int index)  {
        if (data.length == index) {
            return accumulator;
        }

        return calculate(data, accumulator + data[index], index+1);
    }

}
