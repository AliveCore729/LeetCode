class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        // Count characters
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // A palindrome can have at most one odd frequency
        int oddChar = -1;

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                if (oddChar != -1) {
                    return "";
                }
                oddChar = i;
            }
        }

        // Build counts for the first half
        int[] halfCount = new int[26];

        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        int halfLen = n / 2;

        // We want the smallest half >= target's first half
        String targetHalf = target.substring(0, halfLen);

        // First check if targetHalf itself can be formed
        int[] remaining = halfCount.clone();
        boolean possible = true;

        for (int i = 0; i < halfLen; i++) {
            int x = targetHalf.charAt(i) - 'a';

            if (remaining[x] == 0) {
                possible = false;
                break;
            }

            remaining[x]--;
        }

        // If targetHalf is possible, check the palindrome formed from it
        if (possible) {
            String palindrome = makePalindrome(
                targetHalf,
                oddChar,
                n
            );

            if (palindrome.compareTo(target) > 0) {
                return palindrome;
            }
        }

        /*
         * targetHalf itself doesn't work.
         *
         * Find the rightmost position where we can put
         * a character greater than targetHalf[i].
         *
         * Then put all remaining characters in sorted order.
         */
        for (int i = halfLen - 1; i >= 0; i--) {

            // Rebuild remaining counts for targetHalf[0 ... i-1]
            remaining = halfCount.clone();

            boolean prefixPossible = true;

            for (int j = 0; j < i; j++) {
                int x = targetHalf.charAt(j) - 'a';

                if (remaining[x] == 0) {
                    prefixPossible = false;
                    break;
                }

                remaining[x]--;
            }

            if (!prefixPossible) {
                continue;
            }

            int current = targetHalf.charAt(i) - 'a';

            // Try the smallest character greater than targetHalf[i]
            for (int c = current + 1; c < 26; c++) {

                if (remaining[c] == 0) {
                    continue;
                }

                remaining[c]--;

                StringBuilder half = new StringBuilder();

                // Keep prefix same
                half.append(targetHalf.substring(0, i));

                // Increase this character
                half.append((char) ('a' + c));

                // Fill remaining characters as small as possible
                for (int x = 0; x < 26; x++) {
                    while (remaining[x] > 0) {
                        half.append((char) ('a' + x));
                        remaining[x]--;
                    }
                }

                return makePalindrome(
                    half.toString(),
                    oddChar,
                    n
                );
            }
        }

        return "";
    }

    private String makePalindrome(
        String half,
        int oddChar,
        int n
    ) {
        StringBuilder ans = new StringBuilder();

        ans.append(half);

        // Middle character for odd length
        if (n % 2 == 1) {
            ans.append((char) ('a' + oddChar));
        }

        // Reverse half
        for (int i = half.length() - 1; i >= 0; i--) {
            ans.append(half.charAt(i));
        }

        return ans.toString();
    }
}