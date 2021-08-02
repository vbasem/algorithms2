package main.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMaxNumberRecurssion {

    public static void main(String[] args ) {
        List<Integer> data = new ArrayList<>(Arrays.asList(1,2,3,4,100,6)) ;
        int result = new ListMaxNumberRecurssion().solve(data);
        assert result == 100 : "list max wasnt correct, got: " + result;
    }

    private int solve(List<Integer> data) {
        if (data.size() == 0) {
            return 0;
        }
        return this.calculate(data, 1   , data.get(0));
    }

    protected int calculate(List<Integer> data, int index, int accumulator)  {
        if (index == data.size()) {
            return accumulator;
        }

        return this.calculate(data, index+1, Math.max(accumulator,data.get(index)));
    }


}
