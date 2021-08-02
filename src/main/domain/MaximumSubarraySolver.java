package main.domain;

import java.util.HashMap;
import java.util.HashSet;

public class MaximumSubarraySolver {

    public void test() {

//        int solution = this.solve(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
//        int solution = this.solve(new int[]{5,4,-1,7,8,-20,9,11,23});
//        int solution = this.solve(new int[]{1});
//        int solution = this.solve(new int[]{-3,-2,-1});
//        int solution = this.solve(new int[]{-3,-2,-1});
        int solution = this.maxSubArray(new int[]{-3,-2,-1});
        System.out.println(solution);
        assert solution == 1;

    }

    public int solve(int[]  nums) {
        int cache = nums[0];
        int sum = cache;

        for (int i = 1; i < nums.length; i++)  {
            if (nums[i] > sum) {
                cache = nums[i];
                sum =cache;
            } else {
                int newSum = nums[i] + cache;

                if (newSum > 0) {
                    cache = newSum;
                }
                if (newSum > sum) {
                    sum = cache;
                }
            }

        }
        return sum;
    }
// -3,-2,-1, 4,-1,2
    public int maxSubArray(int[] nums) {
        int globalMax = Integer.MIN_VALUE;
        int localMax = 0;
        // 要是加入之前的 localMax 到 第 i 个数，会使得 第 i 个数变更小, 那就不要前面的了
        // 返回所有可能序列里的最大值
        for (int i =0; i < nums.length; i++){
            if (localMax<0){
                localMax =  nums[i];
            }else{
                localMax = localMax+nums[i];
            }
            // localMax= Math.max(localMax+nums[i],nums[i]);
            globalMax = Math.max(globalMax,localMax);
        }


        return globalMax;


    }
}
