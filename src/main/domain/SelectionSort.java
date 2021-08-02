package main.domain;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args)  {
        int[] data = {6,5,1,4,100, 99, -1};
        new SelectionSort().sort(data);
        System.out.println(Arrays.toString(data));
        assert Arrays.equals(data, new int[]{1, 4, 5, 6, 99, 100}) : "array wasnt sorted";
    }


    public void sort(int[] nums) {

        for (int i=0; i < nums.length -1; i++) {
            int smallestValue = nums[i];
            int smallestValueIndex = i;
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[k] < smallestValue) {
                    smallestValue = nums[k];
                    smallestValueIndex = k;
                }
            }
            nums[smallestValueIndex] = nums[i];
            nums[i] = smallestValue;
        }
    }
}
