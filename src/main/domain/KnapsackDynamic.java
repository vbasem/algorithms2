package main.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class KnapsackDynamic {
    public static void main(String[] args) {
        HashMap<String, Integer> itemValues = new HashMap<>();
        itemValues.put("guitar", 1500);
        itemValues.put("stereo", 3000);
        itemValues.put("laptop", 2000);
        itemValues.put("iphone", 2000);
        itemValues.put("mp3", 1000);
        HashMap<String, Integer> itemWeights = new HashMap<>();
        itemWeights.put("guitar", 1);
        itemWeights.put("stereo", 4);
        itemWeights.put("laptop", 3);
        itemWeights.put("iphone", 1);
        itemWeights.put("mp3", 1);

        int result = new KnapsackDynamic().solve(itemValues, itemWeights, 4);
    }

    public int solve(HashMap<String, Integer> itemValues, HashMap<String, Integer> itemWeights, int bagSize) {
//        HashMap<String, HashMap<Integer, Integer>> grid = new HashMap<>();
        int[][] grid = new int[itemValues.size()][bagSize];
//        for (int i = 0; i < grid.length; i++) {
//            grid[i] = new int[bagSize];
//        }

//        for (String item : itemValues.keySet()) {
//            grid.put(item, new HashMap<>());
//        }
        int rowIndex = 0;
        for (String item : itemValues.keySet()) {
            for (int colIndex = 0; colIndex < bagSize; colIndex++) {
                int currentBagSize = colIndex + 1;
                Integer prevValue = rowIndex == 0 ? 0 : grid[rowIndex - 1][colIndex];
                int combinedValue = 0;
                if (itemWeights.get(item) <= currentBagSize) {
                    int remainingSpace = currentBagSize - itemWeights.get(item);
                    Integer valueOfRemainingWeight = remainingSpace > 0 && rowIndex > 0 ? grid[rowIndex - 1][remainingSpace - 1] : 0;

                    combinedValue = itemValues.get(item) + valueOfRemainingWeight;
                }
                grid[rowIndex][colIndex] = Math.max(prevValue, combinedValue);

            }
            rowIndex++;
        }
        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(" - ");
            }
            System.out.println(" ");
        }
        return grid[3][3];
    }
}
