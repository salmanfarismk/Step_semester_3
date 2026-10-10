package array.class_problems;

import java.util.Arrays;

/**
 * Problem L2: Best Time to Buy and Sell Stock
 * Scenario: Single-Trade Profit Maximizer
 * 
 * A trainee investor has one week of daily stock prices and wants to know
 * the single best day to buy and the single best later day to sell to make
 * the largest possible profit — found in one simple pass through the prices.
 * 
 * Concepts: Single-pass array traversal, tracking a running minimum and running maximum together.
 */
public class BestTimeToBuyAndSellStock {

    /**
     * Calculates the maximum profit achievable from a single buy-and-sell transaction.
     *
     * @param prices Array of daily stock prices
     * @return The maximum profit, or 0 if no profit is possible
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Profit if sold today
            int currentProfit = prices[i] - minPrice;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }

            // Update lowest price seen so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem L2: Best Time to Buy and Sell Stock ===");

        // Sample 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Input: prices = " + Arrays.toString(prices1));
        System.out.println("Output: " + maxProfit(prices1) + " (Buy at 1, sell at 6, profit = 5)");

        // Sample 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("\nInput: prices = " + Arrays.toString(prices2));
        System.out.println("Output: " + maxProfit(prices2) + " (Prices only fall, profit = 0)");

        // Additional Test Case
        int[] prices3 = {2, 4, 1};
        System.out.println("\nInput: prices = " + Arrays.toString(prices3));
        System.out.println("Output: " + maxProfit(prices3) + " (Buy at 2, sell at 4, profit = 2)");
    }
}
