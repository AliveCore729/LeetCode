class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        int[] work = freq.clone();
        int matchLen = 0;
        for (int i = 0; i < n; i++) {
            int idx = target.charAt(i) - 'a';
            if (work[idx] > 0) {
                work[idx]--;
                matchLen++;
            } else {
                break;
            }
        }

        int i = matchLen;
        if (i == n) {
            
            i = n - 1;
            work[target.charAt(i) - 'a']++;
        }

        while (i >= 0) {
            int idx = target.charAt(i) - 'a';
            int found = -1;
            for (int ch = idx + 1; ch < 26; ch++) {
                if (work[ch] > 0) {
                    found = ch;
                    break;
                }
            }
            if (found != -1) {
                work[found]--;
                StringBuilder sb = new StringBuilder();
                sb.append(target, 0, i);
                sb.append((char) ('a' + found));
                for (int ch = 0; ch < 26; ch++) {
                    for (int cnt = 0; cnt < work[ch]; cnt++) {
                        sb.append((char) ('a' + ch));
                    }
                }
                return sb.toString();
            }

            
            i--;
            if (i >= 0) {
                work[target.charAt(i) - 'a']++;
            }
        }

        return "";
    }
}