package main.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class StockBuySell {
  public static void main(String[] args) {
    StockBuySell stock = new StockBuySell();
    var stocks =
        new int[] {7, 1, 5, 3, 6, 4, 100, 200, 0, 300, 5, 21, 33, 1000, 29, -1, 2000, 55, 103};

    int profti1 = stock.maxProfit(stocks);
    System.out.println("profti1 = " + profti1);
    System.out.println("stock.calcs = " + stock.calcs);
    System.out.println("stock.cacheHits = " + stock.cacheHits);
  }

  int calcs = 0;
  int cacheHits = 0;

  public int maxProfit(int[] stocks) {

    // start memo
    // base case if we have 1, return the price
    // recurse max of today and tomorrow , vs tomorrow and the rest
    var memo = new int[stocks.length];
    Arrays.fill(memo, -1);

    var profit = calculate(stocks, 0, memo);

    return Math.max(0, profit);
  }

  protected int calculate(int[] stocks, int index, int[] memo) {
    if (index == stocks.length) {
      return 0;
    }
    ArrayList<Integer> d = new ArrayList<>();


    int profit = memo[index];
    if (profit != -1) {
      cacheHits++;
      return profit;
    } else {
      calcs++;
      int maxProfit = 0;
      for (int i = index + 1; i < stocks.length; i++) {
        maxProfit = Math.max(maxProfit, stocks[i] - stocks[index]);
      }

      profit = Math.max(maxProfit, calculate(stocks, index + 1, memo));
      memo[index] = profit;
      return profit;
    }
  }
}
