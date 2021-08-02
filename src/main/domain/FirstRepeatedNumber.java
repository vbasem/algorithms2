package main.domain;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedNumber {


    public static void main(String[] args) {

        int[] data = {1, 5, 3, 5, 1, 2};
        FirstRepeatedNumber firstRepeatedNumber = new FirstRepeatedNumber(data);
        int firstRepeatedNumber1 = firstRepeatedNumber.getFirstRepeatedNumber();
        System.out.println(firstRepeatedNumber1);
        System.out.println(firstRepeatedNumber.getFirstNaive());
        System.out.println(firstRepeatedNumber.getFirstNaiveSimilarBehaviorToHash());
    }

    protected int[] nums;
    protected Set<Integer> seenNumbers = new HashSet<>();

    public FirstRepeatedNumber(int[] nums) {
        this.nums = nums;
    }


    public int getFirstNaiveSimilarBehaviorToHash() {
        for (int i = 0; i < nums.length; i++) {
            for (int k = i; k >= 0; k--) {
                if (k == i) {
                    continue;
                }
                if (nums[i] == nums[k]) {
                    return nums[i];
                }
            }
        }

        return Integer.MIN_VALUE;
    }

    public int getFirstNaive() {
        for (int i = 0; i < nums.length; i++) {
            for (int k = 0; k < nums.length; k++) {
                if (nums[i] == nums[k]) {
                    return nums[i];
                }
            }
        }

        return Integer.MIN_VALUE;
    }

    public int getFirstRepeatedNumber() {

        // for each number, add it to a hash set, if we havent seen it before
// if we have seen it return
        for (int i = 0; i < nums.length; i++) {
            if (isRepeatedNumber(nums[i])) {
                return nums[i];
            } else {
                updatedSeenNumbers(nums[i]);
            }
        }

        return Integer.MIN_VALUE;
    }

    public boolean isRepeatedNumber(int number) {
        return this.seenNumbers.contains(number);
    }

    public void updatedSeenNumbers(int number) {
        this.seenNumbers.add(number);
    }


}
