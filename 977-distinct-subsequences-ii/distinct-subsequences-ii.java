class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        long dp = 1;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            long newDp = (dp * 2) % MOD;
            if (last[c] != -1) {
                newDp = (newDp - last[c] + MOD) % MOD;
            }
            last[c] = (int) dp;
            dp = newDp;
        }

        return (int) ((dp - 1 + MOD) % MOD); 
    }
}