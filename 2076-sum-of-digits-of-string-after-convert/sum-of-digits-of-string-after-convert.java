class Solution {
    public int getLucky(String s, int k) {
        int a = 0;

        for (char c : s.toCharArray()) {
            int x = c - 'a' + 1;
            a += (x / 10) + (x % 10);
        }

        while (k > 1) {
            int b = 0;
            while (a > 0) {
                b += a % 10;
                a /= 10;
            }
            a = b;
            k--;
        }

        return a;
    }
}
