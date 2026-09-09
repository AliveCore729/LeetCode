class Solution {
    public long countCommas(long n) {
        long ans = 0, p = 1000;
        for (int c = 1; p <= n; c++, p *= 1000)
            ans += (Math.min(n, p * 1000 - 1) - p + 1) * c;
        return ans;
    }
}