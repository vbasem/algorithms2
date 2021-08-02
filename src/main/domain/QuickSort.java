package main.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class QuickSort {
    public static void main(String[] args) {
//        List<Integer> solve = new QuickSort().solve(Arrays.asList(4, 3, 1, 5, 7, 2, 100, 99, 300, 100, 10, 11));
//        assert solve.equals(Arrays.asList(1, 2, 3, 4, 5, 7, 10, 11, 99, 100, 100, 300)) : "bad array got"+ solve;

        int[] arr= {4, 3, 1, 5, 7, 2, 100, 99, 300, 100, 10, 11};
        new QuickSort().solveInPlace(arr);

        assert Arrays.equals(arr, new int[] {1, 2, 3, 4, 5, 7, 10, 11, 99, 100, 100, 300}) : "bad array got"+ Arrays.toString(arr);

    }

    public List<Integer> solve(List<Integer> nums)  {
        List<Integer> result = new ArrayList<>();
        if (nums.size() == 0) {
            return nums;
        }

        int pivotIndex = nums.size() -1;
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        for (int i =0;i < nums.size(); i++) {
            if (i == pivotIndex) {
                continue;
            }
            if ( nums.get(i) > nums.get(pivotIndex) ) {
                right.add(nums.get(i));
            } else {
                left.add(nums.get(i));
            }
        }

        result.addAll(solve(left));
        result.add(nums.get(pivotIndex));
        result.addAll(solve(right));
        Arrays.sort(new int[] {1,3,4});
        return result;


    }

    public void solveInPlace(int[] arr ) {
        if (arr.length < 2) {
            return;
        }

        this.calculate(arr, 0, arr.length -1);
    }

    private void calculate(int[] arr, int low, int high) {
        int pivot = (high + low ) /2;
        int pv = arr[pivot];

        int left = low;
        int right = high;

        while (left <= right)  {

            while (arr[left] < pv) {
                left++;
            }

            while (arr[right] > pv) {
                right--;
            }


            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        System.out.printf("pivot: %d , left: %d, right %d --- high: %d , low %d  ----> ", pivot, left, right, high, low);
        System.out.println(Arrays.toString(arr));
        if (right > low)  {
            calculate(arr, low, right);
        }

        if (left < high) {
            calculate(arr, left, high);
        }
    }


}
