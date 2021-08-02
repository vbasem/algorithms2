package main.domain;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] input = new int[]{ 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        InsertionSort sorter = new InsertionSort();
        sorter.sort(input);
        System.out.println(Arrays.toString(input));
        assert Arrays.equals(input, new int[]{0,1,2,4,5,6,44,63,87,99,283});

    }

    public void sort(int[] data) {
        for (int i = 0; i< data.length -1; i++) {
            if (data[i] > data[i+1]) {
                for (int k = i + 1; k >= 1 ; k--) {
                    if ( data[k-1]  < data[k]) {
                        break;
                    }
                    int temp = data[k-1];
                    data[k-1] = data[k];
                    data[k] = temp;

                }
            }

        }


    }
}
