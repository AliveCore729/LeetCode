class Solution {
    public int[] validSequence(String word1, String word2) {
         int n = word1.length();
        int m = word2.length();

        // suf[i] = maximum suffix of word2 that can still be matched
        // starting from word1[i]
        int[] suf = new int[n + 1];
        suf[n] = m;

        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            suf[i] = j + 1;
        }

        int[] ans = new int[m];
        int idx = 0;
        boolean changed = false;

        for (int i = 0; i < n && idx < m; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(idx);

            if (c1 == c2) {
                ans[idx++] = i;
            } else if (!changed && suf[i + 1] <= idx + 1) {
                // Use the one allowed modification here.
                changed = true;
                ans[idx++] = i;
            }
        }

        if (idx == m) return ans;
        return new int[0];
    }
}