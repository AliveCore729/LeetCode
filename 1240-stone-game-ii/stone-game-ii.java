class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        Integer[][] memo = new Integer[n][n + 1];
        return dfs(0, 1, piles, suffixSum, memo);
    }

    private int dfs(int i, int m, int[] piles, int[] suffixSum, Integer[][] memo) {
        int n = piles.length;
        if (i >= n) return 0;

        // If remaining piles can all be taken in one move, take everything
        if (i + 2 * m >= n) {
            return suffixSum[i];
        }

        if (memo[i][m] != null) return memo[i][m];

        int best = 0;
        for (int x = 1; x <= 2 * m; x++) {
            // current player gets: total remaining - whatever opponent gets optimally next
            int opponent = dfs(i + x, Math.max(m, x), piles, suffixSum, memo);
            int mine = suffixSum[i] - opponent;
            best = Math.max(best, mine);
        }

        memo[i][m] = best;
        return best;
    }
}