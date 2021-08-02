package main.domain;

import java.util.Arrays;
import java.util.HashMap;

public class MoveZerosSolver {

    public static void main(String[] args) {
        new MoveZerosSolver().test();
    }

    public void test() {
        int[] data = {0,0, 1,0,3,12,0,0,4,5,6,7};
        this.solve(data);
        Arrays.stream(data).forEach(System.out::println);
        assert data.equals(new int[] {1,3,12,4,5,6,7,0,0,0,0});
    }
    public void solve(int[] nums) {

        HashMap<Integer, Integer> zerosMap = new HashMap<>();
        int lastZero = -1;

        for (int i =0; i < nums.length; i++) {
            if (nums[i] > 0 && lastZero > -1) {
                nums[lastZero] = nums[i];
                nums[i] = 0;
                lastZero++;
            } else if (lastZero == -1 ) {
                lastZero = i;
            }
        }
    }

}
