class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        // dp[i] = best score difference (current player - opponent) 
        // achievable by the player to move, considering stones[i..n-1]
        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;
            int sum = 0;
            for (int x = 1; x <= 3 && i + x <= n; x++) {
                sum += stoneValue[i + x - 1];
                dp[i] = Math.max(dp[i], sum - dp[i + x]);
            }
        }

        if (dp[0] > 0) return "Alice";
        else if (dp[0] < 0) return "Bob";
        else return "Tie";
    }
}