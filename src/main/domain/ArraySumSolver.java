package main.domain;

import java.util.HashMap;

class Solution {
    boolean found;
    int firstIndex;
    int secondIndex;
}


class FailedSolution extends Solution {
    public FailedSolution() {
        super();
        this.found = false;
    }
}
class SuccessSolution extends Solution{
    public SuccessSolution(int first, int second)  {
        super();
        this.firstIndex = first;
        this.secondIndex = second;
    }
}


public class ArraySumSolver {

    public void test() {
        Solution sol = this.findFor(new int[]{}, 5);
        System.out.println(sol);
    }
    public Solution findFor(int[] nums, int target) {
        // create a map for numbers
        //  for  number in nums
        // if we have target number in map -> return their indices
        // otherwise add number with its corresponding index  to the map

        HashMap<Integer, Integer> numberIndexLookup =	new HashMap<Integer, Integer>();
        for (int i =0; i < nums.length;i++) {
            if (numberIndexLookup.containsKey(target - nums[i])) {
                return new SuccessSolution(numberIndexLookup.get(target - nums[i]), i);
            } else {
                numberIndexLookup.put(nums[i], i);
            }
        }
        return new FailedSolution();

    }
}
