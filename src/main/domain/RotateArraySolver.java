package main.domain;

import java.util.Arrays;

public class RotateArraySolver {

    public void test() {

        int[] data = {1,2,3,4,5,6, 7};
        int rotation = 8;
        this.solve(data, rotation);
        Arrays.stream(data).forEach(System.out::println);
        assert data == new int[]{5,6,7,1,2,3,4};
    }

    public void solve(int[] nums, int rotation) {
        int  shift = nums[0];
        int currentElement = 0;
        for (int hops = 0; hops < nums.length; hops++) {
            int nextElemntLocation = currentElement+rotation >= nums.length ? ((currentElement + rotation) % nums.length) : currentElement + rotation;
            int temp = nums[nextElemntLocation];
            nums[nextElemntLocation] = shift;
            shift = temp;
            currentElement = nextElemntLocation;
        }
    }
}
