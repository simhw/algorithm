package com.codingtest.exam.thisiscodingtest.ch16;

// Knapsack
public class Knapsack {
    // Returns the maximum value that can be put in a knapsack of capacity W
    static int recursive(int W, int weight[], int value[], int n) {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W,
        // then this item cannot be included in the optimal solution
        if (weight[n - 1] > W)
            return recursive(W, weight, value, n - 1);

        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        else
            return Math.max(value[n - 1] + recursive(W - weight[n - 1], weight, value, n - 1),
                    recursive(W, weight, value, n - 1));
    }

    static int memoization(int W, int weight[], int value[], int n) {
        int i, w;
        int dp[][] = new int[n + 1][W + 1];

        // Build table dp[][] in bottom up manner
        for (i = 1; i <= n; i++) {
            for (w = 1; w <= W; w++) {
                if (weight[i - 1] <= w)
                    dp[i][w] = Math.max(value[i - 1] + dp[i - 1][w - weight[i - 1]],
                            dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][W];
    }

    // Driver code
    public static void main(String args[]) {
        int value[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 1, 2, 3 };
        int W = 5;
        int n = value.length;
        // System.out.println(recursive(W, weight, value, n));
        System.out.println(memoization(W, weight, value, n));
    }
}
