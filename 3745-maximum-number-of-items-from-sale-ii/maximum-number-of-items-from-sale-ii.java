import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int min = Integer.MAX_VALUE;
        int[] a = new int[n + 1]; // frequency of each factor

        for (int[] x : items) {
            a[x[0]]++;
            min = Math.min(min, x[1]);
        }

        int[] b = new int[n + 1]; // count of multiples for each factor
        for (int i = 1; i <= n; i++) {
            if (a[i] > 0) {
                for (int j = i; j <= n; j += i) {
                    b[i] += a[j];
                }
            }
        }

        TreeMap<Integer, Long> map = new TreeMap<>();
        long lim = 2L * min;

        for (int[] x : items) {
            int f = x[0];
            int p = x[1];
            int g = b[f] - 1;

            if (g > 0 && p < lim) {
                map.merge(p, (long) g, Long::sum);
            }
        }

        long ans = 0;
        long rem = budget;

        for (Map.Entry<Integer, Long> e : map.entrySet()) {
            long p = e.getKey();
            long c = e.getValue();

            if (rem < p) break;

            long k = Math.min(c, rem / p);
            ans += k * 2;
            rem -= k * p;
        }

        ans += rem / min;

        return (int) ans;
    }
}
