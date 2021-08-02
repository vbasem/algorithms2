package main.domain;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,7,100,200,300,400,500};
        boolean result = new BinarySearch().solve(data, 100);
        assert result :"100 should be in the result";


        boolean result2 = new BinarySearch().solve(data, 6);
        assert !result2 : "8 shouldnt be in the result";

        boolean result3 = new BinarySearch().solve(data, 7);
        assert result3 : "7 shouldnt be in the result";



    }
// [1,2,3]
    private boolean solve(int[] nums, int i) {
        if (nums.length == 0) {
            return false;
        }
        return solveInternal(nums, i, 0, nums.length - 1);
    }

    private boolean solveInternal(int[] nums, int i, int start, int end)  {
        System.out.printf("we are looking for %d, between %d - %d\n", i, nums[start], nums[end]);
        if (start == end ) {
            return nums[start] == i;
        }
        int mid = (start + end) /2;

        if (nums[mid] < i) {
            return this.solveInternal(nums, i, mid  + 1 , end);
        } else {
            return this.solveInternal(nums, i, start, mid);
        }
    }
}