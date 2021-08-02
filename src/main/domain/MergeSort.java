package main.domain;

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    int[] input = new int[] {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
    MergeSort sorter = new MergeSort();
    int[] sort = sorter.sort(input);
    System.out.println(Arrays.toString(sort));
    assert Arrays.equals(sort, new int[] {0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283});
  }

  public int[] sort(int[] data) {
    return helper(data);
    // find mid
    // sort left
    // sort right
  }

  // divide into halves
  // recursive half sort
  // if 1 element return, else mege half again
  // merge the results
  // results is the size of both halves
  // walk through all elemnts of both arrays, comparing arr1 with arr2,
  // if arr2 is empty
  // add arr1 to result
  // if arr1 is empty
  // add arr2 to result
  // if element in arr1 < arr2
  // add arr1 to result
  // if e1 @ arr1 > e2 @arr2
  // while arr1 > arr2

  public int[] helper(int[] data) {
    if (data.length  < 2) {
      return data;
    }
    int mid = data.length / 2;

    return merge(
        helper(Arrays.copyOfRange(data, 0, mid)),
        helper(Arrays.copyOfRange(data, mid , data.length)));
  }

  protected int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    int resultIndex = 0;
    int leftIndex = 0;
    int rightIndex = 0;

    while (leftIndex < left.length && rightIndex < right.length) {
      if (left[leftIndex] < right[rightIndex]) {
        result[resultIndex++] = left[leftIndex++];
      } else {
        result[resultIndex++] = right[rightIndex++];
      }
    }

    for (int i = leftIndex; i< left.length; i++) {
      result[resultIndex++] = left[i];
    }

    for (int i = rightIndex; i< right.length; i++) {
      result[resultIndex++] = right[i];
    }


//    for (int i = 0; i < left.length; i++) {
//      if (rightIndex == right.length) {
//        result[resultIndex++] = left[i];
//        leftIndex++;
//      } else if (left[i] < right[rightIndex]) {
//        result[resultIndex++] = left[i];
//        leftIndex++;
//      } else {
//        while (rightIndex < right.length) {
//          if (left[i] > right[rightIndex]) {
//            result[resultIndex++] = right[rightIndex];
//            rightIndex++;
//          } else {
//            break;
//          }
//        }
//
//          result[resultIndex++] = left[i];
//          leftIndex++;
//      }
//    }

//    for (int i = rightIndex; i < right.length; i++) {
//      result[resultIndex++] = right[i];
//    }

    return result;
  }

  protected void swap(int[] data, int lower, int upper) {
    int temp = data[lower];
    data[lower] = data[upper];
    data[upper] = temp;
  }
}
