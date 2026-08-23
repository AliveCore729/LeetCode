class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;
        
        long sum1 = 0, sum2 = 0;
        long cnt1 = 0, cnt2 = 0;
        
        for (int i = 0; i < half; i++) {
            if (num.charAt(i) == '?') cnt1++;
            else sum1 += num.charAt(i) - '0';
        }
        for (int i = half; i < n; i++) {
            if (num.charAt(i) == '?') cnt2++;
            else sum2 += num.charAt(i) - '0';
        }
        
        long totalQ = cnt1 + cnt2;
        
        // Odd total '?' count -> Alice can always break symmetry and win
        if (totalQ % 2 != 0) return true;
        
        // Even total '?' count -> Bob wins iff diff matches this exact value
        long diff = sum1 - sum2;
        long target = 9 * (cnt2 - cnt1) / 2;
        
        return diff != target;
    }
}