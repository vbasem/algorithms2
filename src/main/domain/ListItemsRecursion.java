package main.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListItemsRecursion {

    public static void main(String[] args ) {
        List<Integer> data = new ArrayList<>(Arrays.asList(1,2,3,4,5)) ;
        int result = new ListItemsRecursion().solve(data);
        assert result == 5 : "list item count wasnt correct, got: " + result;
    }

    private int solve(List<Integer> data) {
        if (data.size() == 0) {
            return 0;
        }
        data.remove(0);
        return 1 + this.solve(data);
    }


}
