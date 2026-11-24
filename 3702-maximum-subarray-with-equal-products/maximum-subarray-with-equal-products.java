class Solution {
    public int maxLength(int[] nums) {
        int maxVal = 0;
        int totalLcm = 1;
        
        // Precompute maximum possible valid product to prevent integer overflow
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
            totalLcm = lcm(totalLcm, num);
        }
        int maxPossibleProd = totalLcm * maxVal;

        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int prod = 1;
            int currentGcd = 0;
            int currentLcm = 1;

            for (int j = i; j < n; j++) {
                prod *= nums[j];
                currentGcd = gcd(currentGcd, nums[j]);
                currentLcm = lcm(currentLcm, nums[j]);

                if (prod == currentGcd * currentLcm) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                
                // Stop early if product exceeds maximum possible LCM * GCD
                if (prod > maxPossibleProd) {
                    break;
                }
            }
        }
        return maxLen;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
