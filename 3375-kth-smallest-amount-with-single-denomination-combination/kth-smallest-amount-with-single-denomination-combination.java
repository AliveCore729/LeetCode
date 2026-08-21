class Solution {
    private int n;
    private long[] coins;

    public long findKthSmallest(int[] coinsArr, int k) {
        n = coinsArr.length;
        coins = new long[n];
        for (int i = 0; i < n; i++) coins[i] = coinsArr[i];

        long lo = 1, hi = 0;
        long minCoin = Long.MAX_VALUE;
        for (long c : coins) minCoin = Math.min(minCoin, c);
        hi = minCoin * k; // upper bound: kth multiple of smallest coin

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (countUpTo(mid) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // Count of numbers in [1, x] that are multiples of at least one coin
    // via inclusion-exclusion over all non-empty subsets of coins.
    private long countUpTo(long x) {
        long count = 0;
        int total = 1 << n;
        for (int mask = 1; mask < total; mask++) {
            long lcm = 1;
            int bits = Integer.bitCount(mask);
            boolean overflow = false;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    lcm = lcmSafe(lcm, coins[i], x);
                    if (lcm == -1) { // overflow / exceeds x
                        overflow = true;
                        break;
                    }
                }
            }
            if (overflow || lcm > x) continue;
            if (bits % 2 == 1) {
                count += x / lcm;
            } else {
                count -= x / lcm;
            }
        }
        return count;
    }

    // returns -1 if lcm exceeds x (no need for exact value beyond that)
    private long lcmSafe(long a, long b, long limit) {
        long g = gcd(a, b);
        long ratio = b / g;
        // a * ratio could overflow; check before multiplying
        if (a > limit / ratio) return -1; // a * ratio > limit
        long result = a * ratio;
        if (result > limit) return -1;
        return result;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}