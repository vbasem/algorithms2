package main.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayMerger {
    // two arras [1,3,7]. [2,3,4] => [1,2, 3,3,4,7]
    // [], [] => []
    // arrays can of difference size and unbounded

    // for item in firstArray
    // go through the items of the biggest  array,
    //  if it is smaller remove from array 2 and add to result
    //  if it is bigger add item from array 1 to result
    //  if it is equal add item from array 1 and arary 2 to result
    public void testCorrect() {
//        Arrays.asList(1,2,3,3,4,7);
        List<Integer> data = mergeSorted(new Integer[]{1, 2, 4}, new Integer[]{1, 3, 5, 7});
        data.forEach(System.out::println);
        if (data.equals(Arrays.asList(1,3,5,7))) {
            System.out.println("GREEN");
        } else {
            System.out.println("RED");

        }
    }

    public List<Integer> mergeSorted(Integer[] arrayOne, Integer[] arrayTwo) {
        ArrayList<Integer> result = new ArrayList<>();

        if (arrayOne == null || arrayOne.length ==0) {
            return Arrays.asList(arrayTwo);
        }

        if (arrayTwo == null || arrayTwo.length ==0) {
            return Arrays.asList(arrayOne);

        }

        int arrayOneIndex=0;
        int arrayTwoIndex=0;


        while (arrayOneIndex != arrayOne.length || arrayTwoIndex != arrayTwo.length) {
            if (arrayOneIndex == arrayOne.length) {
                result.add(arrayTwo[arrayTwoIndex++]);

            } else if (arrayTwoIndex == arrayTwo.length) {
                result.add(arrayOne[arrayOneIndex++]);
            } else if (arrayOne[arrayOneIndex] > arrayTwo[arrayTwoIndex]) {
                result.add(arrayTwo[arrayTwoIndex++]);
            } else {
                result.add(arrayOne[arrayOneIndex++]);
            }
        }

        return result;
    }
    // [1,3,7]. [2,3,4] => [1,2, 3,3,4,7]
    public ArrayList<Integer> merge(int[] biggerArray, int[] smallerArray) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        int lastSmallArrayIndex = 0;
        for (int i = 0; i < biggerArray.length; i++) {
            for (int j =lastSmallArrayIndex; j < smallerArray.length; j++) {
                if (biggerArray[i] >= smallerArray[j]) {
                    integers.add(smallerArray[j]);
                    lastSmallArrayIndex++;
                }
            }
            integers.add(biggerArray[i]);
        }

        return integers;
    }
}
