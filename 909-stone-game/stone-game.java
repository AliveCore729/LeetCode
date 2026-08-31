class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // dp[i][j] = best score difference (current player - opponent)
        // achievable by the player to move, considering piles[i..j]
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = piles[i];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(
                    piles[i] - dp[i + 1][j],
                    piles[j] - dp[i][j - 1]
                );
            }
        }

        return dp[0][n - 1] > 0;
    }
}