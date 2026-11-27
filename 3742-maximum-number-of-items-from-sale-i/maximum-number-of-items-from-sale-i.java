class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] dp = new int[budget + 1];
        int minPrice = Integer.MAX_VALUE;

        // 1. 0/1 Knapsack for the first copy of each item (includes free items)
        for (int i = 0; i < n; i++) {
            int factorI = items[i][0];
            int priceI = items[i][1];
            minPrice = Math.min(minPrice, priceI);

            // Count how many other items j are divisible by factorI
            int value = 1;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % factorI == 0) {
                    value++;
                }
            }

            // Iterate backwards so each item's first copy is used at most once
            for (int b = budget; b >= priceI; b--) {
                dp[b] = Math.max(dp[b], dp[b - priceI] + value);
            }
        }

        // 2. Spend any remaining budget on the cheapest item (1 copy per minPrice)
        int maxTotalItems = 0;
        for (int b = 0; b <= budget; b++) {
            int remainingBudget = budget - b;
            int extraCopies = remainingBudget / minPrice;
            maxTotalItems = Math.max(maxTotalItems, dp[b] + extraCopies);
        }

        return maxTotalItems;
    }
}
